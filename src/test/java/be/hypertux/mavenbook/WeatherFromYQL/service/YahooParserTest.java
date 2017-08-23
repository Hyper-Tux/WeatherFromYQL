package be.hypertux.mavenbook.WeatherFromYQL.service;

import java.io.InputStream;
import java.time.*;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import be.hypertux.mavenbook.WeatherFromYQL.model.Weather;

public class YahooParserTest
{
	private static Weather localWeather;

	private static Logger log = Logger.getLogger(WeatherFormatter.class);

	@Before
	public void before() throws Exception
    {
        InputStream localStream;

		try {
            localStream = YahooParserTest.class.getClassLoader().getResourceAsStream("ParisWeatherForecast.xml");
        } catch(Exception e) {
			log.error("|||| Exception loading the XML test file : " + e.toString());
            throw e;
        }

		log.info("|||| Loading of the XML test file is ok.");

        try {
			localWeather = new YahooParser().parse(localStream);
		} catch (Exception e) {
			log.error("|||| Exception parsing the stream." + e.toString());
			throw e;
		}

		log.info("|||| Parsing of the XML test file is OK.");
	}

	@Test
	public void testWeatherAttributes() {
		Assert.assertNotNull(localWeather.getLink());
		Assert.assertNotNull(localWeather.getDescription());

		Assert.assertNotNull(localWeather.getUnits());

		Assert.assertNotNull(localWeather.getWind());
		Assert.assertNotNull(localWeather.getLocation());
		Assert.assertNotNull(localWeather.getAstronomy());
		Assert.assertNotNull(localWeather.getAtmosphere());

		Assert.assertNotNull(localWeather.getCondition());
		Assert.assertNotNull(localWeather.getForecastsArray());
		Assert.assertTrue(localWeather.getForecastsArray().length > 0);
	}

	@Test
	public void testWeatherAttributesValue()
    {
        String linkParis = "http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-615702/";

		Assert.assertEquals(linkParis, localWeather.getLink());

		InputStream txtStream = getClass().getClassLoader().getResourceAsStream("ParisWeatherForecastDescription.txt");

		Assert.assertEquals(txtStream.toString(), localWeather.getDescription());

		Assert.assertEquals(615702, localWeather.getWOEID());
	}

	@Ignore
	@Test
	public void testAstronomyAttributes() {
		Assert.assertNotNull(localWeather.getAstronomy().getSunrise());
		Assert.assertNotNull(localWeather.getAstronomy().getSunset());
	}

	@Ignore
	@Test
	public void testAstronomyAttributesValue() {
		Assert.assertEquals(localWeather.getAstronomy().getSunrise(), LocalTime.of(20, 58));
		Assert.assertEquals(localWeather.getAstronomy().getSunset(), LocalTime.of(6, 50));
	}

	@Ignore
	@Test
	public void testAtmosphereAttributesValues()
	{
		Assert.assertEquals(localWeather.getAtmosphere().getHumidity(), 45);
		Assert.assertEquals(localWeather.getAtmosphere().getPressure(), 1014.0f, 0.1);
		Assert.assertEquals(localWeather.getAtmosphere().getRising(), 0);
		Assert.assertEquals(localWeather.getAtmosphere().getVisibility(), 16.1f, 0.1);
	}

	@Ignore
	@Test
	public void testConditionAttributes()
	{
		Assert.assertNotNull(localWeather.getCondition().getDate());
		Assert.assertNotNull(localWeather.getCondition().getText());
	}

	@Ignore
	@Test
	public void testConditionAttributesValue()
	{
		Assert.assertEquals(localWeather.getCondition().getCode(), 28);
		Assert.assertEquals(localWeather.getCondition().getDate(), ZonedDateTime.of
				(2017, 8, 19, 19, 0, 0, 0, ZoneId.of("Europe/Paris")));
		Assert.assertEquals(localWeather.getCondition().getTemp(), 70);
		Assert.assertEquals(localWeather.getCondition().getText(), "Mostly Cloudy");
	}

	@Ignore
	@Test
	public void testForecastsAttributes()
	{
		for (int i = 0; i < localWeather.getForecastsArray().length; i++) {
			Assert.assertNotNull(localWeather.getForecastsArray()[i].getDate());
			Assert.assertNotNull(localWeather.getForecastsArray()[i].getDay());
			Assert.assertNotNull(localWeather.getForecastsArray()[i].getLow());
		}
	}

	@Ignore
	@Test
	public void testForecastsAttributesValues()
	{
		int[] codeArray = {12, 30, 30, 34, 30, 47, 30, 30, 30, 30};
		int[] highArray = {71, 71, 77, 84, 84, 76, 74, 75, 73, 73};
		int[] lowArray = {55, 55, 58, 60, 64, 61, 59, 60, 60, 58};
		String[] textArray = {"Rain", "Partly Cloudy", "Partly Cloudy",
				"Mostly Sunny", "Partly Cloudy", "Scattered Thunderstorms",
				"Partly Cloudy", "Partly Cloudy", "Partly Cloudy", "Partly Cloudy"};

		for (int i = 0; i<localWeather.getForecastsArray().length; i++)
		{
			Assert.assertEquals(codeArray[i], localWeather.getForecastsArray()[i].getCode());
			Assert.assertEquals(LocalDate.of(2017, 8, 19+i), localWeather.getForecastsArray()[i].getDate());
			Assert.assertEquals(DayOfWeek.of(1+i), localWeather.getForecastsArray()[i].getDay());
			Assert.assertEquals(highArray[i], localWeather.getForecastsArray()[i].getHigh());
			Assert.assertEquals(lowArray[i], localWeather.getForecastsArray()[i].getLow());
			Assert.assertEquals(textArray[i], localWeather.getForecastsArray()[i].getText());
		}
	}

	@Ignore
	@Test
    public void testLocationAttributes()
    {
        Assert.assertNotNull(localWeather.getLocation().getCity());
        Assert.assertNotNull(localWeather.getLocation().getCountry());
        Assert.assertNotNull(localWeather.getLocation().getRegion());
    }

	@Ignore
	@Test
    public void testLocationAttributesValue()
    {
        Assert.assertEquals("Paris", localWeather.getLocation().getCity());
        Assert.assertEquals("France", localWeather.getLocation().getCountry());
        Assert.assertEquals(" Ile-de-France", localWeather.getLocation().getRegion());
    }

	@Ignore
	@Test
    public void testUnitsAttributes()
    {
        Assert.assertNotNull(localWeather.getUnits().getDistance());
        Assert.assertNotNull(localWeather.getUnits().getPressure());
        Assert.assertNotNull(localWeather.getUnits().getSpeed());
        Assert.assertNotNull(localWeather.getUnits().getTemperature());
    }

	@Ignore
	@Test
    public void testUnitsAttributesValue()
    {
        Assert.assertEquals("mi", localWeather.getUnits().getDistance());
        Assert.assertEquals("in", localWeather.getUnits().getPressure());
        Assert.assertEquals("mph", localWeather.getUnits().getSpeed());
        Assert.assertEquals("F", localWeather.getUnits().getTemperature());
    }

	@Ignore
	@Test
    public void testWindAttributesValue()
    {
        Assert.assertEquals(70, localWeather.getWind().getChill());
        Assert.assertEquals(290, localWeather.getWind().getDirection());
        Assert.assertEquals(11, localWeather.getWind().getSpeed());
    }
}

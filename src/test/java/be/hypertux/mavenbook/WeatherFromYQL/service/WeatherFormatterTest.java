package be.hypertux.mavenbook.WeatherFromYQL.service;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import be.hypertux.mavenbook.WeatherFromYQL.model.Weather;

import be.hypertux.mavenbook.WeatherFromYQL.service.WeatherFormatter;
import be.hypertux.mavenbook.WeatherFromYQL.service.YahooParser;

public class WeatherFormatterTest
{
	private static Logger log = Logger.getLogger(WeatherFormatter.class);

	@Ignore
	@Test
	public void testFormat() throws Exception {
		InputStream nyData = getClass().getClassLoader().getResourceAsStream("ParisWeatherForecast.xml");
		Weather weather = new YahooParser().parse( nyData );
		String formattedResult = new WeatherFormatter().format( weather );
		InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
		Assert.assertEquals( IOUtils.toString( expected ), formattedResult );
	}
}

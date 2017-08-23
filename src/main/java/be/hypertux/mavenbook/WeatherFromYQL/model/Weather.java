package be.hypertux.mavenbook.WeatherFromYQL.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather
{
    @XmlPath("results/channel/link/text()")
    private String link;

    @XmlPath("results/channel/item/description/text()")
    private String description;

    @XmlPath("results/channel/yw:units")
    private Units units;

    @XmlPath("results/channel/yw:location")
    private Location location;

    @XmlPath("results/channel/yw:wind")
    private Wind wind;

    @XmlPath("results/channel/yw:atmosphere")
    private Atmosphere atmosphere;

    @XmlPath("results/channel/yw:astronomy")
    private Astronomy astronomy;

    @XmlPath("results/channel/item/yw:condition")
    private Condition condition;

    @XmlPath("results/channel/item/yw:forecast")
    private Forecast[] listForecast;

    public String getLink() { return link; }
    public String getDescription() { return description; }
    public Units getUnits() { return units; }
    public Location getLocation() { return location; }
    public Wind getWind() { return wind; }
    public Atmosphere getAtmosphere() { return atmosphere; }
    public Astronomy getAstronomy() { return astronomy; }
    public Condition getCondition() { return condition; }
    public Forecast[] getForecastsArray() { return listForecast; }

    // "http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-615702/"
    public int getWOEID() { return Integer.parseInt(this.getLink().substring(this.getLink().length()-7, this.getLink().length()-1));}

    @Override
    public String toString()
    {
        String str = "<weather link=\"" + this.getLink() + "\">\n" +
                this.getUnits().toString(2) +
                this.getLocation().toString(2) +
                this.getWind().toString(2) +
                this.getAtmosphere().toString(2) +
                this.getAstronomy().toString(2) +
                this.getCondition().toString(2);

        for (Forecast fore : getForecastsArray())
            str += fore.toString(2);

        str += "</weather>\n";

        return str;
    }
}

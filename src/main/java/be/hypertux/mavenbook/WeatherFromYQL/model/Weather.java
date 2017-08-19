package be.hypertux.mavenbook.WeatherFromYQL.model;


import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import be.hypertux.mavenbook.WeatherFromYQL.utils.DayOfWeekXmlAdapter;
import be.hypertux.mavenbook.WeatherFromYQL.utils.LocalDateXmlAdapter;
import be.hypertux.mavenbook.WeatherFromYQL.utils.LocalTimeXmlAdapter;
import be.hypertux.mavenbook.WeatherFromYQL.utils.ZonedDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@XmlRootElement(name = "query")
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather
{

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Astronomy {
        // "8:58 pm"
        @XmlJavaTypeAdapter(LocalTimeXmlAdapter.class)
        @XmlAttribute
        private LocalTime sunset;

        // "6:50 am"
        @XmlJavaTypeAdapter(LocalTimeXmlAdapter.class)
        @XmlAttribute
        private LocalTime sunrise;

        public LocalTime getSunset() { return sunset; }
        public LocalTime getSunrise() { return sunrise; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<astronomy " +
                    "sunset=\"" + this.getSunset().format(DateTimeFormatter.ISO_LOCAL_TIME) + "\" " +
                    "sunrise=\"" + this.getSunrise().format(DateTimeFormatter.ISO_LOCAL_TIME) + "\">\n";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Atmosphere {
        // "45"
        @XmlAttribute
        private int humidity;

        // "1014.0"
        @XmlAttribute
        private float pressure;

        // "0"
        @XmlAttribute
        private int rising;

        // "16.1"
        @XmlAttribute
        private float visibility;

        public int getHumidity() { return humidity; }
        public float getPressure() { return pressure; }
        public int getRising() { return rising; }
        public float getVisibility() { return visibility; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<atmosphere " +
                    "humidity=\"" + this.humidity + "\" " +
                    "pressure=\"" + this.pressure + "\" " +
                    "rising=\"" + this.rising + "\" " +
                    "visibility=\"" + this.visibility + "\"/>\n";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Condition {
        // "28"
        @XmlAttribute
        private int code;

        // "Sat, 19 Aug 2017 07:00 PM CEST"
        @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
        @XmlAttribute
        private ZonedDateTime date;

        // "70"
        @XmlAttribute
        private int temp;

        // "Mostly Cloudy"
        @XmlAttribute
        private String text;

        public int getCode() { return code; }
        public ZonedDateTime getDate() { return date; }
        public int getTemp() { return temp; }
        public String getText() { return text; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<condition " +
                    "code=\"" + this.code + "\" " +
                    "date=\"" + this.date + "\" " +
                    "temp=\"" + this.temp + "\" " +
                    "text=\"" + this.text + "\"/>\n";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Forecast {

        // <yweather:forecast code="12" date="19 Aug 2017" day="Sat" high="71" low="55" text="Rain"/>
        // <yweather:forecast code="30" date="20 Aug 2017" day="Sun" high="71" low="55" text="Partly Cloudy"/>
        // <yweather:forecast code="30" date="21 Aug 2017" day="Mon" high="77" low="58" text="Partly Cloudy"/>
        // <yweather:forecast code="34" date="22 Aug 2017" day="Tue" high="84" low="60" text="Mostly Sunny"/>
        // <yweather:forecast code="30" date="23 Aug 2017" day="Wed" high="84" low="64" text="Partly Cloudy"/>
        // <yweather:forecast code="47" date="24 Aug 2017" day="Thu" high="76" low="61" text="Scattered Thunderstorms"/>
        // <yweather:forecast code="30" date="25 Aug 2017" day="Fri" high="74" low="59" text="Partly Cloudy"/>
        // <yweather:forecast code="30" date="26 Aug 2017" day="Sat" high="75" low="60" text="Partly Cloudy"/>
        // <yweather:forecast code="30" date="27 Aug 2017" day="Sun" high="73" low="60" text="Partly Cloudy"/>
        // <yweather:forecast code="30" date="28 Aug 2017" day="Mon" high="73" low="59" text="Partly Cloudy"/>

        @XmlAttribute
        private int code;

        @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
        @XmlAttribute
        private LocalDate date;

        @XmlJavaTypeAdapter(DayOfWeekXmlAdapter.class)
        @XmlAttribute
        private DayOfWeek day;

        @XmlAttribute
        private int high;

        @XmlAttribute
        private String low;

        @XmlAttribute
        private int text;

        public int getCode() { return code; }
        public LocalDate getDate() { return date; }
        public DayOfWeek getDay() { return day; }
        public int getHigh() { return high; }
        public String getLow() { return low; }
        public int getText() { return text; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<forecast " +
                    "code=\"" + this.code + "\" " +
                    "date=\"" + this.date.format(DateTimeFormatter.BASIC_ISO_DATE) + "\" " +
                    "day=\"" + this.day.getDisplayName(TextStyle.FULL, Locale.FRENCH) + "\" " +
                    "high=\"" + this.high + "\" " +
                    "low=\"" + this.low + "\" " +
                    "text=\"" + this.text + "\"/>\n";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Location
    {
        // "Paris"
        @XmlAttribute
        private String city;

        // "France"
        @XmlAttribute
        private String country;

        // " Ile-de-France"
        @XmlAttribute
        private String region;

        public String getCity() { return city; }
        public String getCountry() { return country; }
        public String getRegion() { return region; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<location " +
                    "city=\"" + this.city + "\" " +
                    "country=\"" + this.country + "\" " +
                    "region=\"" + this.region + "\"/>\n";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Units
    {
        // "mi"
        @XmlAttribute
        private String distance;

        // "in"
        @XmlAttribute
        private String pressure;

        // "mph"
        @XmlAttribute
        private String speed;

        // "F"
        @XmlAttribute
        private String temperature;

        public String getDistance() { return distance; }
        public String getPressure() { return pressure; }
        public String getSpeed() { return speed; }
        public String getTemperature() { return temperature; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<units " +
                    "distance=\"" + this.distance + "\" " +
                    "pressure=\"" + this.pressure + "\" " +
                    "speed=\"" + this.speed + "\" " +
                    "temperature=\"" + this.temperature + "\"/>\n";
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public class Wind {

        // "70"
        @XmlAttribute
        private int chill;

        // "290"
        @XmlAttribute
        private int direction;

        // "11"
        @XmlAttribute
        private int speed;

        public int getChill() { return chill; }
        public int getDirection() { return direction; }
        public int getSpeed() { return speed; }

        @Override
        public String toString() { return this.toString(0); }
        public String toString(int space)
        {
            return StringUtils.repeat(' ', space) + "<wind " +
                    "chill=\"" + this.chill + "\" " +
                    "direction=\"" + this.direction + "\" " +
                    "speed=\"" + this.speed + "\">\n";
        }
    }

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

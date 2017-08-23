package be.hypertux.mavenbook.WeatherFromYQL.model;

import be.hypertux.mavenbook.WeatherFromYQL.utils.LocalTimeXmlAdapter;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Astronomy
{
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
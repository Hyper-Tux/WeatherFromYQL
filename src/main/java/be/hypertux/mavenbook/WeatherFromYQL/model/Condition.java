package be.hypertux.mavenbook.WeatherFromYQL.model;

import be.hypertux.mavenbook.WeatherFromYQL.utils.ZonedDateTimeXmlAdapter;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

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
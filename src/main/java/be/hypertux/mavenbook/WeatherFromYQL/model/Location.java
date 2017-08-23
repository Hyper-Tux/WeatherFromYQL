package be.hypertux.mavenbook.WeatherFromYQL.model;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

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
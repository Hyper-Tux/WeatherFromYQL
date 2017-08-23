package be.hypertux.mavenbook.WeatherFromYQL.model;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

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
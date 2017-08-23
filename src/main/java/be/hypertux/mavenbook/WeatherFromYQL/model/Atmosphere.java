package be.hypertux.mavenbook.WeatherFromYQL.model;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

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
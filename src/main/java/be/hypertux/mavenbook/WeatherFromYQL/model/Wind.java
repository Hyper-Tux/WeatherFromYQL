package be.hypertux.mavenbook.WeatherFromYQL.model;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

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
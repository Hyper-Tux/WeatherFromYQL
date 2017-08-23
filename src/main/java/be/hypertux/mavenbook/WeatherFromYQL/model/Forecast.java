package be.hypertux.mavenbook.WeatherFromYQL.model;

import be.hypertux.mavenbook.WeatherFromYQL.utils.DayOfWeekXmlAdapter;
import be.hypertux.mavenbook.WeatherFromYQL.utils.LocalDateXmlAdapter;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

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
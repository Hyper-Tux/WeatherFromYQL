package be.hypertux.mavenbook.WeatherFromYQL.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalTimeXmlAdapter extends XmlAdapter<String, LocalTime>
{
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("K:m a", Locale.ENGLISH);

    public LocalTimeXmlAdapter() {}

    @Override
    public String marshal(LocalTime lt) throws Exception
    {
        // synchronized (DTF)
        try {
            return lt.format(DTF);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }

    @Override
    public LocalTime unmarshal(String str) throws Exception
    {
        // synchronized (DTF)
        try {
            return LocalTime.parse(str.toUpperCase(), DTF);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }
}

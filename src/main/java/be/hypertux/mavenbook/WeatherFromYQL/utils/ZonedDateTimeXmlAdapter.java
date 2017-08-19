package be.hypertux.mavenbook.WeatherFromYQL.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ZonedDateTimeXmlAdapter extends XmlAdapter<String, ZonedDateTime>
{
    // Mon, 14 Aug 2017 02:00 AM CEST
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("EEE, d MMM yyyy K:m a z", Locale.ENGLISH);

    public ZonedDateTimeXmlAdapter() {}

    @Override
    public String marshal(ZonedDateTime zDT) throws Exception
    {

        // synchronized (DTF)
        try {
            return zDT.format(DTF);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }

    @Override
    public ZonedDateTime unmarshal(String str) throws Exception
    {
        // synchronized (DTF)
        try {
            return ZonedDateTime.parse(str, DTF);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }
}

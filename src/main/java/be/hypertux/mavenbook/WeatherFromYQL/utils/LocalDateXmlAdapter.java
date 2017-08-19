package be.hypertux.mavenbook.WeatherFromYQL.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate>
{
    // 14 Aug 2017
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);

    public LocalDateXmlAdapter() {}

    @Override
    public String marshal(LocalDate date) throws Exception
    {

        // synchronized (DTF)
        try {
            return date.format(DTF);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }

    @Override
    public LocalDate unmarshal(String str) throws Exception
    {
        // synchronized (DTF)
        try {
            return LocalDate.parse(str, DTF);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }
}

package be.hypertux.mavenbook.WeatherFromYQL.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.security.InvalidParameterException;
import java.time.DayOfWeek;

public class DayOfWeekXmlAdapter extends XmlAdapter<String, DayOfWeek>
{
    public DayOfWeekXmlAdapter() {}

    @Override
    public String marshal(DayOfWeek dOW) throws Exception
    {
        // synchronized (DTF)
        try {
            return dOW.toString().substring(0, 1).toUpperCase() + dOW.toString().substring(1);
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }

    @Override
    public DayOfWeek unmarshal(String str) throws Exception
    {
        String[] arrayStr = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        // synchronized (DTF)
        try {
            for (int i=0; i<arrayStr.length ; i++)
                if (arrayStr[i].equals(str.toUpperCase()))
                    return DayOfWeek.of(i+1);

            throw new InvalidParameterException("DEBUG : " + str.toUpperCase() + " is not a day of the week.");
        } catch (Exception e) {
            System.out.println("DEBUG : " + e.toString());
            return null;
        }
    }
}

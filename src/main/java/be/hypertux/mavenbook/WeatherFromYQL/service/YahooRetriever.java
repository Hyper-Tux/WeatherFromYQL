package be.hypertux.mavenbook.WeatherFromYQL.service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);



    public static String getFullUrlStr(String WOEID)
    {
        String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
        String query = "select * from weather.forecast where woeid = " + WOEID;
        String fullUrl=null;

        try {
            fullUrl = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        } catch (Exception e) {
            System.out.println("DEBUG - Error while encoding URL : " + e.toString());
        }

        return fullUrl;
    }

	public static InputStream retrieve(String WOEID) throws Exception
	{
		log.info( "Retrieving Weather Data" );

		URL fullUrl = new URL(YahooRetriever.getFullUrlStr(WOEID));

		return fullUrl.openStream();
	}

}

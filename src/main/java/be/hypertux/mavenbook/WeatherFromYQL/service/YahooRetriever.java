package be.hypertux.mavenbook.WeatherFromYQL.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

    public static String getFullUrlStr(String WOEID) throws UnsupportedEncodingException
    {
        String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
        String query = "select * from weather.forecast where woeid = " + WOEID;
        String fullUrl=null;

        try {
            fullUrl = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        } catch (UnsupportedEncodingException e) {
            log.error("|||| - Error while encoding URL : " + e.toString());
            throw e;
        }

        log.info("|||| - Encoding of the URL is ok.");

        return fullUrl;
    }

	public static InputStream retrieve(String WOEID)
            throws UnsupportedEncodingException, MalformedURLException, IOException
	{
		log.info( "Retrieving Weather Data" );

		URL fullUrl;

		try {
            fullUrl = new URL(YahooRetriever.getFullUrlStr(WOEID));
        } catch (UnsupportedEncodingException|MalformedURLException e) {
		    log.error("|||| Exception while encoding URL : " + e.toString());
		    throw e;
        }

		InputStream is;

		try {
            is = fullUrl.openStream();
        } catch (IOException e) {
            log.error("|||| Exception while opening connection : " + e.toString());
            throw e;
        }
		return is;
	}

}

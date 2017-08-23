package be.hypertux.mavenbook.WeatherFromYQL.service;

import be.hypertux.mavenbook.WeatherFromYQL.utils.UtilsTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class YahooRetrieverTest
{
    private static Logger log = Logger.getLogger(WeatherFormatter.class);

    @Test
    public void retrieveTest() throws Exception
    {
        InputStream xmlLocalStream = null;

        try {
            xmlLocalStream = YahooRetrieverTest.class.getClassLoader().getResourceAsStream("ParisWeatherForecast.xml");
        } catch (Exception e) {
            Assert.fail("DEBUG - Erreur create Stream : " + e.toString());
        }

        String WOEID = "615702";

        InputStream xmlYahooStream = YahooRetriever.retrieve(WOEID);

        if (xmlLocalStream==null)
            Assert.fail("xmlLocalStream is null.");
        if (xmlYahooStream==null)
            Assert.fail("xmlYahooStream is null.");

        Assert.assertTrue("The two InputStream aren't equal, URL = \"" + YahooRetriever.getFullUrlStr(WOEID) + "\".", UtilsTest.isEqual2(xmlLocalStream, xmlYahooStream));

        log.info("|||| retrieveTest is OK.");
    }
}

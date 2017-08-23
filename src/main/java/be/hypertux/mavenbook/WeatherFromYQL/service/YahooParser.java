package be.hypertux.mavenbook.WeatherFromYQL.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import be.hypertux.mavenbook.WeatherFromYQL.model.Weather;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;

public class YahooParser {

	private static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(InputStream xmlStream) throws Exception
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        ValidationEventCollector VEC = new ValidationEventCollector();
        unmarshaller.setEventHandler(VEC);


        Weather w;
		try {
			// w = JAXB.unmarshal(xmlStream, Weather.class);
            w = (Weather) unmarshaller.unmarshal(xmlStream);
		} catch (Exception e) {
			log.error("|||| - Exception unmarshal - " + e.toString(), e);
			throw e;
		} finally {
		    if (xmlStream!=null) {
                try {
                    xmlStream.close();
                } catch (IOException e) {
                    log.error("|||| - Exception while closing stream.");
                }
            }
        }

        for (ValidationEvent event : VEC.getEvents()) {
            log.info("|||| - Event during unmarshalisation : " + event.toString());
            log.info("||| locator : " + event.getLocator().toString());
            log.info("||| linked exception : " + event.getLinkedException().toString());
        }

        log.info("|||| - Unmarshalisation of the stream is ok.");

		return w;
	}
}

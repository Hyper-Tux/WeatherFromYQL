package be.hypertux.mavenbook.WeatherFromYQL.service;

import java.io.InputStream;

import org.apache.log4j.Logger;
import be.hypertux.mavenbook.WeatherFromYQL.model.Weather;

import javax.xml.bind.JAXB;

public class YahooParser {

	private static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(InputStream xmlStream) throws Exception {
		try {
			return JAXB.unmarshal(xmlStream, Weather.class);
		} catch (Exception e) {
			log.debug("DEBUG - Erreur unmarshal - " + e.toString(), e);
			return null;
		}
	}

}

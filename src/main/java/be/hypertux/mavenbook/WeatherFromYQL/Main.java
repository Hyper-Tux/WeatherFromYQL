package be.hypertux.mavenbook.WeatherFromYQL;

import java.io.InputStream;

import be.hypertux.mavenbook.WeatherFromYQL.service.WeatherFormatter;
import be.hypertux.mavenbook.WeatherFromYQL.service.YahooParser;
import be.hypertux.mavenbook.WeatherFromYQL.service.YahooRetriever;
import org.apache.log4j.PropertyConfigurator;
import be.hypertux.mavenbook.WeatherFromYQL.model.Weather;


public class Main {

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));

		// Read the Zip Code from the Command-line (if none supplied, use 60202)
		String zipcode = "615702";
        try {
		  zipcode = args[0];
        } catch( Exception e ) {}

		// Start the program
		new Main(zipcode).start();
	}

	private String zip;

	public Main(String zip) {
		this.zip = zip;
	}
	
	public void start() throws Exception {
		// Retrieve Data
		InputStream dataIn = new YahooRetriever().retrieve( zip );

		// Parse Data
		Weather weather = new YahooParser().parse( dataIn );

		// Format (Print) Data
		System.out.print( new WeatherFormatter().format( weather ) );
	}

}

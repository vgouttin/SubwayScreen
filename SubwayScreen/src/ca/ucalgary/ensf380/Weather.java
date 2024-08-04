package ca.ucalgary.ensf380;

import java.util.regex.*;
import org.jsoup.JSoup;
import java.io.IOException;
import java.net.*;

public class Weather {
	
	//Method to fetch info from weather API
	public getWeather(String cityName) {
		private static String weatherURL = "https://wttr.in/" + cityName;
		//try catch for exceptions
		try {
			Document doc = JSoup.connect(weatherURL).get();
			String allContentInText = doc.text();
			//Need to make regex patterns to only get info needed.
			Pattern pattern = Pattern.compile("[a-zA-Z]+[1-9]{1,2}°C[1-9]{1,2}-[1-9]{1,2}km/h[1-9]{1,2}km/h");
			/*
			 * [a-zA-Z]+: Matches one or more letters (words like "Sunny").
			 * \\s+: Matches one or more whitespace characters (space between words).
			 * [1-9]{1,2}: Matches one or two-digit number.
			 * °C: Matches the Celsius symbol and C.
			 * [1-9]{1,2}: Matches another one or two-digit number.
			 * -: Matches the hyphen.
			 * [1-9]{1,2}km/h: Matches one or two-digit number followed by km/h.
			 * [1-9]{1,2}km/h: Matches another one or two-digit number followed by km/h.
			 */
			
			
		}
}

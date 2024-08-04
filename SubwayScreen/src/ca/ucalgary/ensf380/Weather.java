package ca.ucalgary.ensf380;

import java.util.regex.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Weather {
	
	//Method to fetch info from weather API
	public static String getWeather(String cityName) {
		String weatherURL = "https://wttr.in/" + cityName;
		//try catch for exceptions
		try {
			Document doc = Jsoup.connect(weatherURL).get();
			String allContentInText = doc.text();
			//Need to make regex patterns to only get info needed.
			Pattern pattern = Pattern.compile("([a-zA-Z]+)\\s([0-9]{1,2}°C)\\s([0-9]{1,2}-[1-9]{1,2}km/h)\\s([1-9]{1,2}km)");
			/*
			 * [a-zA-Z]+: Matches one or more letters (words like "Sunny").
			 * \\s+: Matches one or more whitespace characters (space between words).
			 * [1-9]{1,2}: Matches one or two-digit number.
			 * °C: Matches the Celsius symbol and C.
			 * [1-9]{1,2}: Matches another one or two-digit number.
			 * -: Matches the hyphen.
			 * [1-9]{1,2}km/h: Matches one or two-digit number followed by km/h.
			 * [1-9]{1,2}km/h: Matches another one or two-digit number followed by km.
			 */
			Matcher matcher = pattern.matcher(allContentInText);
			if(matcher.find()) {
				String description = matcher.group(1).trim();
				String temperature = matcher.group(2).trim();
				String wind = matcher.group(3).trim();
				String visibility = matcher.group(4).trim();
				
				return weatherOutput(description, temperature, wind, visibility);
					
				}
			else {
				return("No weather info found, please try again");
			}
		} catch (Exception e){
			e.printStackTrace();
			return ("Error getting data from html file, please try again");
			
		}
	}
	
	//Adding time getter in here because I just want to make this whole section of the screen in this one program
	public static String getTime() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
		return time.format(format);
	}
	
	public static String weatherOutput(String description, String temperature, String wind, String visibility) {
		StringBuilder weatherString = new StringBuilder();
		// Constructing the weather output string
		weatherString.append(getTime()).append("\n");
        weatherString.append("Today is: ").append(description).append("\n");
        weatherString.append("Temperature: ").append(temperature).append("\n");
        weatherString.append("Wind: ").append(wind).append("\n");
        weatherString.append("Visibility: ").append(visibility).append("\n");
        
        return weatherString.toString();
	}
	
	
	
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("No command line argument found please retry...");
			return;
		}
		
		String cityName = args[0];
		System.out.print(getWeather(cityName));
	}
}		

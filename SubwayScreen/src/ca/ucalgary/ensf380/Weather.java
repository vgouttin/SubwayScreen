package ca.ucalgary.ensf380;

import java.util.regex.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Weather {

    // Method to fetch info from weather API
	public static String getWeather(String cityName) {
	    String weatherURL = "https://wttr.in/" + cityName;
	    try {
	        Document doc = Jsoup.connect(weatherURL).get();
	        String allContentInText = doc.text();
	        
	        // Print raw content for debugging
	        System.out.println("Raw weather data: " + allContentInText);
	        
	        Pattern pattern = Pattern.compile("([a-zA-Z ]+)(?:\\s+(\\d+ °C))?.*Wind:\\s*(\\d+ km/h).*Visibility:\\s*(\\d+ km)");
	        Matcher matcher = pattern.matcher(allContentInText);
	        
	        if (matcher.find()) {
	            String description = matcher.group(1).trim();
	            String temperature = matcher.group(2) != null ? matcher.group(2).trim() : "N/A";
	            String wind = matcher.group(3) != null ? matcher.group(3).trim() : "N/A";
	            String visibility = matcher.group(4) != null ? matcher.group(4).trim() : "N/A";
	            
	            return weatherOutput(description, temperature, wind, visibility);
	        } else {
	            return "No weather info found, please try again";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error getting data from HTML file, please try again";
	    }
	}


    // Adding time getter in here because I just want to make this whole section of the screen in this one program
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
        if (args.length == 0) {
            System.out.println("No command line argument found, please retry...");
            return;
        }

        String cityName = args[0];
        System.out.print(getWeather(cityName));
    }
}

//javac -d bin -cp libraries/jsoup-1.18.1.jar src/ca/ucalgary/ensf380/Weather.java
//java -cp "bin;libraries/jsoup-1.18.1.jar" ca.ucalgary.ensf380.Weather Calgary,CA

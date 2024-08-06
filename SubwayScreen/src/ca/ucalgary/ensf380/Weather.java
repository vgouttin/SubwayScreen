package ca.ucalgary.ensf380;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Weather {

    public String getTemperature(String cityName) {
        String weatherUrl = "https://wttr.in/" + cityName + "?format=%t"; // Simplified URL to get only temperature

        try {
            Document document = fetchHtmlContent(weatherUrl);
            String content = document.text().trim(); // Get the text and trim any leading/trailing whitespace

            if (!content.isEmpty()) {
                return "Current temperature: " + content;
            } else {
                return "Temperature data not available.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to retrieve temperature.";
        }
    }

    private Document fetchHtmlContent(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public static void main(String[] args) {
        Weather weather = new Weather();
        String cityName = "Calgary";  // Replace with your city name
        String weatherInfo = weather.getTemperature(cityName);
        System.out.println(weatherInfo);
    }
}

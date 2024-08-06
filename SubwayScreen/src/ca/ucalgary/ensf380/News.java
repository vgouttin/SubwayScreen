package ca.ucalgary.ensf380;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class News {
    private static final String NEWS_API_URL = "https://newsdata.io/api/1/news";
    private static final String NEWS_API_KEY = "pub_50109bb228fb4a8154478601b2fc0c8938e2b";

    // Method to fetch news with a keyword
    public String getNewsWithKeyword(String keyword) {
        return fetchNews("q=" + keyword); // Defines the query parameter search
    }

    // Method to fetch general news
    public String getNewsGeneral() {
        return fetchNews(""); // Fetches general news
    }

    // Method to fetch news based on query parameters
    private String fetchNews(String queryParameter) {
        StringBuilder news = new StringBuilder();
        try {
            String newsURL = NEWS_API_URL + "?apikey=" + NEWS_API_KEY + (queryParameter.isEmpty() ? "" : "&" + queryParameter);
            URL url = new URL(newsURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        news.append(line).append("\n");
                    }
                }
            } else {
                System.err.println("Error: HTTP response code " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news.toString();
    }

    // Method to parse and return news titles from JSON response
    public String parseNewsTitles(String jsonResponse) {
        StringBuilder titles = new StringBuilder();
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            // Print the keys available in the JSON object
            System.out.println("Keys in JSON response: " + jsonObject.keySet());

            if (jsonObject.has("articles")) {
                JSONArray articles = jsonObject.getJSONArray("articles");

                for (int i = 0; i < articles.length(); i++) {
                    JSONObject article = articles.getJSONObject(i);
                    String title = article.optString("title", "No title available");
                    titles.append(title).append("\n\n");
                }
            } else {
                titles.append("No articles found in the response.");
            }
        } catch (Exception e) {
            System.out.println("Error parsing news response.");
            e.printStackTrace();
        }
        return titles.toString();
    }
}

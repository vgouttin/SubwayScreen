package ca.ucalgary.ensf380;

import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

//In this file since we want to be able to find news with a keyword or just simply the news
//We need to make 2 different 
public class News {
	private static final String NEWS_API_URL = "https://newsdata.io/free-news-api";//endpoint
	private static final String NEWS_API_KEY = "pub_50109bb228fb4a8154478601b2fc0c8938e2b";
	
	//method to fetch news with keyword
	public String getNewsWithKeyword(String keyword) {
		return fetchNews("q=" + keyword);//defines the query parameter search
	}
	
	public String getNewsGeneral() {
		return fetchNews("");
	}
	
	public String fetchNews(String queryParameter) {
		StringBuilder news = new StringBuilder();
		try {
			String newsURL = NEWS_API_URL + "?apikey=" + NEWS_API_KEY + (queryParameter.isEmpty() ? "" : "&" + queryParameter);
			URL url = new URL(newsURL);
			//Makes new url base on if there is a keyword search or not
			//(queryParams.isEmpty() ? "" : "&" + queryParams); is like an if else statement, if the first part is true put ""
			//otherwise do the other part
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
				String line;
                while ((line = reader.readLine()) != null) {
                    news.append(line).append("\n");
                }
			}
			
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news.toString();
	}
	
}

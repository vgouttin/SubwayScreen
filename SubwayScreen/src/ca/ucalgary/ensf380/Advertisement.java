/*
 * Author: Victor Gouttin
 * Advertisement.java
 * version 1.4
 */

package ca.ucalgary.ensf380;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 * This class handles the connection to a MySQL database and retrieves paths to media files.
 */
public class Advertisement {
    private Connection connection;
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/ads";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Ilovesoccer123!";
    private List<String> mediaPaths;

    //Make connection using 
    public void establishConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
  public List<Ad> createMediaItems() {
        List<String> paths = fetchMediaPaths();
        List<Ad> items = new ArrayList<>();
        for (String path : paths) {
            items.add(new Ad(path));
        }
        return items;
    }
    /**
     * Retrieves file paths of media from the database and stores them in a list.
     * @return a List of Strings where each String is a file path to a media item.
     */
    public List<String> fetchMediaPaths() {
        String query = "SELECT * FROM media_ads";
        mediaPaths = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                mediaPaths.add(resultSet.getString("file_path"));
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return mediaPaths;
    }

    
    
}

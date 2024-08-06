package ca.ucalgary.ensf380;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Advertisement {
    private Connection connection;
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/ads";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Ilovesoccer123!";
    private List<String> mediaPaths;

    public void establishConnection() {
        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            
            // Establish the connection
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return mediaPaths;
    }
}

package ca.ucalgary.ensf380;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Advertisement {
    // Database credentials
    private static final String URL = "jdbc:postgresql://localhost:5432/ads";
    private static final String USER = "postgres";
    private static final String PASS = "Ilovesoccer123!";
    
    private Connection myConnect;
    private ArrayList<Ad> ads;

    // Constructor
    public Advertisement() throws SQLException {
        ads = new ArrayList<>(); // Initialize the ads list
        makeConnection();
    }
	//1. Opening connection using drivermanager to db
	//Standard procedure for making connection
	//Can't just do try catch because SQLException type has to define a explicit constructor
    // Open a connection to the database
    public void makeConnection() {
        try {
            myConnect = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (myConnect != null && !myConnect.isClosed()) {
                myConnect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Now need to make a method to get adds that creates a statement (2) and executes statement (3)
  	//Make List of Ads to get all the ads and we can use them later (regex?)
    // Retrieve ads from the database
    public ArrayList<Ad> getAds() {
        String query = "SELECT * FROM adtable";
      //try catch for sql exception again
      //here i am creating a statement and executing it
      //for every iteration of the database i assign the values to variables and store them as Ad class in a List of Ad instances
        try (Statement myStmt = myConnect.createStatement();
             ResultSet results = myStmt.executeQuery(query)) {
             
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                String filePath = results.getString("file_path");
                Ad ad = new Ad(id, name, filePath);
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}

package ca.ucalgary.ensf380;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//The name of this file is kind of deceiving, this is the file for fetching from db and returning a list of ads
public class Advertisement  {
	//In this file I will pull the information from my ads database
	//private static final for access tokens to db
	private static final String URL = "jdbc:postgresql://localhost:5432/ads";
	private static final String user = "postgres";
	private static final String pass = "Ilovesoccer123!";
	private Connection myConnect;
	private ArrayList<Ad> ads; // make here so its accessible within this file
	
	
	//Add constructor with throws key word
	public Advertisement() throws SQLException {
		makeConnection();
	}
	//1. Opening connection using drivermanager to db
	//Standard procedure for making connection
	//Can't just do try catch because SQLException type has to define a explicit constructor
	public void makeConnection() {
		try {
			myConnect = DriverManager.getConnection(URL, user, pass); //makes connection class myConnect iteration using DriverManager to make a connection
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	//Make close connection method
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
	public ArrayList<Ad> getAds(){
		//try catch for sql exception again
		//here i am creating a statement and executing it
		//for every iteration of the database i assign the values to variables and store them as Ad class in a List of Ad instances
		try {
			Statement myStmt = myConnect.createStatement();
			ResultSet results = myStmt.executeQuery("SELECT * FROM adtable");
			while (results.next()) {
				int key = results.getInt("key");
				String name = results.getString("name");
				String file_path = results.getString("file_path");
				Ad ad = new Ad(key, name, file_path);
				ads.add(ad);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return ads;
	}
	
	
}
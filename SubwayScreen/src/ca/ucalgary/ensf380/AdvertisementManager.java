package ca.ucalgary.ensf380;

import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.sql.SQLException;
import java.sql.*;

//This class will deal with displaying the ads
public class AdvertisementManager {
	private Timer adTimer = new Timer(); 
	private int index = 0;
	private List<Ad> ads;
	
	//constructor to be called in file will display a
	public AdvertisementManager() throws SQLException {
		Advertisement advertisements = new Advertisement();
		ads = advertisements.getAds();
		displayAds();
	}
	
	public void startTimerForAd() {
		
	}
	public void displayAds() {
		
	}
}

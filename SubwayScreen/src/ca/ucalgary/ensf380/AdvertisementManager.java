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
	private ArrayList<Ad> ads;
	private String file_path;
	private static final int AD_DISPLAY_TIME = 10000;
	private static final int MAP_DISPLAY_TIME = 5000;
	
	//constructor to be called in file will get singular ad
	public AdvertisementManager() throws SQLException {
		
		Advertisement advertisements = new Advertisement();
		ads = advertisements.getAds();
		for(int i = index; i <= ads.size(); i++) {
			file_path = ads.get(i).getFile_Path();
			displayAds();
		}
	}

	public void startTimerForAd() {
		adTimer.schedule(null, 0, AD_DISPLAY_TIME);
		
	}
	public void displayAds() {
		
	}
}

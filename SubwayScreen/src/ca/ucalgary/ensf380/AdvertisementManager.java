package ca.ucalgary.ensf380;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdvertisementManager {
    private Timer adTimer = new Timer();
    private Timer mapTimer = new Timer();
    private ArrayList<Ad> ads;
    private JPanel adPanel;
    private int currentAdIndex = 0;
    private static final int AD_DISPLAY_TIME = 10000; // 10 seconds for ads
    private static final int MAP_DISPLAY_TIME = 5000; // 5 seconds for the map

    // Constructor with JPanel parameter for easy integration
    public AdvertisementManager(JPanel adPanel) throws SQLException {
        this.adPanel = adPanel;
        Advertisement advertisements = new Advertisement();
        ads = advertisements.getAds();
        startAdRotation();
        startMapDisplay();
    }

    // Start rotating ads
    private void startAdRotation() {
        adTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                displayAds();
            }
        }, 0, AD_DISPLAY_TIME); // Change ad every 10 seconds
    }

    // Display ads
    private void displayAds() {
        SwingUtilities.invokeLater(() -> {
            adPanel.removeAll();
            
            // Fetch the current ad
            Ad currentAd = ads.get(currentAdIndex);
            String filePath = currentAd.getFilePath();

            JLabel adLabel = new JLabel();
            try {
                ImageIcon icon = new ImageIcon(filePath);
                adLabel.setIcon(icon);
            } catch (Exception e) {
                adLabel.setText("Image not available");
                e.printStackTrace();
            }

            adLabel.setFont(new Font("Arial", Font.BOLD, 14));
            adPanel.add(adLabel);
            adPanel.revalidate();
            adPanel.repaint();

            // Update the current ad index
            currentAdIndex = (currentAdIndex + 1) % ads.size();
        });
    }

    // Start displaying the map
    private void startMapDisplay() {
        mapTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                displayMap();
            }
        }, 0, MAP_DISPLAY_TIME); // Display map every 10 seconds
    }

    // Display the map
    private void displayMap() {
        SwingUtilities.invokeLater(() -> {
            adPanel.removeAll();
            
            // Path to your map image
            String mapFilePath = "data/Maps/TrainMap.jpg";
            JLabel mapLabel = new JLabel();
            try {
                ImageIcon icon = new ImageIcon(mapFilePath);
                mapLabel.setIcon(icon);
            } catch (Exception e) {
                mapLabel.setText("Map not available");
                e.printStackTrace();
            }

            mapLabel.setFont(new Font("Arial", Font.BOLD, 14));
            adPanel.add(mapLabel);
            adPanel.revalidate();
            adPanel.repaint();
        });
    }

    // Optionally, add a method to stop the timers if needed
    public void stopManagers() {
        adTimer.cancel();
        mapTimer.cancel();
    }
}

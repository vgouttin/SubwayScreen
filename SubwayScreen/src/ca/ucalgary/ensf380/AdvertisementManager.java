package ca.ucalgary.ensf380;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.sql.SQLException;
import java.awt.Font;
import java.util.ArrayList;

// This class will handle displaying the ads
public class AdvertisementManager {
    private Timer adTimer = new Timer();
    private ArrayList<Ad> ads;
    private JPanel adPanel;
    private int currentAdIndex = 0;
    private static final int AD_DISPLAY_TIME = 10000; // 10 seconds for ads
    private static final int MAP_DISPLAY_TIME = 5000; // 5 seconds for the map

    // Constructor with JPanel parameter so that it will be easy to call in SubwayScreen
    public AdvertisementManager(JPanel adPanel) throws SQLException {
        this.adPanel = adPanel;
        Advertisement advertisements = new Advertisement();
        ads = advertisements.getAds();
        startAdRotation();
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
            String filePath = currentAd.getFile_Path();

            
            JLabel adLabel;
            ImageIcon icon = new ImageIcon(filePath);
            adLabel = new JLabel(icon);

            adLabel.setFont(new Font("Arial", Font.BOLD, 14));
            adPanel.add(adLabel);
            adPanel.revalidate();
            adPanel.repaint();

            // Update the current ad index
            currentAdIndex = (currentAdIndex + 1) % ads.size();
        });
    }
}

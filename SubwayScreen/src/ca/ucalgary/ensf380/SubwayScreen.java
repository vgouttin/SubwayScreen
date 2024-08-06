package ca.ucalgary.ensf380;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;
import java.sql.SQLException;
import java.io.*;

public class SubwayScreen extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    // Panels
    private JPanel adPanel, weatherTimePanel, newsPanel, imagePanel;
    // Labels
    private JLabel weatherLabel;
    // Timers
    private Timer weatherTimer, trainTimer, newsTimer;
    // Weather instance
    private Weather weather;
    
    private String[] args;

    public SubwayScreen(String[] args) {
        this.args = args;
        
        setTitle("Subway Screen System");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        initializeComponents();
        AdvertisementManager getAds = new AdvertisementManager(adPanel);
        
        // Timers
        weatherTimer = new Timer(60000, e -> changeWeather());
        weatherTimer.start();
        
        trainTimer = new Timer(20000, e -> changeTrains());
        trainTimer.start();
        
        newsTimer = new Timer(10000, e -> changeNews());
        newsTimer.start();
    }

    public void changeWeather() {
        // Assume a default city name or get it from arguments
        String cityName = "Calgary";
        String weatherInfo = Weather.getWeather(cityName);
        weatherLabel.setText("<html>" + weatherInfo.replaceAll("\n", "<br>") + "</html>");
    }
    
    public void changeTrains() {
        // Implementation for train updates
    }

    public void changeNews() {
        // Implementation for news updates
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SubwayScreen(args));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if needed
    }
    
    public void initializeComponents() {
    	// Initialize all panels
        this.weatherTimePanel = new JPanel();
        this.adPanel = new JPanel();
        this.newsPanel = new JPanel();
        this.imagePanel = new JPanel();
        
        // Set backgrounds
        weatherTimePanel.setBackground(Color.blue);
        adPanel.setBackground(Color.white);
        newsPanel.setBackground(Color.black);
        imagePanel.setBackground(Color.white);
        
        // Initialize Weather instance with a default city
        weather = new Weather();
        
        // Add labels
        weatherLabel = new JLabel();
        weatherTimePanel.add(weatherLabel);
        
        weatherTimePanel.add(new JLabel("Time and Weather:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
        }});
        adPanel.add(new JLabel("Advertisements:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
        }});
        newsPanel.add(new JLabel("News:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
        }});
        imagePanel.add(new JLabel("Image:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
        }});
        
        GridBagConstraints weatherTimeGBC = new GridBagConstraints();
        weatherTimeGBC.weightx = 0.25;
        weatherTimeGBC.weighty = 0.6;
        weatherTimeGBC.gridx = 0; //column index
        weatherTimeGBC.gridy = 0;//row index
        
        GridBagConstraints adGBC = new GridBagConstraints();
        adGBC.weightx = 0.75;
        adGBC.weighty = 0.6;
        adGBC.gridx = 1; //column index
        adGBC.gridy = 0;//row index
        
        GridBagConstraints NewsGBC = new GridBagConstraints();
        NewsGBC.weightx = 1;
        NewsGBC.weighty = 0.2;
        NewsGBC.gridx = 0; //column index
        NewsGBC.gridy = 1;//row index
        
        GridBagConstraints ImageGBC = new GridBagConstraints();
        ImageGBC.weightx = 0.25;
        ImageGBC.weighty = 0.6;
        ImageGBC.gridx = 0; //column index
        ImageGBC.gridy = 2;//row index
        
        add(weatherTimePanel, weatherTimeGBC);
        add(adPanel, adGBC);
        add(newsPanel, NewsGBC);
        add(imagePanel, ImageGBC);
        
        setVisible(true);
    }
}

	
package ca.ucalgary.ensf380;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class SubwayScreen extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    // Panels
    private JPanel adPanel, weatherTimePanel, newsPanel, imagePanel;
    // Labels and TextAreas
    private JLabel weatherLabel;
    private JTextArea newsTextArea;
    // Timers
    private Timer weatherTimer, trainTimer, newsTimer;
    // Weather and News instances
    private Weather weather;
    private News news;

    public SubwayScreen() {
        setTitle("Subway Screen System");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        initializeComponents();

        Advertisement ad = new Advertisement();
        ad.establishConnection();
        // Timers
        weatherTimer = new Timer(1, e -> changeWeather());
        weatherTimer.start();

        trainTimer = new Timer(20000, e -> changeTrains());
        trainTimer.start();

        newsTimer = new Timer(10000, e -> changeNews());
        newsTimer.start();
    }

    public void changeWeather() {
        try {
            String cityName = "Calgary";
            String weatherInfo = weather.getTemperature(cityName);
            weatherLabel.setText("<html>" + getCurrentTime() + "<br>" + weatherInfo.replaceAll("\n", "<br>") + "</html>");
        } catch (Exception e) {
            weatherLabel.setText("Error retrieving weather data.");
            e.printStackTrace();
        }
    }

    public void changeTrains() {
        // Placeholder implementation for train updates
        System.out.println("Updating train information...");
    }

    public void changeNews() {
        try {
            String newsContent = news.getNewsGeneral();
            System.out.println("News JSON Response: \n" + newsContent); // Print the response
            String newsTitles = news.parseNewsTitles(newsContent);
            newsTextArea.setText(newsTitles);
        } catch (Exception e) {
            newsTextArea.setText("Error retrieving news.");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if needed
    }

    public void initializeComponents() {
        // Initialize all panels
        weatherTimePanel = new JPanel();
        adPanel = new JPanel();
        newsPanel = new JPanel();
        imagePanel = new JPanel();

        // Set backgrounds
        weatherTimePanel.setBackground(Color.blue);
        adPanel.setBackground(Color.white);
        newsPanel.setBackground(Color.black);
        imagePanel.setBackground(Color.white);

        // Initialize Weather and News instances
        weather = new Weather();
        news = new News();

        // Initialize components
        weatherLabel = new JLabel();
        weatherLabel.setForeground(Color.white);  // Set text color to be visible on blue background
        weatherLabel.setPreferredSize(new Dimension(200, 50)); // Adjust size as needed
        weatherTimePanel.add(weatherLabel);

        newsTextArea = new JTextArea();
        newsTextArea.setEditable(false);
        newsTextArea.setLineWrap(true);
        newsTextArea.setWrapStyleWord(true);
        newsTextArea.setBackground(Color.black);
        newsTextArea.setForeground(Color.white);

        weatherTimePanel.add(new JLabel("") {{
            setFont(new Font("Arial", Font.BOLD, 14));
            setForeground(Color.white);  // Set text color to be visible on blue background
        }});
        adPanel.add(new JLabel("Advertisements:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
        }});
        newsPanel.add(new JLabel("News:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
            setForeground(Color.white);  // Set text color to be visible on black background
        }});
        newsPanel.add(new JScrollPane(newsTextArea)); // Add JTextArea to JScrollPane for scrolling

        imagePanel.add(new JLabel("Image:") {{
            setFont(new Font("Arial", Font.BOLD, 14));
        }});

        GridBagConstraints weatherTimeGBC = new GridBagConstraints();
        weatherTimeGBC.weightx = 0.25;
        weatherTimeGBC.weighty = 0.6;	
        weatherTimeGBC.gridx = 0;
        weatherTimeGBC.gridy = 0;
        weatherTimeGBC.fill = GridBagConstraints.BOTH;

        GridBagConstraints adGBC = new GridBagConstraints();
        adGBC.weightx = 0.75;
        adGBC.weighty = 0.6;
        adGBC.gridx = 1;
        adGBC.gridy = 0;
        adGBC.fill = GridBagConstraints.BOTH;

        GridBagConstraints newsGBC = new GridBagConstraints();
        newsGBC.weightx = 1;
        newsGBC.weighty = 0.2;
        newsGBC.gridx = 0;
        newsGBC.gridy = 1;
        newsGBC.gridwidth = 2;
        newsGBC.fill = GridBagConstraints.BOTH;

        GridBagConstraints imageGBC = new GridBagConstraints();
        imageGBC.weightx = 0.25;
        imageGBC.weighty = 0.6;
        imageGBC.gridx = 0;
        imageGBC.gridy = 2;
        imageGBC.fill = GridBagConstraints.BOTH;

        add(weatherTimePanel, weatherTimeGBC);
        add(adPanel, adGBC);
        add(newsPanel, newsGBC);
        add(imagePanel, imageGBC);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SubwayScreen screen = new SubwayScreen();
            screen.setVisible(true);
        });
    }

    public static String getCurrentTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // 24-hour format
        return now.format(formatter);
    }
}

package ca.ucalgary.ensf380;

import java.util.*;
import java.util.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.swing.*;

//implements GUI
public class SubwayScreen extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//All attributes of the screen
	//panels
	private JPanel adPanel, weatherTimePanel, newsPanel, imagePanel;
	//labels
	private JLabel adLabel, weatherTimeLabel, newsLabel, imageLabel;
	//timers
	private Timer adTimer, mapTimer, newsTimer;
	//All attributes to be displayed on screen
	private List<Train> trains;
	private List<Station> stations;
	//Manager
	 private AdvertisementManager adManager;

	public SubwayScreen(){
		setTitle("Subway Screen System");
		setSize(1200, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		
		//initialize all panels
		weatherTimePanel = new JPanel();
		adPanel = new JPanel();
		newsPanel = new JPanel();
		imagePanel = new JPanel();
		
		//set backgrounds
		weatherTimePanel.setBackground(Color.blue);
		adPanel.setBackground(Color.white);
		newsPanel.setBackground(Color.black);
		imagePanel.setBackground(Color.white);
		
		//add labels
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
		
		
		add(weatherTimePanel);
		add(adPanel);
		add(newsPanel);
		add(imagePanel);
		
		
		adManager = new AdvertisementManager(adPanel);
	        
		setVisible(true);
		
		
	}
	
	public void main(String[] args) {
		SwingUtilities.invokeLater(SubwayScreen::new);
	}
}

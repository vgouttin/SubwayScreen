package ca.ucalgary.ensf380;

import java.util.*;
import java.io.*;


//This file is to initally make the subway system, in here I want to retrieve train and station info from csv file
//I also want functions to return the train info, station list, train list, and line info
public class Subway {
	private ArrayList<Train> trainList;
	private ArrayList<TrainLine> lineList;
	private ArrayList<Station> stationList;
	private String csvFilePath = "data/subway.csv";
	
	//Constructor
	public Subway() {
		trainList = new ArrayList<>();
        lineList = new ArrayList<>();
        stationList = new ArrayList<>();
        
        // Initialize TrainLines
        lineList.add(new TrainLine("R"));//0
        lineList.add(new TrainLine("G"));//1
        lineList.add(new TrainLine("B"));//2
	}
	
	//Setters and getters
	public List<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}

	public List<TrainLine> getLineList() {
		return lineList;
	}

	public void setLineList(ArrayList<TrainLine> lineList) {
		this.lineList = lineList;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(ArrayList<Station> stationList) {
		this.stationList = stationList;
	}
	

	
	//First I need to parse through the subway.csv file
	public void subwayStationParser() {
		try (BufferedReader subwayReader = new BufferedReader(new FileReader(csvFilePath))){
			String line;
			subwayReader.readLine(); //Need this extra line to skip the first row which is the headers
			while((line = subwayReader.readLine()) != null) {
				String[] elements = line.split(",");
				String lineIdentifier = elements[2].trim();//identifies R,B or G
				String stationNum = elements[3].trim();//identifies number
				String stationName = elements[4].trim();//identifies name
				double stationX = Double.parseDouble(elements[5]);//identifies x coord
				double stationY = Double.parseDouble(elements[6]);//identifies y coord
				String commonStation = elements[7].trim();
				Station newStation = new Station(lineIdentifier, stationNum, stationName, stationX, stationY, commonStation);//created new constructor
				stationList.add(newStation);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//This function parses through the csv and creates a new list of stations with all their attributes
	
	//Now i need a function that will create seperate trains and assign stations to them
	public void createTrains() {
		for(int i = 1; i<=12 ; i++) {
		     TrainLine trainLine = null;
	            if (i <= 4) {
	                trainLine = lineList.get(0); // Red Line
	            } else if (i <= 8) {
	                trainLine = lineList.get(1); // Green Line
	            } else {
	                trainLine = lineList.get(2); // Blue Line
	            }

	            Train train = new Train("T" + i, trainLine);
	            trainList.add(train);
		}
		getTrainList();
		for (Train train: trainList) {
			//want this to fill in all the rest of the attributes for train: direction (F, B), location and sations on this line 
		}
		
	}
	
	public void addTrainInfo() {
		
	}
}

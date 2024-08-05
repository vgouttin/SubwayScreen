package ca.ucalgary.ensf380;

import java.util.*;
import java.io.*;


//This file is to initally make the subway system, in here I want to retrieve train and station info from csv file
//I also want functions to return the train info, station list, train list, and line info
public class System {
	private ArrayList<Train> trainList;
	private ArrayList<TrainLine> lineList;
	private ArrayList<Station> stationList;
	private String csvFilePath = "data/subway.csv";
	
	//Constructor
	public System() {
		
	}
	
	//Setters and getters
	public ArrayList<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}

	public ArrayList<TrainLine> getLineList() {
		return lineList;
	}

	public void setLineList(ArrayList<TrainLine> lineList) {
		this.lineList = lineList;
	}

	public ArrayList<Station> getStationList() {
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
				String lineIdentifier = elements[2];//identifies R,B or G
				String stationNum = elements[3];//identifies number
				String stationName = elements[4];//identifies name
				double stationX = Double.parseDouble(elements[5]);//identifies x coord
				double stationY = Double.parseDouble(elements[6]);//identifies y coord
				Station newStation = new Station(lineIdentifier, stationNum, stationName, stationX, stationY);//created new constructor
				stationList.add(newStation);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//This function parses through the csv and creates a new list of stations with all their attributes
	
	
}

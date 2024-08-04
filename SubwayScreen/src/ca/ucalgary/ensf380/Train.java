package ca.ucalgary.ensf380;

import java.util.*;

public class Train {
	//Attributes
	private int trainNum;//Train number
	private TrainLine trainLine;//Train Line
	private List<Stations> stations;//List of all stations this train goes through
	private String direction;// direction of train
	private String location; //current location of train
	
	//train constructor
	public Train(int trainNum, TrainLine trainLine, List<Stations> stations, String direction, String location) {
	    this.trainNum = trainNum;
	    this.trainLine = trainLine;
	    this.stations = stations;
	    this.direction = direction;
	    this.location = location;
	}

	//setters and getters
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}
	public TrainLine getTrainLine() {
		return trainLine;
	}
	public void setTrainLine(TrainLine trainLine) {
		this.trainLine = trainLine;
	}
	public List<Stations> getStations() {
		return stations;
	}
	public void setStations(List<Stations> stations) {
		this.stations = stations;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
		
	}
	
	
}

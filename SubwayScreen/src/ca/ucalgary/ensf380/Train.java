package ca.ucalgary.ensf380;

import java.util.*;

public class Train {
	//Attributes
	private String trainNum;//Train number
	private TrainLine trainLine;//Train Line
	private List<Station> stations;//List of all stations this train goes through
	private String direction;// direction of train
	private String location; //current location of train
	
	//train constructor
	public Train(String trainNum, TrainLine trainLine,
			List<Station> stations, String direction, String location) {
	    this.trainNum = trainNum;	
	    this.trainLine = trainLine;
	    this.stations = stations;
	    this.direction = direction;
	    this.location = location;
	}
	
	//Constructor for System (1)
	public Train(String trainNum, TrainLine trainLine) {
			this.trainNum = trainNum;
			this.trainLine = trainLine;
	}

	//Constructor for System (2)
	public Train(List<Station> stations, String direction, String location) {
			this.stations = stations;
		  	this.direction = direction;
		    this.location = location;
	}
	
	//setters and getters
	public String getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}
	public TrainLine getTrainLine() {
		return trainLine;
	}
	public void setTrainLine(TrainLine trainLine) {
		this.trainLine = trainLine;
	}
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
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

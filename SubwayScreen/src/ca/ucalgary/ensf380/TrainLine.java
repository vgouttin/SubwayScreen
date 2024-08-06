package ca.ucalgary.ensf380;

import java.util.*;

//TrainLine class
public class TrainLine {
	//Attributes
	private String color;
	private List<Train> assignedTrains;
	private List<Station> lineStations;
	private List<Station> commonLineStations;
	
	
	//constructor for system.java
	public TrainLine(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<Train> getAssignedTrains() {
		return assignedTrains;
	}
	public void setAssignedTrains(List<Train> assignedTrains) {
		this.assignedTrains = assignedTrains;
	}
	public List<Station> getLineStations() {
		return lineStations;
	}
	public void setLineStations(List<Station> lineStations) {
		this.lineStations = lineStations;
	}
	public List<Station> getCommonLineStations() {
		return commonLineStations;
	}
	public void setCommonLineStations(List<Station> commonLineStations) {
		this.commonLineStations = commonLineStations;
	}
	
	
}

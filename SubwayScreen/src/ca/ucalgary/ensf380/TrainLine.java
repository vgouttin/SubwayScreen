package ca.ucalgary.ensf380;

import java.util.*;

//TrainLine class
public class TrainLine {
	//Attributes
	private String color;
	private List<Station> lineStations;
	private List<Station> commonLineStations;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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

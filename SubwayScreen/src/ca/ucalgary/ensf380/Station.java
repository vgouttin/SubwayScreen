package ca.ucalgary.ensf380;

//Station class
public class Station {
	//Attributes according to psv file
	private int stationNum;
	private String stationCode;
	private double stationX;
	private double stationY;
	
	//Constructor
	public Station(int stationNum, String stationCode, double stationX, double stationY) {
		this.stationNum = stationNum;
		this.stationCode = stationCode;
		this.stationX = stationX;
		this.stationY = stationY;
	}
	
	
	//Setters and getters
	public int getStationNum() {
		return stationNum;
	}
	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public double getStationX() {
		return stationX;
	}
	public void setStationX(double stationX) {
		this.stationX = stationX;
	}
	public double getStationY() {
		return stationY;
	}
	public void setStationY(double stationY) {
		this.stationY = stationY;
	}
	
	
}

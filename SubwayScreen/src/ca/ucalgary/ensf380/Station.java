package ca.ucalgary.ensf380;

//Station class
public class Station {
	//Attributes according to psv file
	private String stationNum;
	private String stationName;
	private String stationCode;
	private double stationX;
	private double stationY;
	private String stationLine;
	private String commonStation;
	
	//Constructor
	public Station(String stationNum, String stationName, String stationCode, double stationX, double stationY) {
		this.stationNum = stationNum;
		this.stationName = stationName;
		this.stationCode = stationCode;
		this.stationX = stationX;
		this.stationY = stationY;
	}
	
	//constructor for system.java
	public Station(String stationLine, String stationNum, String stationName, Double stationX, Double stationY, String commonStation) {
		this.stationLine = stationLine;
		this.stationNum = stationNum;
		this.stationName = stationName;
		this.stationX = stationX;
		this.stationY = stationY;
		this.commonStation = commonStation;
	}
	
	//Setters and getters
	public String getStationLine() {
		return stationLine;
	}
	public void setStationLine(String stationLine) {
		this.stationLine = stationLine;
	}
	public String getStationNum() {
		return stationNum;
	}
	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
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
	public String getCommonStaion() {
		return commonStation;
	}
	public void setCommonStaion(String commonStation) {
		this.commonStation = commonStation;
	}
	
}

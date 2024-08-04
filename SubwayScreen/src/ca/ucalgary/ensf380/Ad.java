package ca.ucalgary.ensf380;
//This class is to be implemented in Advertisements.java as a type Ad for the list of ads
public class Ad {
	private int key;
	private String name;
	private String file_path;
	
	public Ad(int key, String name, String file_path) {
		this.key = key;
		this.name = name;
		this.file_path = file_path;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFile_path() {
		return file_path;
	}
	
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
}

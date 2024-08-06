/*
 * Author: Victor Gouttin
 * Ad.java
 * version 1.4
 */

package ca.ucalgary.ensf380;
//This class is to be implemented in Advertisement.java as a type Ad for the list of ads
//Also provides getters for when i need to access file_path
public class Ad {
	private int key;
	private String name;
	private String file_path;
	
	public Ad(String file_path) {
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
	
	public String getFile_Path() {
		return file_path;
	}
	
	public void setFile_Path(String file_path) {
		this.file_path = file_path;
	}
	
}

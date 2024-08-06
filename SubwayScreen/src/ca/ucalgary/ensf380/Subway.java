package ca.ucalgary.ensf380;

import java.util.*;
import java.io.*;

// This file is to initially make the subway system, retrieving train and station info from a CSV file
// It also includes functions to return train info, station list, train list, and line info
public class Subway {
    private ArrayList<Train> trainList;
    private ArrayList<TrainLine> lineList;
    private ArrayList<Station> stationList;
    private String csvFilePath = "data/subway.csv";

    // Constructor
    public Subway() {
        trainList = new ArrayList<>();
        lineList = new ArrayList<>();
        stationList = new ArrayList<>();

        // Initialize TrainLines
        lineList.add(new TrainLine("R")); // Red Line
        lineList.add(new TrainLine("G")); // Green Line
        lineList.add(new TrainLine("B")); // Blue Line
    }

    // Setters and getters
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

    // First I need to parse through the subway.csv file
    // This function parses through the CSV and creates a new list of stations with all their attributes
    public void subwayStationParser() {
        try (BufferedReader subwayReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            subwayReader.readLine(); // Skip the first row which is the header
            while ((line = subwayReader.readLine()) != null) {
                String[] elements = line.split(",");
                String lineIdentifier = elements[2].trim(); // Identifies R, B or G
                String stationNum = elements[3].trim(); // Identifies number
                String stationName = elements[4].trim(); // Identifies name
                double stationX = Double.parseDouble(elements[5].trim()); // Identifies x coord
                double stationY = Double.parseDouble(elements[6].trim()); // Identifies y coord
                String commonStation = elements[7].trim();
                Station newStation = new Station(lineIdentifier, stationNum, stationName, stationX, stationY, commonStation); // Created new constructor
                stationList.add(newStation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateTrainLocation(Train train) {
    	
    }
    // Add or update train information
    public void addTrainInfo(Train train) {
        // Implement logic to add or update train information
    	
    }
    // Now I need a function that will create separate trains and assign stations to them
    // This function creates Train objects and assigns them to train lines
    public void createTrains() {
        for (int i = 1; i <= 12; i++) {
            TrainLine trainLine;
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

        // Assign stations to trains based on their line
        for (Train train : trainList) {
            TrainLine line = train.getTrainLine();
            List<Station> lineStations = new ArrayList<>();
            for (Station station : stationList) {
                if (station.getStationLine().equals(line.getColor())) {
                    lineStations.add(station);
                }
            }
            train.setStations(lineStations);
            addTrainInfo(train);
        }
    }

   
}

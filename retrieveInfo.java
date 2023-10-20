// Calculate great-circle distance using Haversine formula
// http://www.java2s.com/example/java/java.lang/gets-the-great-circle-distance-in-kilometers-between-two-geographical.html

// Sort matching friends by user ID in ascending orders 
// Collections.sort(eligibleFriends, Comparator.comparingLong(friendInfo::getUserId));
// https://www.infoworld.com/article/3323403/java-challengers-5-sorting-with-comparable-and-comparator-in-java.html


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Class that parses data from JSON (friends (1).txt) File
public class retrieveInfo extends friendInfo {

    public retrieveInfo(String name, long user_id) {
        super(name, user_id, ssgLat, ssgLong);
    }

    public static void main(String[] args) {
        String fileName = "friends (1).txt";
        JSONParser parseData = new JSONParser();
        List<friendInfo> eligibleFriends = new ArrayList<>();

        try {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);

            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();

                try {
                    JSONObject friendJson = (JSONObject) parseData.parse(line);

                    String name = (String) friendJson.get("name");
                    long userId = (long) friendJson.get("user_id");
                    double latitude = Double.parseDouble((String) friendJson.get("latitude"));
                    double longitude = Double.parseDouble((String) friendJson.get("longitude"));

                    // Calculate the great-circle distance
                    double distance = calculateDistance(ssgLat, ssgLong, latitude, longitude);

                    if (distance <= 100.0) { // Friends within 100km
                        eligibleFriends.add(new friendInfo(name, userId, latitude, longitude));
                    }
                } catch (ParseException e) {
                    System.err.println("Error parsing JSON: " + e.getMessage());
                }
            }
            // Close the file
            myScanner.close();

            // Sort matching friends by user ID in ascending order 
            Collections.sort(eligibleFriends, Comparator.comparingLong(friendInfo::getUserId));
            
            int count=1; // count incrementer
            // Output the names and user IDs of matching friends
            for (friendInfo friend : eligibleFriends) {
            	System.out.println("Names of individuals eligible to receive invitation " + "[invite " + count + "]");
            	System.out.println("---------------------------------------------------");
                System.out.println("Name: " + friend.getName());
                System.out.println("User ID: " + friend.getUserId());
                System.out.println();
                count ++; 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    
}

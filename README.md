# Workhuman-Technical-Assessment

Friend Invitations within 100km
This Java project is designed to help you identify friends who live within 100 kilometers of St Stephen's Green park and invite them for a gathering. The project reads a list of friends' records from a text file, calculates their distances from St Stephen's Green park using the Haversine formula, and identifies eligible friends for invitations based on the distance criteria.

# Features
Reads friend records from a text file in JSON format.
Calculates the great-circle distance between each friend's location and St Stephen's Green park.
Identifies friends living within 100 kilometers of the park.
Sorts eligible friends by User ID in ascending order.
Outputs the names and User IDs of matching friends.

# Getting Started
Clone the repository to your local machine.
Compile and run the Java program using a Java development environment.

# Usage
Ensure you have a text file named "friends.txt" with one friend's record per line in JSON format. Each record should include the friend's name, user ID, latitude, and longitude.
Run the Java program to process the friend records and identify eligible friends.
The program will display the names and User IDs of matching friends who live within 100 kilometers of St Stephen's Green park.

# Dependencies
Java SDK (at least version X.X.X)
JSON Simple library for parsing JSON data (included in the project)

# Contributors
Nosa Emmanuel Igbinoba 
License
This project is licensed under the MIT License - see the LICENSE file for details.

# Acknowledgments
Inspiration for calculating great-circle distances using the Haversine formula: 
[Link to source]: ([http://www.java2s.com/example/java/java.lang/gets-the-great-circle-distance-in-kilometers-between-two-geographical.html])

// Public class to show friends informations
public class friendInfo implements Methods{
	
	// Variables created to store friends information
	public String name;
	public long user_id;
	public double userLat; 
    public double userLong;
    
    // Coordinates of St Stephens Green Park (SSG)
	public static double ssgLat = 53.337839; 
    public static double ssgLong = -6.259520;

	
	// constructor 
	public friendInfo(String name, long user_id, double userLat, double userLong) {
		
		this.name = name;
		this.user_id = user_id;
		this.userLat = userLat;
		this.userLong = userLong;
	
	}
	
	// Getter to retrieve name
	public String getName() {
        return name;
    }
	
	// Getter to retrieve user id
    public long getUserId() {
        return user_id;
    }
    
    // Calculate great-circle distance using Haversine formula
    protected static double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        double earthRadius = 6371.0; // Radius of the Earth in kilometers
        double earthLatitude = Math.toRadians(latitude2 - latitude1);
        double earthLongitude = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(earthLatitude / 2) * Math.sin(earthLatitude / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(earthLongitude / 2) * Math.sin(earthLongitude / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
	
	

}

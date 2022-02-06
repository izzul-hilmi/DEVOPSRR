
public class Booking {
	
	protected String username;
	
	public Booking(String username, String restaurant, String date, String time) {
		super();
		this.username = username;
		this.restaurant = restaurant;
		this.date = date;
		this.time = time;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	protected String restaurant;
	
	protected String date;
	
	protected String time;

}

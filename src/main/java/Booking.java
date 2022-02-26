import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Booking {
	
	protected String username;
	
	public Booking(String username, String restaurant, String time, String date) {
		super();
		this.username = username;
		this.restaurant = restaurant;
		this.time = time;
		this.date = date;
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
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/restaurant";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "password";

    // Define connection
    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
	
	public static int deleteBooking(String username) throws SQLException {

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from BookingDetails where username = ?;");) 
        {
            statement.setString(1, username);
            int i = statement.executeUpdate();
            return i;
        }

    }
	
	public static int updateBooking(String oriName, String username, String restaurant, String date, String time) throws SQLException {

	    //Step 2: Attempt connection with database and execute update user SQL query
	    try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update BookingDetails set username = ?,restaurant= ?, time=? ,date=? where username=?;");) {
	        statement.setString(1, username);
	        statement.setString(2, restaurant);
	        statement.setString(3, date);
	        statement.setString(4, time);
	        statement.setString(5, oriName);
	        int i = statement.executeUpdate();
	        return i;
	    } 

	}
	
	public static int newBooking(String u, String r, String d, String t) throws SQLException {
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "password");

            // Step 4: implement the sql query using prepared statement
            // (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
            PreparedStatement ps = con.prepareStatement("insert into BOOKINGDETAILS values(?,?,?,?)");

            // Step 5: parse in the data retrieved from the web form request into the
            // prepared statement accordingly
            ps.setString(1, u);
            ps.setString(2, r);
            ps.setString(3, t);
            ps.setString(4, d);


            // Step 6: perform the query on the database using the prepared statement
            i = ps.executeUpdate();
            // Step 7: check if the query had been successfully execute, return “You are
            // successfully registered” via the response,
            if (i > 0) {

                System.out.println("Successful !"+ i);
                return i;
            }
        }
        // Step 8: catch and print out any exception
        catch (Exception exception) {
            System.out.println(exception);
        }
        System.out.println(i);
        return i;

    }
	public static int viewBooking(List<Booking> bookings) throws SQLException {
		int i = 0;
		try (
				Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from BookingDetails");
			) 
		{
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String username = rs.getString("username");
				String restaurant = rs.getString("restaurant");
				String date = rs.getString("date");
				String time = rs.getString("time");
				bookings.add(new Booking(username, restaurant, date, time));
				i = bookings.size();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

}

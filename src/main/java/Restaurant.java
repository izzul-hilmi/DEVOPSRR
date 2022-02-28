import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Restaurant {
	protected String name;
	 
	 public Restaurant(String name, String hotline, String address) {
		 super();
		 this.name = name;
		 this.hotline = hotline;
		 this.address = address;
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	protected String hotline;
	protected String address;
	
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
	
	public static int deleteRestaurant(String name) throws SQLException {

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from RestaurantDetails where name = ?;");) 
        {
            statement.setString(1, name);
            int i = statement.executeUpdate();
            return i;
        }

    }
	
	public static int updateRestaurant(String oriName, String name, String hotline, String address) throws SQLException {

	    //Step 2: Attempt connection with database and execute update user SQL query
	    try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update RestaurantDetails set name = ?,hotline= ?, address=? where name=?;");) {
	        statement.setString(1, name);
	        statement.setString(2, hotline);
	        statement.setString(3, address); 
	        statement.setString(4, oriName);
	        int i = statement.executeUpdate();
	        return i;
	    } 

	}
	
	public static int newRestaurant(String n, String h, String a) throws SQLException {
        int i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "password");

            // Step 4: implement the sql query using prepared statement
            // (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
            PreparedStatement ps = con.prepareStatement("insert into RESTAURANTDETAILS values(?,?,?)");

            // Step 5: parse in the data retrieved from the web form request into the
            // prepared statement accordingly
            ps.setString(1, n);
            ps.setString(2, h);
            ps.setString(3, a);


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
	public static int viewRestaurant(List<Restaurant> restaurants) throws SQLException {
		int i = 0;
		try (
				Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from RestaurantDetails");
			) 
		{
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String hotline = rs.getString("hotline");
				String address = rs.getString("address");
				restaurants.add(new Restaurant(name, hotline, address));
				i = restaurants.size();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
}

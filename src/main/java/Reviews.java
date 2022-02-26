import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Reviews {
	
	
	protected String name;
	
	public Reviews(String name, String review) {
		super();
		this.name = name;
		this.review = review;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	protected String review;
	
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
	
	
	public static int registerComment(String n, String p) throws SQLException {
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "password");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into REVIEWDETAILS values(?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, n);
			ps.setString(2, p);
	

			// Step 6: perform the query on the database using the prepared statement
			i = ps.executeUpdate();
			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,
			if (i > 0) {
				
				System.out.println("Success!   "+ i);
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
	
	public static int viewComment(List<Reviews> comments) throws SQLException {
        int i = 0;
        try (
                Connection connection = getConnection();
                // Step 5.1: Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from ReviewDetails");
            ) 
        {
            // Step 5.2: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 5.3: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String review = rs.getString("review");
             
                comments.add(new Reviews(name, review));
                i = comments.size();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
	
public static int deleteComment(String name) throws SQLException {
		
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from ReviewDetails where name = ?;");) 
		{
			statement.setString(1, name);
			int i = statement.executeUpdate();
			return i;
		}
		
	}



public static int updateComment(String oriName, String name, String review) throws SQLException {
	
	//Step 2: Attempt connection with database and execute update user SQL query
	try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update ReviewDetails set name = ?,review= ? where name= ?");) {
		statement.setString(1, name);
		statement.setString(2, review);
		
		statement.setString(3, oriName);
		int i = statement.executeUpdate();
		return i;
	} 
			
}
}


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User {

	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}
	protected String name;
	protected String password;
	protected String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Define variables
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
	
	public static int readUsers(List<User> users) throws SQLException {
		int i = 0;
		try (
				Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from UserInfo");
			) 
		{
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				users.add(new User(name, password, email));
				i = users.size();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	public static int registerUser(String formName, String formPassword, String formEmail) throws SQLException {
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "password");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into USERINFO values(?,?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, formName);
			ps.setString(2, formPassword);
			ps.setString(3, formEmail);

			// Step 6: perform the query on the database using the prepared statement
			i = ps.executeUpdate();
			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,
			if (i > 0) {
				
				System.out.println("Successfully registered"+ i);
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

	
	public static int updateUser(String oriName, String name, String password, String email) throws SQLException {
		
		//Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update UserInfo set name = ?,password= ?, email =? where name = ?;");) {
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, oriName);
			int i = statement.executeUpdate();
			return i;
		} 
				
	}
	
	public static int deleteUser(String name) throws SQLException {
		
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from UserInfo where name = ?;");) 
		{
			statement.setString(1, name);
			int i = statement.executeUpdate();
			return i;
		}
	}

//	public static int showEditForm(String name, User existingUser) throws SQLException {
//		
//		int i = 0;
//		
//		// Step 1: Establishing a Connection
//		try (
//				Connection connection = getConnection();
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement("select name,password,email from userinfo where name =?;");
//			) 
//		{
//			preparedStatement.setString(1, name);
//				
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//			
//			// Step 4: Process the ResultSet object
//			while (rs.next()) {
//				name = rs.getString("name");
//				String password = rs.getString("password");
//				String email = rs.getString("email");
//				existingUser = new User(name, password, email);
//				i = name.length();
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return i;
//	}
}

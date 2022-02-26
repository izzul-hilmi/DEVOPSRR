import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/restaurant";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	private static final long serialVersionUID = 1L;
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_BOOKING_SQL = "INSERT INTO BookingDetails" + " (username, restaurant, time, date) VALUES " +
	 " (?, ?, ?, ?);";
	 private static final String SELECT_BOOKING_BY_ID = "select username,restaurant,time,date from BookingDetails where username =?";
	 private static final String SELECT_ALL_BOOKING = "select * from BookingDetails ";
	 private static final String DELETE_BOOKING_SQL = "delete from BookingDetails where username = ?;";
	 private static final String UPDATE_BOOKING_SQL = "update BookingDetails set username = ?,restaurant= ?, time=? ,date=? where username=?;";
	 //Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
	 protected Connection getConnection() {
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
		switch (action) {
		case "/BookingServlet/delete":
		deleteBooking(request, response);
		break;
		case "/BookingServlet/edit":
		showEditForm(request, response);
		break;
		case "/BookingServlet/update":
		updateBooking(request, response);
		break;
		case "/BookingServlet/dashboard":
		listBooking(request, response);
		break;
		}
		} catch (SQLException ex) {
		throw new ServletException(ex);
		}
		 
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//Step 5: listUsers function to connect to the database and retrieve all users records
	private void listBooking(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{
	List <Booking> booking = new ArrayList <>();
	 try (Connection connection = getConnection();
	 // Step 5.1: Create a statement using connection object
	 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING);) {
	 // Step 5.2: Execute the query or update query
	 ResultSet rs = preparedStatement.executeQuery();
	 // Step 5.3: Process the ResultSet object.
	 while (rs.next()) {
	 String username = rs.getString("username");
	 String restaurant = rs.getString("restaurant");
	 String date = rs.getString("date");
	 String time = rs.getString("time");
	
	 booking.add(new Booking(username, restaurant, date, time));
	 }
	 } catch (SQLException e) {
	 System.out.println(e.getMessage());
	 }
	// Step 5.4: Set the users list into the listUsers attribute to be pass to the reviewManagement.jsp
	request.setAttribute("listBooking", booking);
	request.getRequestDispatcher("/bookingManagement.jsp").forward(request, response);
	}
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
	//get parameter passed in the URL
	String username = request.getParameter("username");
	Booking existingBooking = new Booking("", "", "", "");
	// Step 1: Establishing a Connection
	try (Connection connection = getConnection();
	// Step 2:Create a statement using connection object
	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
	preparedStatement.setString(1, username);
	// Step 3: Execute the query or update query
	ResultSet rs = preparedStatement.executeQuery();
	// Step 4: Process the ResultSet object
	while (rs.next()) {
	String Username = rs.getString("username");
	String restaurant = rs.getString("restaurant");
	String date = rs.getString("date");
	String time = rs.getString("time");
	existingBooking = new Booking(Username, restaurant, date, time);
	}
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	}
	//Step 5: Set existingUser to request and serve up the userEdit form
	request.setAttribute("booking", existingBooking);
	request.getRequestDispatcher("/bookingEdit.jsp").forward(request, response);
	}
	//method to update the user table base on the form data
	private void updateBooking(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	String oriName = request.getParameter("oriName");
	String username = request.getParameter("username");
	String restaurant = request.getParameter("restaurant");
	String date = request.getParameter("date");
	String time = request.getParameter("time");
	Booking.updateBooking(oriName, username, restaurant, date, time);
	//Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
	response.sendRedirect("http://localhost:8090/DEVOPSRR/BookingServlet/dashboard");
	}
	//method to delete user
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    //Step 1: Retrieve value from the request
		     String username = request.getParameter("username");
		     Booking.deleteBooking(username);
		     //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
		     response.sendRedirect("http://localhost:8090/DEVOPSRR/BookingServlet/dashboard");
		    }
		

}
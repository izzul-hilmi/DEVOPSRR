

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	 //Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/restaurant";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, REVIEW) VALUES " + " (?, ?);";
	 private static final String SELECT_REVIEW_BY_ID = "select name,review from ReviewDetails where name =?";
	 private static final String SELECT_ALL_REVIEWS = "select * from ReviewDetails ";
	 private static final String DELETE_REVIEWS_SQL = "delete from ReviewDetails where name = ?;";
	 private static final String UPDATE_REVIEWS_SQL = "update ReviewDetails set name = ?,review= ? where name= ?";
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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/CommentServlet/delete":
		 deleteComment(request, response);
		 break;
		 case "/CommentServlet/edit":
		 showEditForm(request, response);
		 break;
		 case "/CommentServlet/update":
		 updateComment(request, response);
		 break;
		 case "/CommentServlet/dashboard":
		 listComment(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Step 5: listUsers function to connect to the database and retrieve all users records
	
		doGet(request, response);
	}
		private void listComment(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException
				{
			List <Reviews> comments = new ArrayList <>();
			Reviews.viewComment(comments);
				// Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp
				request.setAttribute("listComment", comments);
				request.getRequestDispatcher("/ReviewManagement.jsp").forward(request, response);
				}
		
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
				//get parameter passed in the URL
				String name = request.getParameter("name");
				Reviews existingReview = new Reviews("", "");
				// Step 1: Establishing a Connection
				try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement =
				connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
				preparedStatement.setString(1, name);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();
				// Step 4: Process the ResultSet object
				while (rs.next()) {
				name = rs.getString("name");
				String review = rs.getString("review");
			
				existingReview = new Reviews (name, review);
				}
				} catch (SQLException e) {
				System.out.println(e.getMessage());
				}
				//Step 5: Set existingUser to request and serve up the userEdit form
				request.setAttribute("review", existingReview);
				request.getRequestDispatcher("/commentEdit.jsp").forward(request, response);
				}
		
		//method to update the user table base on the form data
		private void updateComment(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		 String name = request.getParameter("name");
		 String review = request.getParameter("review");

		 Reviews.updateComment(oriName, name, review);
		
		 //Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
		 response.sendRedirect("http://localhost:8090/DEVOPSRR/CommentServlet/dashboard");
		}
		
		//method to delete user
		private void deleteComment(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		 String name = request.getParameter("name");
		 //Step 2: Attempt connection with database and execute delete user SQL query
		 Reviews.deleteComment(name);
		 //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
		 response.sendRedirect("http://localhost:8090/DEVOPSRR/CommentServlet/dashboard");
		}
		
	}
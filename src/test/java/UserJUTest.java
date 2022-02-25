import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author izzul
 *
 */
class UserJUTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test method for {@link User#registerUser(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void test1PostUser() throws SQLException {
		int i = User.registerUser("John123", "123", "JohnDoe123@gmail.com");
		assertTrue(i > 0);
	}
	
//	/**
//	 * Test method for {@link User#showEditForm(java.lang.String)}.
//	 * @throws SQLException 
//	 */
//	@Test
//	void test2ShowEditForm() throws SQLException {
//		
//		User existingUser = new User("John123", "123", "JohnDoe123@gmail.com");
//		int i = User.showEditForm("John123", existingUser); 
//		// i = name length
//		assertTrue(i > 0);
//	}
	
	/**
	 * Test method for {@link User#registerUser(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void test3UpdateUser() throws SQLException {
		int i = User.updateUser("John123", "John123Edit", "123Edit", "JohnDoe123Edit@gmail.com");
		assertTrue(i > 0);
	}

	/**
	 * Test method for {@link User#deleteUser(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void test4DeleteUser() throws SQLException {
//		fail("Not yet implemented");
		int i = User.deleteUser("John123Edit");
		assertTrue(i > 0);
	}

}

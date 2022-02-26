import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author User
 *
 */
class BookingJUTest {

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
	 * Test method for {@link Booking#deleteBooking(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteBooking() throws SQLException {
		int i = Booking.deleteBooking("John123Edit");
		assertTrue(i > 0);
	}

	/**
	 * Test method for {@link Booking#updateBooking(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateBooking() throws SQLException {
		int i = Booking.updateBooking("John123", "John123Edit", "123Edit", "29/09/2022", "2:30AM");
		assertTrue(i > 0);
	}

	/**
	 * Test method for {@link Booking#newBooking(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testNewBooking() throws SQLException {
		int i = Booking.newBooking("John123", "Restaurant", "29/09/2022", "2:30PM");
		assertTrue(i > 0);
	}

}

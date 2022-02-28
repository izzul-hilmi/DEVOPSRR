import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author sethy
 *
 */
class RestaurantJUTest {

	/**
	 * Test method for {@link Restaurant#deleteRestaurant(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteRestaurant() throws SQLException {
		 int i = Restaurant.deleteRestaurant("John123Edit");
	        assertTrue(i > 0);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Restaurant#updateRestaurant(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateRestaurant() throws SQLException {
		 int i = Restaurant.updateRestaurant("John123","John123Edit", "123456789", "Hougang");
	        assertTrue(i > 0);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Restaurant#newRestaurant(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testNewRestaurant() throws SQLException {
		int i = Restaurant.newRestaurant("John123", "123456789", "Hougang");
        assertTrue(i > 0);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Restaurant#viewRestaurant(java.util.List)}.
	 * @throws SQLException 
	 */
	@Test
	void testViewRestaurant() throws SQLException {
		 List <Restaurant> restaurants = new ArrayList <>();

	        restaurants.add(new Restaurant("John123", "123456789", "Hougang"));
	        int i = Restaurant.viewRestaurant(restaurants);
	        assertTrue(i > 0);
		//fail("Not yet implemented");
	}

}

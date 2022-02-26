import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author tanhu
 *
 */
class ReviewJUTest {

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
	 * Test method for {@link Reviews#registerComment(java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testRegisterComment() throws SQLException {
		//fail("Not yet implemented");
		int i = Reviews.registerComment("John123", "decent");
		assertTrue(i > 0);
	}
	
	/**
     * Test method for {@link Reviews#viewComment(java.util.List)}.
     * @throws SQLException 
     */
    @Test
    void testViewReview() throws SQLException {
        List <Reviews> comments = new ArrayList <>();

        comments.add(new Reviews("John123", "Restaurant"));
        int i = Reviews.viewComment(comments);
        assertTrue(i > 0);
    }
    
	/**
	 * Test method for {@link Reviews#updateComment(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateComment() throws SQLException {
		//fail("Not yet implemented");
		int i = Reviews.updateComment("John123", "John123Edit", "123Edit");
		assertTrue(i > 0);
	}

	/**
	 * Test method for {@link Reviews#deleteComment(java.lang.String)}.
	 * @throws SQLException 
	 */
	
	@Test
	void testDeleteComment() throws SQLException {
		//fail("Not yet implemented");
		int i = Reviews.deleteComment("John123Edit");
		assertTrue(i > 0);
	}


	

}

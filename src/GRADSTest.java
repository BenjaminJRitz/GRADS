import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GRADSTest {
	GRADS GRADS;
	
	@Before
	public void setUp() throws Exception {
        GRADS.init();
	}

	@After
	public void tearDown() throws Exception {
		//Clear test class and mark it for garbage collection
		//GRADS = null;
	}
	
	//****************** LoadUsers tests ******************

	//If loadUsers is provided with an invalid file name, it should throw an exception.
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThatLoadUsersThrowsFileNotFoundError() throws Exception {
		String badFileName = "INVALIDFILENAME";
		GRADS.loadUsers(badFileName);
	}
	
	//If provided a good user file, users should be populated.
	@Test
	public void testLoadUsersPopulatesHashMap() throws Exception {
		String goodFileName = "testusers.json";
		GRADS.loadUsers(goodFileName);
		assertFalse(GRADS.users.isEmpty());
	}
	
	//Make sure a specific user ended up in users.
	@Test
	public void testLoadUsersHasUser() throws Exception {
		String goodFileName = "testusers.json";
		GRADS.loadUsers(goodFileName);
		assertTrue(GRADS.users.containsKey("TESTUSER"));
	}
	
	//****************** LoadCourses tests ******************
	//LoadCourses works exactly the same as LoadUsers, so the tests are identical:
	
	//If loadCourses is provided with an invalid file name, it should throw an exception.
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThatLoadCoursesThrowsFileNotFoundError() throws Exception {
		String badFileName = "INVALIDFILENAME";
		GRADS.loadCourses(badFileName);
	}
	
	//If provided a good course file, courses should be populated.
	@Test
	public void testLoadCoursesPopulatesHashMap() throws Exception {
		String goodFileName = "testcourses.json";
		GRADS.loadCourses(goodFileName);
		assertFalse(GRADS.courses.isEmpty());
	}
	
	//Make sure a specific course ended up in courses.
	@Test
	public void testLoadCoursesHasCourse() throws Exception {
		String goodFileName = "testcourses.json";
		GRADS.loadCourses(goodFileName);
		assertTrue(GRADS.courses.containsKey("Software Engineering"));
	}
	
	//****************** LoadRecords tests ******************
	
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThatLoadRecordsThrowsFileNotFoundError() throws Exception {
		String badFileName = "INVALIDFILENAME";
		GRADS.loadRecords(badFileName);
	}
	
	public void testLoadRecordsPopulatesHashMap() throws Exception {
		String goodFileName = "testrecords.json";
		GRADS.loadRecords(goodFileName);
		assertFalse(GRADS.records.isEmpty());
	}
	
	public void testThatLoadRecordsHasStudent() throws Exception {
		String goodFileName = "testrecords.json";
		GRADS.loadRecords(goodFileName);
		assertTrue(GRADS.records.containsKey("jdoe"));
	}
	
	//****************** setUser tests ******************
	@Test 
	public void testSetUserForValidUser() {
		try {
			GRADS.setUser("TESTUSER");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "TESTUSER";
		assertTrue(GRADS.currentUser.networkID.equals(expected));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testSetUserForInvalidUser() throws UserNotFoundException {
		GRADS.setUser("INVALIDUSER");
	}
	
	//****************** GetUser tests ******************
	
	//This method is just a single statement, so we just test that it returns the default user value.
	@Test
	public void testGetUser() {
		try {
			GRADS.loadUsers("testusers.json");
			GRADS.setUser("TESTUSER");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(GRADS.getUser().equals("TESTUSER"));
	}


}

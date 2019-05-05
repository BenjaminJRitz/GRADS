import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GRADSTest {
	GRADS testGRADS;
	
	@Before
	public void setUp() throws Exception {
		testGRADS = new GRADS();
		testGRADS.currentUser.networkID = "TESTUSER";
		testGRADS.currentUser.firstName = "TESTFIRST";
		testGRADS.currentUser.lastName = "TESTLAST";
		//Make sure below is changed to "STUDENT" for appropriate tests
		testGRADS.currentUser.role = "GRADUATE_PROGRAM_COORDINATOR";
		//Likewise, the other testable strings are:
		//"COMPUTER_INFORMATION_SYSTEMS"
		//"COMPUTER_ENGINEERING"
		testGRADS.currentUser.program = "COMPUTER_SCIENCE";
	}

	@After
	public void tearDown() throws Exception {
		//Clear test class and mark it for garbage collection
		testGRADS = null;
	}
	
	//****************** LoadUsers tests ******************

	//If loadUsers is provided with an invalid file name, it should throw an exception.
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThatLoadUsersThrowsFileNotFoundError() throws Exception {
		String badFileName = null;
		testGRADS.loadUsers(badFileName);
	}
	
	//If provided a good user file, users should be populated.
	@Test
	public void testLoadUsersPopulatesHashMap() throws Exception {
		String goodFileName = "users.json";
		testGRADS.loadUsers(goodFileName);
		assertFalse(testGRADS.users.isEmpty());
	}
	
	//Make sure a specific user ended up in users.
	@Test
	public void testLoadUsersHasUser() throws Exception {
		String goodFileName = "users.json";
		testGRADS.loadUsers(goodFileName);
		assertTrue(testGRADS.users.containsKey("ggay"));
	}
	
	//****************** LoadCourses tests ******************
	//LoadCourses works exactly the same as LoadUsers, so the tests are identical:
	
	//If loadCourses is provided with an invalid file name, it should throw an exception.
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThatLoadCoursesThrowsFileNotFoundError() throws Exception {
		String badFileName = null;
		testGRADS.loadCourses(badFileName);
	}
	
	//If provided a good course file, courses should be populated.
	@Test
	public void testLoadCoursesPopulatesHashMap() throws Exception {
		String goodFileName = "courses.json";
		testGRADS.loadCourses(goodFileName);
		assertFalse(testGRADS.courses.isEmpty());
	}
	
	//Make sure a specific course ended up in courses.
	@Test
	public void testLoadCoursesHasCourse() throws Exception {
		String goodFileName = "courses.json";
		testGRADS.loadCourses(goodFileName);
		assertTrue(testGRADS.courses.containsKey("Software Engineering"));
	}
	
	//****************** LoadRecords tests ******************
	
	@Test(expected = java.io.FileNotFoundException.class)
	public void testThatLoadRecordsThrowsFileNotFoundError() throws Exception {
		String badFileName = null;
		testGRADS.loadRecords(badFileName);
	}
	
	public void testLoadRecordsPopulatesHashMap() throws Exception {
		String goodFileName = "students.json";
		testGRADS.loadRecords(goodFileName);
		assertFalse(testGRADS.records.isEmpty());
	}
	
	public void testThatLoadRecordsHasStudent() throws Exception {
		String goodFileName = "students.json";
		testGRADS.loadRecords(goodFileName);
		assertTrue(testGRADS.records.containsKey("mhunt"));
	}
	
	//****************** setUser tests ******************
	@Test 
	public void testSetUserForValidUser() {
		try {
			testGRADS.setUser("ggay");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "ggay";
		assertTrue(testGRADS.currentUser.networkID.equals(expected));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testSetUserForInvalidUser() throws Exception {
		try {
			testGRADS.setUser("INVALIDUSER");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//****************** GetUser tests ******************
	
	//This method is just a single statement, so we just test that it returns the default user value.
	@Test
	public void testGetUser() {
		assertTrue(testGRADS.getUser().equals("TESTUSER"));
	}


}

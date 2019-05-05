import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TermBeganTest {
	TermBegan test;
	
	@Before
	public void setUp() throws Exception {
        GRADS.init();
        GRADS.loadRecords("students.json");
        test = GRADS.records.get("mhunt").getTermBegan();
	}

	@After
	public void tearDown() throws Exception {
		//Clear test class and mark it for garbage collection
		test = null;
	}

	@Test
	public void testGetSemester() throws Exception {
		assertTrue(test.getSemesterBegan().equals("FALL"));
	}
	
	@Test
	public void testGetYear() throws Exception {
		assertTrue(test.getYearBegan().equals("2017"));
	}
}

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProgressSummaryTest {

	ProgressSummary ps;
	
	@Before
	public void setUp() throws Exception {
        GRADS.init();
        GRADS.loadRecords("testrecords.json");
        ps = new ProgressSummary(GRADS.getTranscript("jdoe"));
	}
	
	@After
	public void tearDown() throws Exception {
		//Clear test class and mark it for garbage collection
		ps = null;
	}
	
	@Test
	public void testGetGPA() {
		assertTrue(ps.getGPA() - 3.0 < 0.00001); //comparing doubles with threshold
	}
	
	@Test
	public void testGetters() {
		assertTrue(ps.getStudent().getNetworkID().equals("jdoe"));
		assertTrue(ps.getMajor().equals("COMPUTER_SCIENCE"));
		assertTrue(ps.getAdvisor().getFirstName().equals("Duncan"));
		assertTrue(ps.getTermBegan().getSemesterBegan().equals("FALL"));
		assertTrue(ps.getTermBegan().getYearBegan().equals("2019"));
	}

	
}

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
	}
	
	@After
	public void tearDown() throws Exception {
		//Clear test class and mark it for garbage collection
		ps = null;
	}
	
	@Test
	public void testGetGPA() throws UserNotFoundException {
		ps = new ProgressSummary(GRADS.getTranscript("jdoe"));
		assertTrue(Math.abs(ps.getGPA() - 3.0) < 0.00001); //comparing doubles with threshold
	}
	
	@Test
	public void testGetters() throws UserNotFoundException {
		ps = new ProgressSummary(GRADS.getTranscript("jdoe"));
		assertTrue(ps.getStudent().getNetworkID().equals("jdoe"));
		assertTrue(ps.getMajor().equals("COMPUTER_SCIENCE"));
		assertTrue(ps.getAdvisor().getFirstName().equals("Duncan"));
		assertTrue(ps.getTermBegan().getSemesterBegan().equals("FALL"));
		assertTrue(ps.getTermBegan().getYearBegan().equals("2019"));
	}
	
	@Test
	public void testGetCompletionPercentage() throws UserNotFoundException {
		ps = new ProgressSummary(GRADS.getTranscript("sroe"));
		assertTrue(Math.abs(ps.getCompletionPercentage()) < 0.00001); //comparing doubles with threshold
		ps = new ProgressSummary(GRADS.getTranscript("jdoe"));
		assertTrue(Math.abs(ps.getCompletionPercentage()) > 0); //comparing doubles with threshold
		ps = new ProgressSummary(GRADS.getTranscript("jho"));
		assertTrue(Math.abs(ps.getCompletionPercentage()) > 0); //comparing doubles with threshold
		ps = new ProgressSummary(GRADS.getTranscript("sdoe"));
		assertTrue(Math.abs(ps.getCompletionPercentage()) > 0); //comparing doubles with threshold
	}
	
}

package edu.ncsu.csc216.stp.model.manager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class TestPlanManagerTest {
	
	private static TestPlanManager manager = new TestPlanManager();
	String testFile1 = "test-plans0.txt";
	
	@Test
	void testLoadTestPlans() {
		manager.loadTestPlans(new File(testFile1));
		String[] names = manager.getTestPlanNames();
		assertEquals("PackScheduler", names[0]);
	}
	@Test
	void testSaveTestPlans() {
		fail();
	}
	@Test
	void testAddTestPlan() {
		fail();
	}
}

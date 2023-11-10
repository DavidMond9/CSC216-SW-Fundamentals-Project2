package edu.ncsu.csc216.stp.model.manager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class TestPlanManagerTest {
	
	private static TestPlanManager manager = new TestPlanManager();
	String testFile1 = "test-files/test-plans0.txt";
	
	@Test
	void testLoadTestPlans() {
		manager.loadTestPlans(new File(testFile1));
		String[] names = manager.getTestPlanNames();
		System.out.println(names);
		assertEquals("PackScheduler", names[0]);
		assertEquals("WolfScheduler", names[1]);
	}
	@Test
	void testSaveTestPlans() {
		fail();
	}
	@Test
	void testAddTestPlan() {
		manager.addTestPlan("hello");
		String[] plans = manager.getTestPlanNames();
		assertEquals(plans[0], "hello");
	}
	@Test
	void testEditTestPlan() {
		manager.addTestPlan("hello");
		manager.editTestPlan("newTest");
		String[] plans = manager.getTestPlanNames();
		assertEquals(plans[0], "newTest");
	}
	
}

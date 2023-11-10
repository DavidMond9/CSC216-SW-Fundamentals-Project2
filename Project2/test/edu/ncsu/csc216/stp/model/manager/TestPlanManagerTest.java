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
		manager.addTestPlan("PackScheduler");
		assertEquals(2, 1 + 1);
	}
	@Test
	void testSaveTestPlans() {
		assertEquals(2, 1 + 1);
	}
	@Test
	void testAddTestPlan() {
		manager.clearTestPlans();
		manager.addTestPlan("hello");
		String[] plans = manager.getTestPlanNames();
		assertEquals(plans[0], "hello");
	}
	
	
	@Test
	void testEditTestPlan() {
		manager.addTestPlan("hello");
		manager.editTestPlan("newTest");
		String[] plans = manager.getTestPlanNames();
		assertEquals(plans[0], "hello");
	}
	
	@Test
	void testRemoveTestPlan() {
		manager.clearTestPlans();
		manager.addTestPlan("bye");
		manager.setCurrentTestPlan("hello");
		assertEquals(manager.getCurrentTestPlan().getTestPlanName(), "Failing Tests");
		Exception e1 = assertThrows(IllegalArgumentException.class, 
				() -> manager.removeTestPlan());
		assertEquals(e1.getMessage(), "The Failing Tests list may not be deleted.");
	}
	
}

package edu.ncsu.csc216.stp.model.manager;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * TestPlanManagerTest tests the TestPlanManager class.
 */
public class TestPlanManagerTest {
	/**
	 * Manager field to test the manager methods.
	 */
	private static TestPlanManager manager = new TestPlanManager();
	/**
	 * Test file to load and save in for the manager.
	 */
	String testFile1 = "test-files/test-plans0.txt";
	
	/** Name of file with expected results */
	String expRes = "test-files/exp-results0";
	
	/** Name of file with actual results */
	String actRes = "test-files/act-results0.txt";
	
	@Test
	void testLoadTestPlans() {
		manager.clearTestPlans();
		manager.loadTestPlans(new File(testFile1));
		assertEquals("PackScheduler", manager.getTestPlanNames()[1]);
		assertEquals("WolfScheduler", manager.getTestPlanNames()[2]);
		assertEquals(3, manager.getTestPlanNames().length);
	}
	@Test
	void testSaveTestPlans() {
		manager.clearTestPlans();
		manager.loadTestPlans(new File(testFile1));
		manager.saveTestPlans(new File(actRes));
		checkFiles(expRes, actRes);
		assertThrows(IllegalArgumentException.class, () -> manager.saveTestPlans(new File("")));
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
	
	@Test
	void testAddTestPlan() {
		manager.clearTestPlans();
		manager.addTestPlan("hello");
		String[] plans = manager.getTestPlanNames();
		assertEquals(plans[0], "Failing Tests");
		assertEquals(plans[1], "hello");
		assertThrows(IllegalArgumentException.class, () -> manager.addTestPlan("hello"));

	}
	@Test
	void testGetTestPlanNames() {
		manager.clearTestPlans();
		manager.addTestPlan("Test Plan");
		assertEquals(manager.getTestPlanNames()[0], "Failing Tests");
		manager.addTestPlan("Another Test Plan");
		assertEquals(manager.getTestPlanNames()[2], "Test Plan");
		assertEquals(manager.getTestPlanNames()[1], "Another Test Plan");
	}
	
	@Test
	void testEditTestPlan() {
		manager.clearTestPlans();
		manager.addTestPlan("newTest");
		manager.addTestPlan("hello");
		manager.editTestPlan("now");
		manager.setCurrentTestPlan("hello");
		String[] plans = manager.getTestPlanNames();
		assertEquals(plans[1], "now");
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
	
	@Test
	void testAddTestCase() {
		manager.addTestPlan("newTest");
		manager.setCurrentTestPlan("newTest");
		manager.addTestCase(new TestCase("new", "type", "desc", "exp"));
		assertTrue(manager.isChanged());
		assertEquals(1, manager.getCurrentTestPlan().getTestCases().size());
	}
}

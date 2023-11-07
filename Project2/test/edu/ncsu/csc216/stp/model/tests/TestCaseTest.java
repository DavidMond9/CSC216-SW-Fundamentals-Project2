package edu.ncsu.csc216.stp.model.tests;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the TestCase class
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestCaseTest {
	
	@Test
	void testTestCase() {
		TestCase test = new TestCase("1", "type", "description", "exp");
		assertEquals("1", test.getTestCaseId());
		assertEquals("type", test.getTestType());
		assertEquals("description", test.getTestDescription());
		assertEquals("exp", test.getExpectedResults());
		assertEquals(test.getTestPlan(), null);
		assertEquals(test.getActualResultsLog(), "");
		
		
		Exception e1 = assertThrows(IllegalArgumentException.class, 
				() -> new TestCase("", "type", "description", "exp"));
		assertEquals("Invalid test information.", e1.getMessage());
		
		Exception e2 = assertThrows(IllegalArgumentException.class, 
				() -> new TestCase("1", "", "description", "exp"));
		assertEquals("Invalid test information.", e2.getMessage());
		
		Exception e3 = assertThrows(IllegalArgumentException.class, 
				() -> new TestCase("1", "type", "", "exp"));
		assertEquals("Invalid test information.", e3.getMessage());
		
		Exception e4 = assertThrows(IllegalArgumentException.class, 
				() -> new TestCase("1", "type", "description", ""));
		assertEquals("Invalid test information.", e4.getMessage());
	}
	
	@Test
	void testAddTestResult() {
<<<<<<< HEAD
		fail();	
=======
		TestCase test = new TestCase("1", "type", "description", "exp");
		test.addTestResult(false, "fail");
		assertFalse(test.isTestCasePassing());
		assertEquals("- FAIL: fail\n", test.getActualResultsLog());
	}
	
	@Test
	void testSetTestPlan() {
		TestCase test = new TestCase("1", "type", "description", "exp");
		TestPlan testPlan = new TestPlan("test");
		test.setTestPlan(testPlan);
		
		assertEquals(testPlan, test.getTestPlan());
	}
	
	@Test
	void testToString() {
		
>>>>>>> branch 'main' of https://github.ncsu.edu/engr-csc216-fall2023/csc216-P2-T-025.git
	}
}

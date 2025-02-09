package edu.ncsu.csc216.stp.model.test_plans;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AbstractTestPlanTest class tests AbstractTestPlan and all of its methods.
 */
public class AbstractTestPlanTest {
	
	/**
	 * Abstract Test Plan 1 to test the methods.
	 */
	AbstractTestPlan test1 = new TestPlan("Name");
	/**
	 * Abstract Test Plan 1 to test the methods.
	 */
	AbstractTestPlan test2 = new TestPlan("Name2");
	/**
	 * TestCase to test with the abstract test plan.
	 */
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	
	@Test
	void testSetTestPlanName() {
		test1.setTestPlanName("hello");
		assertEquals("hello", test1.getTestPlanName());
		Exception e = assertThrows(IllegalArgumentException.class, () -> test1.setTestPlanName(null));
		assertEquals(e.getMessage(), "Invalid name.");
	}
	@Test
	void testGetNumberOfFailingTests() {
		assertEquals(test1.getNumberOfFailingTests(), 0);
	}
	@Test
	void testGetTestCase() {
		test1.addTestCase(newCase);
		assertEquals(test1.getTestCase(0).getTestCaseId(), "5");
		assertEquals(test1.getTestCase(0).getTestType(), "Old");
		assertEquals(test1.getTestCase(0).getTestDescription(), "Desc");
		assertThrows(IndexOutOfBoundsException.class, () -> test1.getTestCase(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> test1.getTestCase(1));
	}
	@Test
	void testEquals() {
		assertNotEquals(test1, test2);
	}
	@Test 
	void testHashcode() {
		assertEquals(test1.hashCode(), 2420426);
	}
	
	@Test
	void testAddTestResult() {
		test1.addTestCase(newCase);
		test1.addTestResult(0, true, "failed");
		assertEquals("PASS", newCase.getStatus());
		assertThrows(IndexOutOfBoundsException.class, () -> test1.addTestResult(-1, false, "words"));
		assertThrows(IndexOutOfBoundsException.class, () -> test1.addTestResult(2, false, "words"));
	}

}

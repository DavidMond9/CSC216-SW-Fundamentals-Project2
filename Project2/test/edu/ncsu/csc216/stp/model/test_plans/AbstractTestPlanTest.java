package edu.ncsu.csc216.stp.model.test_plans;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractTestPlanTest {
	
	AbstractTestPlan test1 = new TestPlan("Name");
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
	}

}

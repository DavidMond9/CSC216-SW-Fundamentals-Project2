package edu.ncsu.csc216.stp.model.test_plans;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;
/**
 * TestPlanTest tests the TestPlan class and all of its methods.
 */
public class TestPlanTest {
	
	/**
	 * TestCase 1 to test with the test plan.
	 */
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	/**
	 * TestCase 2 to test with the test plan.
	 */
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	/**
	 * TestPlan 1 to test with the test plan.
	 */
	TestPlan plan = new TestPlan("plan");
	/**
	 * TestPlan 2 to test with the test plan.
	 */
	TestPlan plan2 = new TestPlan("plan2");
	@Test
	void testAddTestCase() {
		plan.addTestCase(newCase);
		assertEquals(plan.getTestCase(0).getTestCaseId(), "5");
		TestPlan plan1 = new TestPlan("plan");
		TestCase case1 = new TestCase("temp", "temp", "temp", "temp");
		plan1.addTestCase(case1);
		assertEquals(case1, plan1.getTestCase(0));
	}
	@Test
	void testGetTestCasesAsArray() {
		newCase.setTestPlan(plan);
		newCase2.setTestPlan(plan2);
		plan.addTestCase(newCase);
		plan.addTestCase(newCase2);
		String[][] arr = plan.getTestCasesAsArray();
		assertEquals(arr[0][0], "5");
		assertEquals(arr[0][1], "Old");
	}
	@Test
	void testRemoveTestCase() {
		plan.addTestCase(newCase);
		TestCase removedCase = plan.removeTestCase(0);
		assertEquals(removedCase.getTestCaseId(), "5");
		assertEquals(removedCase.getTestDescription(), "Desc");
		TestPlan plan1 = new TestPlan("plan");
		TestCase case1 = new TestCase("temp", "temp", "temp", "temp");
		plan1.addTestCase(case1);
		String[][] tests = plan1.getTestCasesAsArray();
		assertEquals("temp", tests[0][1]);
	}
}

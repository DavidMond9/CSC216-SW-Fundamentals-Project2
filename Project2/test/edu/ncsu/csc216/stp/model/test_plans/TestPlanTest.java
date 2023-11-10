package edu.ncsu.csc216.stp.model.test_plans;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlanTest {
	
	
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	TestPlan plan = new TestPlan("plan");
	TestPlan plan2 = new TestPlan("plan2");
	@Test
	void testAddTestCase() {
		plan.addTestCase(newCase);
		assertEquals(plan.getTestCase(0).getTestCaseId(), "5");
		TestPlan plan = new TestPlan("plan");
		TestCase case1 = new TestCase("temp", "temp", "temp", "temp");
		plan.addTestCase(case1);
		assertEquals(case1, plan.getTestCase(0));
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
		TestPlan plan = new TestPlan("plan");
		TestCase case1 = new TestCase("temp", "temp", "temp", "temp");
		plan.addTestCase(case1);
		String[][] tests = plan.getTestCasesAsArray();
		assertEquals("temp", tests[0][1]);
	}
}

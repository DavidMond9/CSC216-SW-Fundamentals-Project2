package edu.ncsu.csc216.stp.model.test_plans;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlanTest {
	@Test
	void testAddTestCase() {
		TestPlan plan = new TestPlan("plan");
		TestCase case1 = new TestCase("temp", "temp", "temp", "temp");
		plan.addTestCase(case1);
		assertEquals(case1, plan.getTestCase(0));
	}
	@Test
	void testGetTestCasesAsArray() {
		TestPlan plan = new TestPlan("plan");
		TestCase case1 = new TestCase("temp", "temp", "temp", "temp");
		plan.addTestCase(case1);
		String[][] tests = plan.getTestCasesAsArray();
		assertEquals("temp", tests[0][1]);
	}
}

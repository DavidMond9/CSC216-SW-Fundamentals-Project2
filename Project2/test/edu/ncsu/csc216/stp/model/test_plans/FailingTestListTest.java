package edu.ncsu.csc216.stp.model.test_plans;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class FailingTestListTest {
	
	FailingTestList test1 = new FailingTestList();
	FailingTestList test2 = new FailingTestList();

	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	TestPlan plan = new TestPlan("plan");
	TestPlan plan2 = new TestPlan("plan2");

	
	@Test
	void testAddTestCase() {
		test1.addTestCase(newCase);
		assertEquals(test1.getTestCase(0).getTestCaseId(), "5");
	}
	@Test
	void testGetTestCasesAsArray() {
		newCase.setTestPlan(plan);
		newCase2.setTestPlan(plan2);
		test1.addTestCase(newCase);
		test1.addTestCase(newCase2);
		String[][] arr = test1.getTestCasesAsArray();
		assertEquals(arr[0][0], "5");
		assertEquals(arr[0][1], "Old");
	}

}

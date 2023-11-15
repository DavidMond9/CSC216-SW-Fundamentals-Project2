package edu.ncsu.csc216.stp.model.test_plans;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FailingTestListTest class tests the FailingTestList and of all its methods.
 */
public class FailingTestListTest {
	
	/**
	 * A test FailingTestList to test out the methods of FailingTestList.
	 */
	FailingTestList test1 = new FailingTestList();
	/**
	 * Another test FailingTestList to test out the methods of FailingTestList.
	 */
	FailingTestList test2 = new FailingTestList();
	/**
	 * TestCase to test with the failing test list.
	 */
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	/**
	 * TestCase 2 to test with the failing test list.
	 */
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	/**
	 * TestPlan 1 to test with the failing test list.
	 */
	TestPlan plan = new TestPlan("plan");
	/**
	 * TestPlan 2 to test with the failing test list.
	 */
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

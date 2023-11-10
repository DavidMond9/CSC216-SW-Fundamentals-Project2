package edu.ncsu.csc216.stp.model.test_plans;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class FailingTestListTest {
	
	FailingTestList test1 = new FailingTestList();
	FailingTestList test2 = new FailingTestList();

	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	
	@Test
	void testAddTestCase() {
		test1.addTestCase(newCase);
		assertEquals(test1.getTestCase(0).getTestCaseId(), "5");
	}
	@Test
	void testGetTestCasesAsArray() {
		test1.addTestCase(newCase);
	}

}

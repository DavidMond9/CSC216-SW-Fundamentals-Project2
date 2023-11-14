package edu.ncsu.csc216.stp.model.io;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class TestPlanReaderTest {

	File test = new File("test-files/test-plans0.txt");
	private ISortedList<TestPlan> testPlans;

	@Test
	void testReadTestPlansFile() {
		testPlans = TestPlanReader.readTestPlansFile(test);
		//readTestPlansFile(test);
		assertEquals(testPlans.size(), 2);
		assertEquals(testPlans.get(1).getTestPlanName(), "WolfScheduler");
		assertEquals(testPlans.get(0).getTestPlanName(), "PackScheduler");
		System.out.println(testPlans.get(1).getTestCasesAsArray()[2][0]);
		assertEquals(testPlans.get(1).getTestCase(0).getTestCaseId(), "test1");
		assertEquals(testPlans.get(1).getTestCase(0).getTestType(), "Equivalence Class");
		assertEquals(testPlans.get(1).getTestCase(0).getTestDescription(), "description" + "\n" + "with multiple lines");
		assertEquals(testPlans.get(1).getTestCase(0).getExpectedResults(), "expected results" + "\n" + "with multiple lines");

		assertEquals(testPlans.get(1).getTestCase(1).getTestCaseId(), "test2");
		assertEquals(testPlans.get(1).getTestCase(1).getTestType(), "Boundary Value");
		assertEquals(testPlans.get(1).getTestCase(1).getTestDescription(), "description");
		assertEquals(testPlans.get(1).getTestCase(1).getExpectedResults(), "expected results");

		
		
		assertEquals(testPlans.get(1).getTestCase(2).getTestCaseId(), "test3");
		assertEquals(testPlans.get(1).getNumberOfFailingTests(), 2);
		
		assertEquals(testPlans.get(0).getTestCase(0).getTestCaseId(), "test0");
		assertEquals(testPlans.get(0).getTestCase(1).getTestCaseId(), "test1");




		

	}
	
}

package edu.ncsu.csc216.stp.model.io;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * TestPlanReader class, reads a file for the Test Plan.
 * @author David Mond and Gavin Douglas
 */
public class TestPlanReader {

	/**
	 * Constructor for the TestPlanReader.
	 */
	public TestPlanReader() {
		
	}
	/**
	 * Reads the test plan to a file.
	 * @param file File to be read from.
	 * @return returns a sorted list of the test plan.
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file){
		return null;
	}
	
	/**
	 * Processes a test plan.
	 * @param testPlan String to actually process the test plan.
	 * @return returns a TestPlan that was processed to go back to the reader.
	 */
	private static TestPlan processTestPlan(String testPlan) {
		return null;
	}
	
	/**
	 * Processes a test case.
	 * @param test The abstract test plan to get the test cases.
	 * @param name Name of the test case.
	 * @return Returns the test case that was processed to go back to the reader.
	 */
	private static TestCase processTest(AbstractTestPlan test, String name) {
		return null;
	}
}

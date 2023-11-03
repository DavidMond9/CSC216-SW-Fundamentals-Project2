package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * A test plan holds a list of test cases that are passing or failing
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {

	/**
	 * Constructor for the test plan
	 * @param planName name of the test plan
	 */
	public TestPlan(String planName) {
		super(planName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the test cases and their information as a 2D array
	 * @return a 2D array of test cases
	 */
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	/**
	 * adds a test case to the plan
	 * @param testcase test case to be added
	 */
	public void addTestCase(TestCase testcase) {
		
	}
	
	/**
	 * Compares this test plan to another test plan
	 * @param plan plan to be compared to
	 * @return the value of the compareTo method
	 */
	public int compareTo(TestPlan plan) {
		return 0;
	}
}

package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Failing test list represents a list of only the failing tests for one test plan
 * @author Gavin Douglas
 * @author David Mond
 */
public class FailingTestList extends AbstractTestPlan {
	
	/** Name of the failing test list */
	public static final String FAILING_TEST_LIST_NAME = "Failing Tests";
	
	/**
	 * Constructor for the failing test list
	 */
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
	}
	
	/**
	 * Adds a test case to the list
	 * @param testcase test case to be added
	 */
	public void addTestCase(TestCase testcase) {
		
	}
	
	/**
	 * Sets the name of the test plan the test case is in
	 * @param name New name of the test plan
	 */
	public void setTestPlanName(String name) {
		
	}
	
	/**
	 * Gets the test cases and the data they hold as a 2D array
	 * @return a 2D array of the test cases
	 */
	public String[][] getTestCasesAsArray(){
		return null;
	}
	
	/**
	 * Clears all of the failing tests from the test plan
	 */
	public void clearTests() {
		
	}
}

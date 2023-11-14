package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.manager.TestPlanManager;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * Failing test list represents a list of only the failing tests for one test plan
 * @author Gavin Douglas
 * @author David Mond
 */
public class FailingTestList extends AbstractTestPlan {
	
	/** Name of the failing test list */
	public static final String FAILING_TEST_LIST_NAME = "Failing Tests";
	/**
	 * Test list for manager.
	 */
	private TestPlanManager failingTestList;
	
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
		if(testcase.isTestCasePassing()) {
			throw new IllegalArgumentException("Cannot add passing test case.");
		}
		super.addTestCase(testcase);
	}
	
	/**
	 * Sets the test plan name.
	 * @param name name of the test plan.
	 */
	public void setTestPlanName(String name) {
		super.setTestPlanName(name);
		if(!name.equalsIgnoreCase(FAILING_TEST_LIST_NAME)) {
			throw new IllegalArgumentException("The Failing Tests list cannot be edited.");
		}
	}
	
	/**
	 * Gets the test cases and the data they hold as a 2D array
	 * @return a 2D array of the test cases
	 */
	public String[][] getTestCasesAsArray(){
		ISwapList<TestCase> testList = super.getTestCases();
		String[][] res = new String[testList.size()][3];
		
		for(int i = 0; i < testList.size(); i++) {
			res[i][0] = super.getTestCase(i).getTestCaseId();
			res[i][1] = super.getTestCase(i).getTestType();
			if(super.getTestCase(i).getTestPlan() == null) {
				res[i][2] = "";
			}
			else {
				res[i][2] = super.getTestCase(i).getTestPlan().getTestPlanName();
			}
		}	
		return res;
	}
	
	/**
	 * Clears all of TestCases from the test plan manager
	 */
	public void clearTests() {
		for(int i = super.getTestCases().size(); i > 0; i--) {
			super.removeTestCase(i);
		}
	}
}

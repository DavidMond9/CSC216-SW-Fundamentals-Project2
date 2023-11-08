package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * A test plan holds a list of test cases that are passing or failing
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {

	/**
	 * Constructor for the test plan
	 * @param testPlanName name of the test plan
	 */
	public TestPlan(String testPlanName) {
		super(testPlanName);
		
	}
	
	/**
	 * Gets the test cases and their information as a 2D array
	 * @return a 2D array of test cases
	 */
	public String[][] getTestCasesAsArray() {
		ISwapList<TestCase> testList = this.getTestCases();
		String[][] res = new String[testList.size()][3];
		
		for(int i = 0; i < testList.size(); i++) {
			res[i][0] = this.getTestCase(i).getTestCaseId();
			res[i][1] = this.getTestCase(i).getTestType();
			res[i][2] = this.getTestCase(i).getStatus();
		}
		
		return res;
	}
	
	/**
	 * adds a test case to the plan
	 * @param testcase test case to be added
	 */
	public void addTestCase(TestCase testcase) {
		super.addTestCase(testcase);
		testcase.setTestPlan(this);
	}
	
	/**
	 * Compares this test plan to another test plan
	 * @param plan plan to be compared to
	 * @return the value of the compareTo method
	 */
	public int compareTo(TestPlan plan) {
		return this.getTestPlanName().toLowerCase()
				.compareTo(plan.getTestPlanName().toLowerCase());
	}
}

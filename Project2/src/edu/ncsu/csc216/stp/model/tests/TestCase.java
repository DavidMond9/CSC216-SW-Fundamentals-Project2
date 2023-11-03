package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * A test case represents a single system test case that has an expected output, and a possible result
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestCase {
	
	/** id of the test case */
	private String testCaseId;
	
	/** Type of the test case */
	private String testType;
	
	/** Description of what the test case is testing*/
	private String testDescription;
	
	/** Expected results of the test */
	private String expectedResults;
	
	/** Test plan the test case belongs to */
	private TestPlan testPlan;
	
	/**
	 * Constructor for TestCase
	 * @param id id of the test case
	 * @param type type of the test case
	 * @param description description of the test case
	 * @param expectedResults expected results of the test case
	 */
	public TestCase(String id, String type, String description, String expectedResults) {
		
	}

	/**
	 * Gets the id for the test case
	 * @return the testCaseId
	 */
	public String getTestCaseId() {
		return testCaseId;
	}

	/**
	 * Sets the id for the test case
	 * @param testCaseId the testCaseId to set
	 */
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	/**
	 * Gets the type of test
	 * @return the testType
	 */
	public String getTestType() {
		return testType;
	}

	/**
	 * 
	 * Sets the type of test
	 * @param testType the testType to set
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}

	/**
	 * Gets the description of the test
	 * @return the testDescription
	 */
	public String getTestDescription() {
		return testDescription;
	}

	/**
	 * Sets the description of the test
	 * @param testDescription the testDescription to set
	 */
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	/**
	 * Gets the expected results of the test case
	 * @return the expectedResults
	 */
	public String getExpectedResults() {
		return expectedResults;
	}

	/**
	 * Sets the expected results
	 * @param expectedResults the expectedResults to set
	 */
	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

	/**
	 * gets the test plan for the test case
	 * @return the testPlan
	 */
	public TestPlan getTestPlan() {
		return testPlan;
	}

	/**
	 * Sets the test plan for the test case
	 * @param testPlan the testPlan to set
	 */
	public void setTestPlan(TestPlan testPlan) {
		this.testPlan = testPlan;
	}
	
	/**
	 * Adds the actual results of the test to the test case once the test has been run
	 * @param passing true if the test case is passing, false otherwise
	 * @param actualResults actual results of the test 
	 */
	public void addTestResult(boolean passing, String actualResults) {
		
	}
	
	/**
	 * Checks if the test case is passing
	 * @return true if the test case is passing, false otherwise
	 */
	public boolean isTestCasePassing() {
		return false;
	}
	
	/**
	 * Gets the current status of the test case
	 * @return the status of the test case
	 */
	public String getStatus() {
		return null;
	}
	
	/**
	 * Gets the log of the actual results
	 * @return the log of the actual results
	 */
	public String getActualResultsLog() {
		return null;
	}

	@Override
	public String toString() {
		return "TestCase [testCaseId=" + testCaseId + ", testType=" + testType + ", testDescription=" + testDescription
				+ ", expectedResults=" + expectedResults + ", testPlan=" + testPlan + "]";
	}

}

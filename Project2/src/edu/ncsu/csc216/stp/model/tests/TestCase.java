package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.Log;

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
	
	/** Description of what the test case is testing */
	private String testDescription;
	
	/** Expected results of the test */
	private String expectedResults;
	
	/** Test plan the test case belongs to */
	private TestPlan testPlan;
	
	/** The log of test results for this test case */
	private Log<TestResult> testResults;
	
	/** Error message when a test case is constructed with invalid information */
	private static final String TEST_ERROR_MESSAGE = "Invalid test information.";
	
	/**
	 * Constructor for TestCase
	 * @param id id of the test case
	 * @param type type of the test case
	 * @param description description of the test case
	 * @param expectedResults expected results of the test case
	 */
	public TestCase(String id, String type, String description, String expectedResults) {
		setTestCaseId(id);
		setTestType(type);
		setTestDescription(description);
		setExpectedResults(expectedResults);
		testResults = new Log<TestResult>();
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
		if (testCaseId == null || testCaseId.isEmpty()) {
			throw new IllegalArgumentException(TEST_ERROR_MESSAGE);
		}
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
		if (testType == null || testType.isEmpty()) {
			throw new IllegalArgumentException(TEST_ERROR_MESSAGE);
		}
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
		if (testDescription == null || testDescription.isEmpty()) {
			throw new IllegalArgumentException(TEST_ERROR_MESSAGE);
		}
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
		if (expectedResults == null || expectedResults.isEmpty()) {
			throw new IllegalArgumentException(TEST_ERROR_MESSAGE);
		}
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
		if (testPlan == null) {
			throw new IllegalArgumentException("Invalid test plan.");
		}
		this.testPlan = testPlan;
	}
	
	/**
	 * Adds the actual results of the test to the test case once the test has been run
	 * @param passing true if the test case is passing, false otherwise
	 * @param actualResults actual results of the test 
	 */
	public void addTestResult(boolean passing, String actualResults) {
		TestResult testResult = new TestResult(passing, actualResults);
		testResults.add(testResult);
	}
	
	/**
	 * Checks if the test case is passing
	 * @return true if the test case is passing, false otherwise
	 */
	public boolean isTestCasePassing() {
		if (testResults.get(testResults.size() - 1).isPassing()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the current status of the test case
	 * @return the status of the test case
	 */
	public String getStatus() {
		if (testResults.get(testResults.size() - 1).isPassing()) {
			return TestResult.PASS;
		}
		
		return TestResult.FAIL;
	}
	
	/**
	 * Gets the log of the actual results
	 * @return the log of the actual results
	 */
	public String getActualResultsLog() {
		String log = "";
		for (int i = 0; i < testResults.size(); i++) {
			log += "- " + testResults.get(i).toString() + "\n";
		}
		
		return log;
	}

	@Override
	public String toString() {
		String test = "";
		test += "# " + getTestCaseId() + "," + getTestType() + "\n* " + getTestDescription() + "\n" + getActualResultsLog();
		return test;
	}

}

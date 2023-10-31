package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

public class TestCase {
	private String testCaseId;
	private String testType;
	private String testDescription;
	private String expectedResults;
	private TestPlan testPlan;
	
	public TestCase(String id, String type, String desc, String res) {
		
	}

	/**
	 * @return the testCaseId
	 */
	public String getTestCaseId() {
		return testCaseId;
	}

	/**
	 * @param testCaseId the testCaseId to set
	 */
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	/**
	 * @return the testType
	 */
	public String getTestType() {
		return testType;
	}

	/**
	 * @param testType the testType to set
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}

	/**
	 * @return the testDescription
	 */
	public String getTestDescription() {
		return testDescription;
	}

	/**
	 * @param testDescription the testDescription to set
	 */
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	/**
	 * @return the expectedResults
	 */
	public String getExpectedResults() {
		return expectedResults;
	}

	/**
	 * @param expectedResults the expectedResults to set
	 */
	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

	/**
	 * @return the testPlan
	 */
	public TestPlan getTestPlan() {
		return testPlan;
	}

	/**
	 * @param testPlan the testPlan to set
	 */
	public void setTestPlan(TestPlan testPlan) {
		this.testPlan = testPlan;
	}
	public void addTestResult(boolean result, String name) {
		
	}
	public boolean isTestCasePassing() {
		return false;
	}
	public String getStatus() {
		return null;
	}
	public String getActualResultsLog() {
		return null;
	}

	@Override
	public String toString() {
		return "TestCase [testCaseId=" + testCaseId + ", testType=" + testType + ", testDescription=" + testDescription
				+ ", expectedResults=" + expectedResults + ", testPlan=" + testPlan + "]";
	}

}

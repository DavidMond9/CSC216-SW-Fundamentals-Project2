package edu.ncsu.csc216.stp.model.tests;

/**
 * represents the result of a test once it has been run
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestResult {
	
	/** Label for a passing test */
	public static final String PASS = "PASS";
	
	/** Label for a failing test */
	public static final String FAIL = "FAIL";
	
	/** True if the test is passing, false otherwise */
	private boolean passing;
	
	/** actual results of the test case */
	private String actualResults;
	
	/**
	 * Constructor for TestResult
	 * @param passing true if the test is passing, false otherwise
	 * @param actualResults actual results of the test
	 */
	public TestResult(boolean passing, String actualResults) {
		setPassing(passing);
		setActualResults(actualResults);
	}

	/**
	 * Checks if the test is passing or failing
	 * @return true if the test is passing, false otherwise
	 */
	public boolean isPassing() {
		return passing;
	}

	/**
	 * Sets the test to passing or failing
	 * @param passing true if the test is passing, false otherwise
	 */
	public void setPassing(boolean passing) {
		this.passing = passing;
	}

	/**
	 * Gets the actual results of the test
	 * @return the actualResults actual results of the test
	 */
	public String getActualResults() {
		return actualResults;
	}

	/**
	 * Sets the actual results of the test case
	 * @param actualResults the actualResults of the test case
	 */
	public void setActualResults(String actualResults) {
		if(actualResults == null) {
			throw new IllegalArgumentException("Invalid test results.");
		}
		this.actualResults = actualResults;
	}

	@Override
	public String toString() {
		if (passing) {
			return PASS + ": " + actualResults;
		}
		
		return FAIL + ": " + actualResults;
	}
	
}

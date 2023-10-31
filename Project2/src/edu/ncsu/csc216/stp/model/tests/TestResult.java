package edu.ncsu.csc216.stp.model.tests;

public class TestResult {
	public static final String PASS = "PASS";
	public static final String FAIL = "FAIL";
	private boolean passing;
	private String actualResults;
	
	public TestResult(boolean passing, String actualResults) {
		
	}

	/**
	 * @return the passing
	 */
	public boolean isPassing() {
		return passing;
	}

	/**
	 * @param passing the passing to set
	 */
	public void setPassing(boolean passing) {
		this.passing = passing;
	}

	/**
	 * @return the actualResults
	 */
	public String getActualResults() {
		return actualResults;
	}

	/**
	 * @param actualResults the actualResults to set
	 */
	public void setActualResults(String actualResults) {
		this.actualResults = actualResults;
	}

	@Override
	public String toString() {
		return "TestResult [passing=" + passing + ", actualResults=" + actualResults + "]";
	}
	
}

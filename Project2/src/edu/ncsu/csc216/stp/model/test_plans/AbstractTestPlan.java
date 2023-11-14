package edu.ncsu.csc216.stp.model.test_plans;


import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SwapList;

/**
 * Abstract test plan is an abstract class on top of the test plan hierarchy
 * @author Gavin Douglas
 * @author David Mond
 */
public abstract class AbstractTestPlan {
	
	/** Name of the test plan */
	private String testPlanName;

	/**
	 * SwapList of test cases for the current test cases.
	 */
	private ISwapList<TestCase> testList;
	/**
	 * Constructor for the abstract test plan
	 * @param planName name of the test plan
	 */
	public AbstractTestPlan(String planName) {
		setTestPlanName(planName);
		testList = new SwapList<TestCase>();
	}
	
	/**
	 * Sets the name for the test plan
	 * @param name name of the test plan
	 */
	public void setTestPlanName(String name) {
		if(name == null || "".equals(name)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if(FailingTestList.FAILING_TEST_LIST_NAME.equals(name)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		testPlanName = name;
	}
	
	/**
	 * Gets the name of the test plan
	 * @return the name of the test plan
	 */
	public String getTestPlanName() {
		return testPlanName;
	}
	
	/**
	 * Gets a list of test cases
	 * @return A SwapList of test cases
	 */
	public ISwapList<TestCase> getTestCases() {
		return testList;
	}
	
	/**
	 * Adds a test case to the plan
	 * @param testcase test case to be added
	 */
	public void addTestCase(TestCase testcase) {
		testList.add(testcase);		
	}
	
	/**
	 * Removes a test case form the plan
	 * @param idx index of the test case
	 * @return the removed test case
	 */
	public TestCase removeTestCase(int idx) {
		if(idx < 0 || idx > testList.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		TestCase test = testList.remove(idx);
		return test;
	}
	
	/**
	 * Gets the test case at the index
	 * @param idx index of the test csae
	 * @return the selected test case
	 */
	public TestCase getTestCase(int idx) {
		return testList.get(idx);
	}
	
	/**
	 * Gets the number of tests that are failing
	 * @return the number of failing tests
	 */
	public int getNumberOfFailingTests() {
		int count = 0;
		for(int i = 0; i < testList.size(); i++) {
			if(!testList.get(i).isTestCasePassing()) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Adds the actual results of a test to the data stored in that test
	 * @param idx index of the test case
	 * @param passing true if the test is passing, false otherwise
	 * @param actualResults actual results of the test case
	 */
	public void addTestResult(int idx, boolean passing, String actualResults) {
		testList.get(idx).addTestResult(passing, actualResults);

	}
	
	/**
	 * Gets the data stored in a test case as a 2D array
	 * @return a 2D array with the data stored in the test cases
	 */
	public abstract String[][] getTestCasesAsArray();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testPlanName == null) ? 0 : testPlanName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTestPlan other = (AbstractTestPlan) obj;
		if (testPlanName == null) {
			if (other.testPlanName != null)
				return false;
		} else if (!testPlanName.equals(other.testPlanName))
			return false;
		return true;
	}
	
	
}

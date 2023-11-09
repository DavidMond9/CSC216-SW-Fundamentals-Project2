package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.io.TestPlanReader;
import edu.ncsu.csc216.stp.model.io.TestPlanWriter;
import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * TestPlanManager class, manages all the test plans and works with IO to run the program.
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlanManager {
	
	private AbstractTestPlan currentTestPlan;
	
	private FailingTestList failingTestList;
	
	private ISortedList<TestPlan> testPlans;
	
	/**
	 * Field to see if test is changed.
	 */
	private boolean isChanged;
	
	/**
	 * Manages the list of system test plans
	 */
	public TestPlanManager() {
		clearTestPlans();
		testPlans = new SortedList();
		failingTestList = new FailingTestList();
		setCurrentTestPlan(failingTestList.getTestPlanName());
		isChanged = false;
		
	}
	
	/**
	 * Loads a list of test plans from a file
	 * @param file file test plans are loaded from
	 */
	public void loadTestPlans(File file) {
		testPlans = TestPlanReader.readTestPlansFile(file);
		currentTestPlan = testPlans.get(0);
	}
	
	/**
	 * Saves the list of test plans to a file
	 * @param file the test plans are being saved to
	 */
	public void saveTestPlans(File file) {
		TestPlanWriter.writeTestPlanFile(file, testPlans);
	}
	
	/**
	 * Checks to see if a test plan has been changed
	 * @return true if the test plan has been changed, false otherwise
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Adds a test to the current test plan
	 * @param test test to be added
	 */
	public void addTestPlan(String test) {
		
	}
	
	/**
	 * Gets the names of the tests in the current plan
	 * @return an array of the names of the tests
	 */
	public String[] getTestPlanNames() {
		return null;
	}
	
	/**
	 * Gets all of the failing tests in the current test plan
	 */
	private void getFailingTests() {
		
	}
	
	/**
	 * Sets the current test plan
	 * @param test name of the plan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		currentTestPlan = testPlanName;
	}
	
	/**
	 * Gets the current test plan
	 * @return the current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		getFailingTests();
		return null;
	}
	
	/**
	 * Changes the name of the current test plan
	 * @param name new name of the current test plan
	 */
	public void editTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Removes the current test plan
	 */
	public void removeTestPlan() {
		
	}
	
	/**
	 * Adds a test case to the end of the current test plan
	 * @param testcase test case to be added
	 */
	public void addTestCase(TestCase testcase) {
		
	}
	
	/**
	 * Adds the actual results of a test case to the data stored in the test case
	 * @param idx index of the test case
	 * @param passing true if the test is passing, false otherwise
	 * @param actualResult actual result of the test to be added to the test
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		
	}
	
	/**
	 * Clears out all of the test plans to create an empty manager
	 */
	public void clearTestPlans() {
		
	}
}
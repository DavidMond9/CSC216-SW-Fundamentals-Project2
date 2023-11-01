package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * TestPlanManager class, manages all the test plans and works with IO to run the program.
 */
public class TestPlanManager {
	
	/**
	 * Field to see if test is changed.
	 */
	private boolean isChanged;
	
	/**
	 * Manages the list of system test plans
	 */
	public TestPlanManager() {
		
	}
	
	/**
	 * Loads a list of test plans from a file
	 * @param file file test plans are loaded from
	 */
	public void loadTestPlans(File file) {
		
	}
	
	/**
	 * Saves the list of test plans to a file
	 * @param file the test plans are being saved to
	 */
	public void saveTestPlans(File file) {
		
	}
	
	/**
	 * Checks to see if a test plan has been changed
	 * @return true if the test plan has been changed, false otherwise
	 */
	public boolean isChanged() {
		return false;
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
	public void setCurrentTestPlan(String test) {
		
	}
	
	/**
	 * Gets the current test plan
	 * @return the current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return null;
	}
	
	/**
	 * 
	 * @param test
	 */
	public void editTestPlan(String test) {
		
	}
	
	/**
	 * 
	 */
	public void removeTestPlan() {
		
	}
	public void addTestCase(TestCase testcase) {
		
	}
	public void addTestResult(int num, boolean check, String test) {
		
	}
	public void clearTestPlans() {
		
	}
}
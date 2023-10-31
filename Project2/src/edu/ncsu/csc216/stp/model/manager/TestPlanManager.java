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
	
	public TestPlanManager() {
		
	}
	
	public void loadTestPlans(File file) {
		
	}
	
	public void saveTestPlans(File file) {
		
	}
	
	public boolean isChanged() {
		return false;
	}
	
	public void addTestPlan(String test) {
		
	}
	
	public String[] getTestPlanNames() {
		return null;
	}
	
	private void getFailingTests() {
		
	}
	public void setCurrentTestPlan(String test) {
		
	}
	public AbstractTestPlan getCurrentTestPlan() {
		return null;
	}
	public void editTestPlan(String test) {
		
	}
	public void removeTestPlan() {
		
	}
	public void addTestCase(TestCase testcase) {
		
	}
	public void addTestResult(int num, boolean check, String test) {
		
	}
	public void clearTestPlans() {
		
	}
}
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
	
	/** Current test plan in the view */
	private AbstractTestPlan currentTestPlan;
	
	/** List of failing tests in the test plans */
	private FailingTestList failingTestList;
	
	/** List of test plans passed into the manager */
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
	}
	
	/**
	 * Loads a list of test plans from a file
	 * @param file file test plans are loaded from
	 */
	public void loadTestPlans(File file) {
		testPlans = TestPlanReader.readTestPlansFile(file);
		setCurrentTestPlan("Failing Tests");
	}
	
	/**
	 * Saves the list of test plans to a file
	 * @param file the test plans are being saved to
	 */	
	public void saveTestPlans(File file) {
		TestPlanWriter.writeTestPlanFile(file, testPlans);
		isChanged = false;
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
	 * @param testPlanName test to be added
	 */
	public void addTestPlan(String testPlanName) {
		for(int i = 0; i < testPlans.size(); i++) {
			String currName = testPlans.get(i).getTestPlanName().toLowerCase();
			if(currName.equals(testPlanName.toLowerCase()) || currName.equals(failingTestList.getTestPlanName().toLowerCase()) ) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		TestPlan test = new TestPlan(testPlanName);
		testPlans.add(test);
		System.out.println(testPlans.get(0).getTestPlanName());
		setCurrentTestPlan(test.getTestPlanName());
		isChanged = true;
	}
	
	/**
	 * Gets the names of the tests in the current plan
	 * @return an array of the names of the tests
	 */
	public String[] getTestPlanNames() {
		String[] res = new String[testPlans.size() + 2];
		for(int i = 0; i < testPlans.size() + 1; i++) {
			if(i == 0) {
				res[i] = "Failing Tests";
				System.out.println(res[i]);
			}
			else if(testPlans.get(i - 1).getTestPlanName() == null) {
				res[i] = "Failing Tests";
			}
			else {
				res[i] = testPlans.get(i - 1).getTestPlanName();
				System.out.println(res[i]);
			}
		}
		return res;
	}
	
	
	/**
	 * Sets the current test plan
	 * @param testPlanName name of the plan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		boolean found = false;
		for(int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName() == testPlanName) {
				currentTestPlan = testPlans.get(i);
				found = true;
			}
		}
		if(!found) {
			currentTestPlan = failingTestList;
		}
	}
	
	/**
	 * Gets the current test plan
	 * @return the current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	/**
	 * Changes the name of the current test plan
	 * @param testPlanName new name of the current test plan
	 */
	public void editTestPlan(String testPlanName) {

		if(currentTestPlan instanceof FailingTestList) {
			throw new IllegalArgumentException("The Failing Tests list may not be edited.");
		}
		if("Failing Tests".toLowerCase().equals(testPlanName.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for(int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName().toLowerCase() == testPlanName.toLowerCase()) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		if(testPlanName.equals(currentTestPlan.getTestPlanName())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		currentTestPlan.setTestPlanName(testPlanName);
		isChanged = true;	
	}
	
	/**
	 * Removes the current test plan
	 */
	public void removeTestPlan() {
		if(currentTestPlan instanceof FailingTestList) {
			throw new IllegalArgumentException("The Failing Tests list may not be deleted.");
		}
		for(int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName() == currentTestPlan.getTestPlanName()) {
				testPlans.remove(i);
			}
		}
		currentTestPlan = failingTestList;
		isChanged = true;
	}
	
	/**
	 * Adds a test case to the end of the current test plan
	 * @param testcase test case to be added
	 */
	public void addTestCase(TestCase testcase) {
		if(currentTestPlan instanceof TestPlan) {
			if(!testcase.isTestCasePassing()) {
				failingTestList.addTestCase(testcase);
			}
			currentTestPlan.addTestCase(testcase);
			isChanged = true;
		}
	}
	
	/**
	 * Adds the actual results of a test case to the data stored in the test case
	 * @param idx index of the test case
	 * @param passing true if the test is passing, false otherwise
	 * @param actualResult actual result of the test to be added to the test
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		currentTestPlan.getTestCase(idx).addTestResult(passing, actualResult);
	}
	
	/**
	 * Clears out all of the test plans to create an empty manager
	 */
	public void clearTestPlans() {
		testPlans = new SortedList<TestPlan>();
		failingTestList = new FailingTestList();
		currentTestPlan = failingTestList;
		isChanged = false;
	}
}
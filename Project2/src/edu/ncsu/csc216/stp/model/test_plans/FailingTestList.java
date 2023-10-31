package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

public class FailingTestList extends AbstractTestPlan {
	
	public static final String FAILING_TEST_LIST_NAME = "Failing Tests";
	
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
	}
	
	public void addTestCase(TestCase testcase) {
		
	}
	public void setTestPlanName(String name) {
		
	}
	public String[][] getTestCasesAsArray(){
		return null;
	}
	public void clearTests() {
		
	}
}

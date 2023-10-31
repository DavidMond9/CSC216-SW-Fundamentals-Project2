package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

public class TestPlan extends AbstractTestPlan implements Comparable {

	public TestPlan(String planName) {
		super(planName);
		// TODO Auto-generated constructor stub
	}
	
	public String[][] getTestCasesAsArray() {
		return null;
	}
	public void addTestCase(TestCase testcase) {
		
	}
	public int compareTo(TestPlan plan) {
		return 0;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

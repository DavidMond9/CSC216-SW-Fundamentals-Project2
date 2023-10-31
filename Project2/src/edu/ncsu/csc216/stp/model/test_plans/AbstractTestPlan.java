package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

public abstract class AbstractTestPlan {
	private String testPlanName;
	
	public AbstractTestPlan(String planName) {
		
	}
	
	public void setTestPlanName(String name) {
		
	}
	public String getTestPlanName() {
		return null;
	}
	public ISwapList<TestCase> getTestCases() {
		return null;
	}
	public void addTestCase(TestCase testcase) {
		
	}
	public TestCase removeTestCase(int num) {
		return null;
	}
	public TestCase getTestCase(int num) {
		return null;
	}
	public int getNumberOfFailingTests() {
		return 0;
	}
	public void addTestResult(int num, boolean result, String name) {
		
	}
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

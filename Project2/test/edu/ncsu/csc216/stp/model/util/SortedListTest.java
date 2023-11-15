package edu.ncsu.csc216.stp.model.util;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class SortedListTest {
	
	SortedList<TestPlan> sortedList = new SortedList();
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	TestCase newCase3 = new TestCase("7", "New", "D", "a");
	TestPlan plan = new TestPlan("plan");
	TestPlan plan2 = new TestPlan("plan2");
	@Test
	void testAddAndRemove() {
		sortedList.add(plan);
		sortedList.add(plan2);
		assertEquals(sortedList.size(), 2);
		assertEquals(sortedList.get(0).getTestPlanName(), "plan2");
		assertEquals(sortedList.get(1).getTestPlanName(), "plan");
		TestPlan removedPlan = sortedList.remove(1);
		assertEquals(removedPlan.getTestPlanName(), "plan");
		TestPlan removedPlan2 = sortedList.remove(0);
		assertEquals(removedPlan2.getTestPlanName(), "plan2");
	}
}

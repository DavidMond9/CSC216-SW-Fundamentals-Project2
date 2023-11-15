package edu.ncsu.csc216.stp.model.util;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SortedListTest tests the SortedList class and the ISortedList interface.
 */
public class SortedListTest {
	
	/**
	 * A SortedList of type TestPlan to test out the methods in sorted list.
	 */
	SortedList<TestPlan> sortedList = new SortedList();
	/**
	 * TestCase 1 to test with the sorted list.
	 */
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	/**
	 * TestCase 2 to test with the sorted list.
	 */
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	/**
	 * TestCase 3 to test with the sorted list.
	 */
	TestCase newCase3 = new TestCase("7", "New", "D", "a");
	/**
	 * TestPlan 1 to test with the sorted list.
	 */
	TestPlan plan = new TestPlan("plan");
	/**
	 * TestPlan 2 to test with the sorted list.
	 */
	TestPlan plan2 = new TestPlan("plan2");
	@Test
	void testAddAndRemove() {
		sortedList.add(plan);
		sortedList.add(plan2);
		assertEquals(sortedList.size(), 2);
		assertEquals(sortedList.get(0).getTestPlanName(), "plan");
		assertEquals(sortedList.get(1).getTestPlanName(), "plan2");
		TestPlan removedPlan = sortedList.remove(1);
		assertEquals(removedPlan.getTestPlanName(), "plan2");
		TestPlan removedPlan2 = sortedList.remove(0);
		assertEquals(removedPlan2.getTestPlanName(), "plan");
	}
}

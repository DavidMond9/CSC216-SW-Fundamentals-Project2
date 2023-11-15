package edu.ncsu.csc216.stp.model.util;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SwapListTest tests the SwapList class and the ISwapList interface.
 */
public class SwapListTest {
	/**
	 * A test SwapList of type TestCase to test the methods of the SwapList class.
	 */
	SwapList<TestCase> swapList = new SwapList<TestCase>();
	/**
	 * A test TestCase to use with the methods of SwapList.
	 */
	TestCase newCase = new TestCase("5", "Old", "Desc", "results");
	/**
	 * A test TestCase to use with the methods of SwapList.
	 */
	TestCase newCase2 = new TestCase("6", "Back", "Description", "res");
	/**
	 * A test TestCase to use with the methods of SwapList.
	 */
	TestCase newCase3 = new TestCase("7", "New", "D", "a");
	
	@Test
	void testAdd() {
		swapList.add(newCase);
		assertEquals(swapList.size(), 1);
		assertEquals(swapList.get(0).getTestCaseId(), "5");
	}
	@Test
	void testFrontDownUpBack() {
		swapList.add(newCase);
		swapList.add(newCase2);
		swapList.add(newCase3);
		swapList.moveToFront(2);
		assertEquals(swapList.get(0).getTestCaseId(), "7");
		swapList.moveToBack(0);
		assertEquals(swapList.get(0).getTestCaseId(), "5");
		swapList.moveDown(1);
		assertEquals(swapList.get(0).getTestCaseId(), "5");
		swapList.moveUp(1);
		assertEquals(swapList.get(0).getTestCaseId(), "7");
	}
	@Test
	void testRemove() {
		swapList.add(newCase);
		assertEquals(swapList.size(), 1);
		TestCase test = swapList.remove(0);
		assertEquals(swapList.size(), 0);
		assertEquals(test.getTestCaseId(), "5");


	}
}

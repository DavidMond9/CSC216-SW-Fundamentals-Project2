package edu.ncsu.csc216.stp.model.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the test result class
 */
public class TestResultTest {
	
	@Test
	void testTestResult() {
		TestResult test1 = new TestResult(true, "test1");
		assertEquals("test1", test1.getActualResults());
		assertTrue(test1.isPassing());
	}
	
	@Test
	void testToString() {
		TestResult test1 = new TestResult(true, "test1");
		assertEquals("PASS: test1", test1.toString());
	}
}

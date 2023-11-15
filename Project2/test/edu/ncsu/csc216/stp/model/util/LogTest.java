package edu.ncsu.csc216.stp.model.util;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the log data structure
 */
public class LogTest {
	@Test
	void testAddAndGet() {
		Log<String> test = new Log<String>();
		test.add("apple");
		assertEquals("apple", test.get(0));
		assertEquals(1, test.size());
		test.add("banana");
		assertEquals("apple", test.get(0));
		assertEquals("banana", test.get(1));
		test.add("c");
		test.add("d");
		test.add("e");
		test.add("f");
		test.add("g");
		test.add("h");
		test.add("i");
		test.add("j");
		assertEquals(10, test.size());
		assertEquals("j", test.get(9));
		assertThrows(IndexOutOfBoundsException.class, () -> test.get(-1));
		assertThrows(NullPointerException.class, () -> test.add(null));
	}
}

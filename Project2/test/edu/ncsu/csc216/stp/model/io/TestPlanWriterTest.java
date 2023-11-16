package edu.ncsu.csc216.stp.model.io;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.SortedList;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * TestPlanWriterTest tests the TestPlanWriter class.
 */
public class TestPlanWriterTest {
	@Test
	void testWriteTestPlanFile(){
		TestPlan plan = new TestPlan("one");
		TestPlan plan2 = new TestPlan("two");
		
		plan.addTestCase(new TestCase("one", "one", "one", "one"));
		plan2.addTestCase(new TestCase("two", "two", "two", "two"));
		
		SortedList<TestPlan> plans = new SortedList<TestPlan>();
		plans.add(plan);
		TestPlanWriter.writeTestPlanFile(new File("test-files/act_plans"), plans);
		try {
			Scanner scan = new Scanner(new FileInputStream("test-files/act_plans"));
			int size = 0;
			String[] lines = new String[4];
			while (scan.hasNextLine()) {
				lines[size] = scan.nextLine();
				size++;
			}
			assertEquals(4, size);
			assertEquals("! one", lines[0]);
			assertEquals("# one,one", lines[1]);
			assertEquals("* one", lines[2]);
			assertEquals("* one", lines[3]);
		} catch (FileNotFoundException e) {
			fail();
		}
	}
}

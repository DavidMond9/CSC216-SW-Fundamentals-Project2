package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.IOException;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * TestPlanWriter class writes a test plan to a file.
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlanWriter {
	
	/**
	 * Constructor to create a TestPlanWriter.
	 */
	public TestPlanWriter() {
		
	}
	
	/**
	 * Writes a test plan to a file.
	 * @param file File input for writing.
	 * @param list List of test plans to write out.
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> list) {
		try {
			
		} catch (IOException e) {
			throw new IllegalArgumentException
		}
	}
}

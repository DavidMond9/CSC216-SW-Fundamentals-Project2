package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * TestPlanWriter class writes a test plan to a file.
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlanWriter {
	
	/**
	 * Writes a test plan to a file.
	 * @param file File input for writing.
	 * @param list List of test plans to write out.
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> list) {
		try {
			PrintStream fileWriter = new PrintStream(file);
			for (int i = 0; i < list.size(); i++) {
				TestPlan plan = list.get(i);
				fileWriter.print("!" + plan.getTestPlanName() + "\n");
				
				for (int j = 0; j < plan.getTestCases().size(); j++) {
					fileWriter.print(plan.getTestCases().get(j).toString());
				}
				
				if (i != list.size() - 1) {
					fileWriter.print("\n");
				}
			}
			
			fileWriter.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}

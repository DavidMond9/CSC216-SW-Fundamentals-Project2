package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.Log;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * TestPlanReader class, reads a file for the Test Plan.
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlanReader {

	/**
	 * Constructor for the TestPlanReader.
	 */
	public TestPlanReader() {
		
	}
	/**
	 * Reads the test plan to a file.
	 * @param file File to be read from.
	 * @return returns a sorted list of the test plan.
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file){
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			String fileContent = "";
			SortedList<TestPlan> testPlans = new SortedList<TestPlan>();
			while (fileReader.hasNextLine()) {
				fileContent += fileReader.nextLine() + "\n";
			}
			fileReader.close();
			
			if (!fileContent.startsWith("!")) {
				throw new IllegalArgumentException("Unable to load file.");
			}
			
			// plan
			
			// scan
				// if testplan token
					// call testplan, pass in token
			Scanner scnr = new Scanner(fileContent);
			scnr.useDelimiter("\\r?\\n?[!]");
			while (scnr.hasNext()) {
				//Get the plan 
				String planString = scnr.next();
				
				String[] planLines = planString.split("\r?\n|$");
				
				//Fields for testPlan data
				TestPlan plan = null;
				TestCase testCase = new TestCase("temp", "temp", "temp", "temp");
				Log<String> results = new Log<String>();
				
				for (String token: planLines) {
					
					String expResults = "";
					//Get the plan name
					plan = processTestPlan(token);
					if (token.startsWith("#")) {
						token = token.substring(1);
						token = token.trim();
						String testCaseId = token;
						testCase.setTestCaseId(testCaseId);
					} 
					else if (token.startsWith("*") && testCase.getTestDescription() != null) {
						token = token.substring(1);
						token = token.trim();
						expResults += token;
					}
					
					else if (token.startsWith("*")) {
					token = token.substring(1);
					token = token.trim();
					String[] descLine = token.split(",");
					testCase.setTestDescription(descLine[0]);
					
					} 
					
					else if (token.startsWith("-")) {
						token = token.substring(1);
						token = token.trim();
						results.add(token);
					} 
					
					else {
						token = token.substring(1);
						token = token.trim();
						expResults += token;
					}
					
					if(expResults != "") {
						testCase.setExpectedResults(expResults);
					}
					
					plan.addTestCase(testCase);
				}
				
			}
				
			scnr.close();
			return testPlans;
		} catch(IOException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	}
	
	/**
	 * Processes a test plan.
	 * @param testPlan String to actually process the test plan.
	 * @return returns a TestPlan that was processed to go back to the reader.
	 */
	private static TestPlan processTestPlan(String testPlan) {
		// if token is testcase
			// call process test c
		String newTestPlan = testPlan.substring(1);
		newTestPlan = newTestPlan.trim();
		TestPlan newPlan = new TestPlan(newTestPlan);
		return newPlan;
	}
	
	
	
	
	/* private static TestCase processTest(AbstractTestPlan test, String name) {
		
		return null;
	}
	
	*/
}

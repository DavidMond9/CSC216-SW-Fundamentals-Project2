package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * TestPlanReader class, reads a file for the Test Plan.
 * @author Gavin Douglas
 * @author David Mond
 */
public class TestPlanReader {
	
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
			String actualRes = "";
			TestPlan currentPlan = null;
			TestCase testCase = new TestCase("temp", "temp", "temp", "temp");
			while (scnr.hasNext()) {
				//Get the plan 
				String planString = scnr.next();				
				String[] planLines = planString.split("\r?\n|$");
				String descLine = "";
				String expectedRes = "";
				String last = "";
				int count = 0;
				for (String token: planLines) {
					count += 1;
					if (token.startsWith("#")) {
						if("-".equals(last)) {
							if("PASS".equals(actualRes.substring(0, actualRes.indexOf(':')))) {
								testCase.addTestResult(true, actualRes.substring(6));
							}
							else {
								testCase.addTestResult(false, actualRes.substring(6));
							}
							currentPlan.addTestCase(testCase);
							testCase = new TestCase("temp", "temp", "temp", "temp");							
							actualRes = "";
							descLine = "";
							expectedRes = "";
						}
						if("*".equals(last)) {
							testCase.setExpectedResults(expectedRes);
							currentPlan.addTestCase(testCase);
							testCase = new TestCase("temp", "temp", "temp", "temp");							
							descLine = "";
							expectedRes = "";
						}
						token = token.substring(1);
						token = token.trim();
						if (token.contains(",")) {
							String testCaseId = token.substring(0, token.indexOf(','));
							String testType = token.substring(token.indexOf(',') + 1);
							testCase.setTestCaseId(testCaseId);
							testCase.setTestType(testType);
						}
						//String testCaseId = token.substring(0, token.indexOf(','));
						//String testType = token.substring(token.indexOf(',') + 1);
						//testCase.setTestCaseId(testCaseId);
						//testCase.setTestType(testType);
					} 
					else if (token.startsWith("*") && !"".equals(descLine)) {
						testCase.setTestDescription(descLine);
						token = token.substring(1);
						token = token.trim();
						expectedRes += token;
						last = "*";
					}
					
					else if (token.startsWith("*")) {
						token = token.substring(1);
						token = token.trim();
						descLine = token;
						last = "*";
					
					} 
					
					else if (token.startsWith("-")) {
						if("*".equals(last)) {
							if (!"".equals(expectedRes)) {
								testCase.setExpectedResults(expectedRes);
								expectedRes = "";
							}
							//testCase.setExpectedResults(expectedRes);
							//expectedRes = "";
							token = token.substring(1);
							token = token.trim();
							actualRes += token;
							if(count == planLines.length && testPlans.size() != 0) {
								if("PASS".equals(actualRes.substring(0, actualRes.indexOf(':')))) {
									testCase.addTestResult(true, actualRes.substring(6));
								}
								else {
									testCase.addTestResult(false, actualRes.substring(6));
								}
								currentPlan.addTestCase(testCase);
								testCase = new TestCase("temp", "temp", "temp", "temp"); 
								testPlans.add(currentPlan);
							}
						}
						if("-".equals(last)) {
							if (actualRes.contains(":")) {
								if("PASS".equals(actualRes.substring(0, actualRes.indexOf(':')))) {
									testCase.addTestResult(true, actualRes.substring(6));
								}
								else if ("FAIL".equals(actualRes.substring(0, actualRes.indexOf(':')))) {
									testCase.addTestResult(false, actualRes.substring(6));
									
								}
							}							
							descLine = "";
							actualRes = "";
							token = token.substring(1);
							token = token.trim();
							actualRes += token;
							if(count == planLines.length && testPlans.size() != 0) {
								currentPlan.addTestCase(testCase);
								testCase = new TestCase("temp", "temp", "temp", "temp");
								testPlans.add(currentPlan);
							}
						}
						
						last = "-";
					} 
					
					else {
						if("*".equals(last) && "temp".equals(testCase.getTestDescription())) {
							descLine += "\n" + token;
						}
						else if("*".equals(last)) {
							expectedRes += "\n" + token;
						}
						else if("-".equals(last)) {
							actualRes += "\n" + token;
							if(count == planLines.length && testPlans.size() != 0) {
								if("PASS".equals(actualRes.substring(0, actualRes.indexOf(':')))) {
									testCase.addTestResult(true, actualRes.substring(6));
								}
								else {
									testCase.addTestResult(false, actualRes.substring(6));
								}
								currentPlan.addTestCase(testCase);
								testCase = new TestCase("temp", "temp", "temp", "temp");
								testPlans.add(currentPlan);
							}
						}
						else {
							if(currentPlan != null && !token.substring(1).equals(currentPlan.getTestPlanName())) {
								if("PASS".equals(actualRes.substring(0, actualRes.indexOf(':')))) {
									testCase.addTestResult(true, actualRes.substring(6));
								}
								else {
									testCase.addTestResult(false, actualRes.substring(6));
								}
								currentPlan.addTestCase(testCase);
								testCase = new TestCase("temp", "temp", "temp", "temp");
								testPlans.add(currentPlan);
							}
							currentPlan = processTestPlan(token);
							token = token.substring(1);
							token = token.trim();
							descLine = "";
							expectedRes = "";
							actualRes = "";
						}
					}					
				}
			}
			scnr.close();
			if(testPlans.size() == 0) {
				testPlans.add(currentPlan);
			}
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

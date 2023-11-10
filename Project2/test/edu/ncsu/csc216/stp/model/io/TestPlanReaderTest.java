package edu.ncsu.csc216.stp.model.io;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.manager.TestPlanManager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class TestPlanReaderTest {
	private static TestPlanManager manager = new TestPlanManager();
	File test = new File("test-files/test-plans0.txt");
	@Test
	void testReadTestPlansFile() {
		//readTestPlansFile(test);
		fail();
	}
	
}

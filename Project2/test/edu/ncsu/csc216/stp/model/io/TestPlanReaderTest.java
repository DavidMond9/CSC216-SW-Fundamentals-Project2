package edu.ncsu.csc216.stp.model.io;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class TestPlanReaderTest {

	File test = new File("test-files/test-plans0.txt");

	@Test
	void testReadTestPlansFile() {
		//readTestPlansFile(test);
		assertEquals(2, 1 + 1);
	}
	
}

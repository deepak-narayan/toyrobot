package com.iress.toyrobot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

/**
 * Integration tests for the ConsoleToyRobotApp.
 */
class ConsoleToyRobotAppIntegrationTest {

	private InputStream in;
	private PrintStream out;
	private ConsoleToyRobotAppDependencies deps;

	@BeforeEach
	void setUp() throws Exception {
		out = Mockito.mock(PrintStream.class);
		deps = new ConsoleToyRobotAppDependencies();
	}
	
	@AfterEach
	void tearDown() throws IOException {
		in.close();
		out.close();
	}

	/**
	 * Set up the app for integration testing
	 * @param commands - All commands, in sequence
	 * @return The ConsoleToyRobotApp for testing
	 */
	private ConsoleToyRobotApp setupApp(String... commands) {
		StringBuilder allCommands = new StringBuilder("");
		for (String command : commands) {
			allCommands.append(command).append('\n');
		}
		in = new ByteArrayInputStream(allCommands.toString().getBytes());
		
		return new ConsoleToyRobotApp(in, out, deps);
	}
	
	/**
	 * Verify what was output on the outputStream
	 */
	private void verifyOutput(String expectedOutput) {
		Mockito.verify(out, Mockito.times(1)).println(ArgumentMatchers.eq(expectedOutput));
	}
	
	@Test
	void testValidCommands_00NORTHxMOVE_01NORTH() {
		setupApp("PLACE 0,0,NORTH", "MOVE", "REPORT", "EXIT").runApp();
		verifyOutput("Output: 0,1,NORTH");
	}

	@Test
	void testValidCommands_00NORTHxLEFT_00WEST() {
		setupApp("PLACE 0,0,NORTH", "LEFT", "REPORT", "EXIT").runApp();
		verifyOutput("Output: 0,0,WEST");
	}

	@Test
	void testValidCommands_12EASTxMOVExMOVExLEFTxMOVE_33NORTH() {
		setupApp("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT", "EXIT").runApp();
		verifyOutput("Output: 3,3,NORTH");
	}
	
	@Test
	void testValidCommands_12EASTxMOVEx55WEST_22WEST() {
		setupApp("PLACE 1,2,EAST", "MOVE", "PLACE 5,5,WEST", "REPORT", "EXIT").runApp();
		verifyOutput("Output: 5,5,WEST");
	}
	
	@Test
	void testOutOfBoundCommands_54EASTxMOVExMOVExLEFTxMOVE_55NORTH() {
		setupApp("PLACE 5,4,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT", "EXIT").runApp();
		verifyOutput("Output: 5,5,NORTH");
	}
	
	@Test
	void testOutOfBoundCommands_99EASTxMOVE_NotPlaced() {
		setupApp("PLACE 9,9,EAST", "MOVE", "REPORT", "EXIT").runApp();
		verifyOutput("Robot has not been placed");
	}

}

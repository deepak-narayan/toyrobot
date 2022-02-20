package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Tests for the Exit command
 */
class ExitCommandTest {

	@Test
	void testExitCommand_ExitSuccess() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		
		assertTrue(new ExitCommand().executeCommand(robot));
	}
	
}

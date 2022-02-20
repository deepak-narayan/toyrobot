package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Tests for the LEFT command
 */
class LeftCommandTest {

	@Test
	void testLeftCommand_turnLeftSuccess() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.turnLeft()).thenReturn(true);
		
		assertTrue(new LeftCommand().executeCommand(robot));
	}
	
	@Test
	void testLeftCommand_turnLeftFail() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.turnLeft()).thenReturn(false);
		
		assertFalse(new LeftCommand().executeCommand(robot));
	}

}

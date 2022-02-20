package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Tests for the Right command
 */
class RightCommandTest {

	@Test
	void testRightCommand_turnRightSuccess() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.turnRight()).thenReturn(true);
		
		assertTrue(new RightCommand().executeCommand(robot));
	}
	
	@Test
	void testRightCommand_turnRightFail() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.turnRight()).thenReturn(false);
		
		assertFalse(new RightCommand().executeCommand(robot));
	}

}

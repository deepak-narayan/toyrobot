package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Tests for the Move command
 */
class MoveCommandTest {

	@Test
	void testMoveCommand_MoveSuccess() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.moveForward()).thenReturn(true);
		
		MoveCommand cmd = new MoveCommand();
		
		assertTrue(cmd.executeCommand(robot));
		assertTrue("".equals(cmd.getOutput()));
	}
	
	@Test
	void testMoveCommand_MoveFail() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.moveForward()).thenReturn(false);
		
		assertFalse(new MoveCommand().executeCommand(robot));
	}

}

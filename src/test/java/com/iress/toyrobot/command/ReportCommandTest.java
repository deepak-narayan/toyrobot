package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.environment.Direction;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobotState;

/**
 * Tests for the Report command
 */
class ReportCommandTest {

	private TwoDimensionalRobot robot;
	private TwoDimensionalRobotState robotState;
	
	@BeforeEach
	void init() {
		robot = Mockito.mock(TwoDimensionalRobot.class);
		robotState = Mockito.mock(TwoDimensionalRobotState.class);
		Mockito.when(robot.getState()).thenReturn(robotState);
		
	}
	
	void setupState(int x, int y, Direction dir) {
		Mockito.when(robotState.getXCoordinate()).thenReturn(x);
		Mockito.when(robotState.getYCoordinate()).thenReturn(y);
		Mockito.when(robotState.getDirection()).thenReturn(dir);
	}
	
	@Test
	void testReportCommand_validState_returnStateString() {
		setupState(2, 3, Direction.SOUTH);
		
		ReportCommand cmd = new ReportCommand();
		
		assertTrue(cmd.executeCommand(robot));
		assertTrue(cmd.getOutput().equals("Output: 2,3,SOUTH"));
	}

	@Test
	void testReportCommand_invalidState_returnErrorString() {
		Mockito.doThrow(IllegalStateException.class).when(robot).getState();
		
		ReportCommand cmd = new ReportCommand();
		assertFalse(cmd.executeCommand(robot));
		assertTrue(cmd.getOutput().equals("Robot has not been placed"));
	}

}

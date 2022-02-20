package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.environment.Direction;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Tests for the PLACE command
 */
class PlaceCommandTest {

	@Test
	void testPlaceCommand_emptyParams_throwInvalidCommandException() {
		assertThrows(InvalidCommandException.class, () -> new PlaceCommand(""));
	}

	@Test
	void testPlaceCommand_validParams_placeRobot() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.teleport(2, 3, Direction.NORTH)).thenReturn(true);
		
		assertDoesNotThrow(() -> {
			PlaceCommand cmd = new PlaceCommand("2,3,NORTH");
			assertTrue(cmd.executeCommand(robot));
		});
	}
	
	@Test
	void testPlaceCommand_validParamsButOutOfBounds_DoNotPlaceRobot() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Mockito.when(robot.teleport(2, 10, Direction.NORTH)).thenReturn(false);
		
		assertDoesNotThrow(() -> {
			PlaceCommand cmd = new PlaceCommand("2,10,NORTH");
			assertFalse(cmd.executeCommand(robot));
		});
	}
	
	@Test
	void testPlaceCommand_validParamsWithLeadingAndTrailingSpace_placeRobot() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);	
		Mockito.when(robot.teleport(2, 3, Direction.NORTH)).thenReturn(true);
		
		assertDoesNotThrow(() -> {
			PlaceCommand cmd = new PlaceCommand(" 2   ,   3   ,  NORTH  ");
			assertTrue(cmd.executeCommand(robot));
		});
	}
	
	@Test
	void testPlaceCommand_InvalidXParam_throwInvalidCommandException() {
		assertThrows(InvalidCommandException.class, () -> new PlaceCommand("a,3,NORTH"));
	}
	
	@Test
	void testPlaceCommand_InvalidYParam_throwInvalidCommandException() {
		assertThrows(InvalidCommandException.class, () -> new PlaceCommand("2,a,NORTH"));
	}
	
	@Test
	void testPlaceCommand_InvalidDirectionParam_throwInvalidCommandException() {
		assertThrows(InvalidCommandException.class, () -> new PlaceCommand("2,3,SOUTHEAST"));
	}
	
	@Test
	void testPlaceCommand_TooManyParams_throwInvalidCommandException() {
		assertThrows(InvalidCommandException.class, () -> new PlaceCommand("2,3,SOUTHEAST,4"));
	}

	@Test
	void testPlaceCommand_TooFewParams_throwInvalidCommandException() {
		assertThrows(InvalidCommandException.class, () -> new PlaceCommand("2,3"));
	}

}

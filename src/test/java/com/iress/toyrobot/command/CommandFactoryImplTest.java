package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the CommandFactoryImpl class
 */
class CommandFactoryImplTest {

	private CommandFactoryImpl classUnderTest;
	
	@BeforeEach
	void init() {
		classUnderTest = new CommandFactoryImpl();
	}
	
	@Test
	void testGetInstance_nullCommandId_returnNull() throws InvalidCommandException {
		assertNull(classUnderTest.getInstance(null, null));
	}
	
	@Test
	void testGetInstance_UnknownCommandId_returnNull() throws InvalidCommandException {
		assertNull(classUnderTest.getInstance("UNKNOWN", null));
	}

	@Test
	void testGetInstance_PLACECommandWithoutParams_throwException() {
		assertThrows(InvalidCommandException.class, () -> classUnderTest.getInstance("PLACE", null));
	}
	
	@Test
	void testGetInstance_PLACECommandWithValidParams_returnPlaceCommand() throws InvalidCommandException {
		assertTrue(classUnderTest.getInstance("PLACE", "2,3,NORTH") instanceof PlaceCommand);
	}
	
	@Test
	void testGetInstance_MOVECommand_returnMoveCommand() throws InvalidCommandException {
		assertTrue(classUnderTest.getInstance("MOVE", null) instanceof MoveCommand);
	}
	
	@Test
	void testGetInstance_LEFTCommand_returnLeftCommand() throws InvalidCommandException {
		assertTrue(classUnderTest.getInstance("LEFT", null) instanceof LeftCommand);
	}
	
	@Test
	void testGetInstance_RIGHTCommand_returnRightCommand() throws InvalidCommandException {
		assertTrue(classUnderTest.getInstance("RIGHT", null) instanceof RightCommand);
	}
	
	@Test
	void testGetInstance_REPORTCommand_returnReportCommand() throws InvalidCommandException {
		assertTrue(classUnderTest.getInstance("REPORT", null) instanceof ReportCommand);
	}
	
	@Test
	void testGetInstance_EXITCommand_returnExitCommand() throws InvalidCommandException {
		assertTrue(classUnderTest.getInstance("EXIT", null) instanceof ExitCommand);
	}
	
	
}

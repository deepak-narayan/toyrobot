package com.iress.toyrobot.command;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConsoleCommandParserTest {

	private CommandFactory cmdFactory;
	private Command command;
	
	private ConsoleCommandParser classUnderTest;
	
	@BeforeEach
	void init() {
		cmdFactory = Mockito.mock(CommandFactory.class);
		command = Mockito.mock(Command.class);
		classUnderTest = new ConsoleCommandParser(cmdFactory);
	}
	
	@Test
	void testParseCommand_validParameterisedCommand_getValidCommand() throws InvalidCommandException {
		
		Mockito.when(cmdFactory.getInstance("PLACE", "2,3,NORTH")).thenReturn(command);
		
		assertTrue(classUnderTest.parseCommand("PLACE 2,3,NORTH") == command);		
	}

	@Test
	void testParseCommand_validNonParameterisedCommand_getValidCommand() throws InvalidCommandException {
		
		Mockito.when(cmdFactory.getInstance("MOVE", null)).thenReturn(command);
		
		assertTrue(classUnderTest.parseCommand("MOVE") == command);		
	}

	@Test
	void testParseCommand_EmptyCommand_returnNull() throws InvalidCommandException {
		assertNull(classUnderTest.parseCommand(""));		
	}
	
	@Test
	void testParseCommand_NullCommand_returnNull() throws InvalidCommandException {
		assertNull(classUnderTest.parseCommand(null));		
	}
	
	@Test
	void testParseCommand_AllSpacesCommand_returnNull() throws InvalidCommandException {
		assertNull(classUnderTest.parseCommand("   "));		
	}
	
	@Test
	void testParseCommand_ValidCommandWithLeadingAndTrailingSpacesCommand_getValidCommand() throws InvalidCommandException {
		Mockito.when(cmdFactory.getInstance("MOVE", null)).thenReturn(command);
		
		assertTrue(classUnderTest.parseCommand("  MOVE ") == command);				
	}
	
	@Test
	void testParseCommand_InvalidCommandExceptionThrownFromFactory_returnNull() throws InvalidCommandException {
		Mockito.doThrow(InvalidCommandException.class).when(cmdFactory).getInstance(Mockito.any(), Mockito.any());
		
		assertNull(classUnderTest.parseCommand("UNKNOWNCMD"));				
	}
}

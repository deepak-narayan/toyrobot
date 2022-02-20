package com.iress.toyrobot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.iress.toyrobot.command.Command;
import com.iress.toyrobot.command.CommandParser;
import com.iress.toyrobot.command.ConsoleCommandParser;
import com.iress.toyrobot.environment.TwoDimensionalUniverse;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Tests for the Console version of the Toy Robot App
 * @author deepak
 *
 */
class ConsoleToyRobotAppTest {

	private InputStream in;
	private PrintStream out;
	private ConsoleToyRobotAppDependencies deps;

	private TwoDimensionalUniverse universe;
	private TwoDimensionalRobot robot;
	private CommandParser cmdParser;
	
	private ConsoleToyRobotApp classUnderTest;
	
	@BeforeEach
	void init() {
		out = Mockito.mock(PrintStream.class);
		deps = Mockito.mock(ConsoleToyRobotAppDependencies.class);
		
		universe = Mockito.mock(TwoDimensionalUniverse.class);
		robot = Mockito.mock(TwoDimensionalRobot.class);
		cmdParser = Mockito.mock(ConsoleCommandParser.class);
		
		Mockito.when(deps.newSimple2DUniverse(Mockito.anyInt(), Mockito.anyInt())).thenReturn(universe);
		Mockito.when(deps.newSimple2DRobot(universe)).thenReturn(robot);
		Mockito.when(deps.newConsoleCommandParser()).thenReturn(cmdParser);
		
	}
	
	
	@Test
	void testClose_bothInputAndOutputSteamNotNull_BothClosed() throws IOException {
		in = Mockito.mock(InputStream.class);
		classUnderTest = new ConsoleToyRobotApp(in, out, deps);
		classUnderTest.close();
		Mockito.verify(in, Mockito.times(1)).close();
		Mockito.verify(out, Mockito.times(1)).close();
	}

	@Test
	void testClose_bothInputAndOutputSteamNull_NoneClosed() throws IOException {
		in = Mockito.mock(InputStream.class);
		classUnderTest = new ConsoleToyRobotApp(null, null, deps);
		classUnderTest.close();
		Mockito.verify(in, Mockito.times(0)).close();
		Mockito.verify(out, Mockito.times(0)).close();
	}
	
	@Test
	void testRunApp_InvalidCommand_PrintErrorToOutput() {
		in = new ByteArrayInputStream("UnknownCmd\nEXIT\n".getBytes());
		Mockito.when(cmdParser.parseCommand("UnknownCmd")).thenReturn(null);
		Mockito.when(cmdParser.parseCommand("EXIT")).thenReturn(Mockito.mock(Command.class));
		
		classUnderTest = new ConsoleToyRobotApp(in, out, deps);
		classUnderTest.runApp();
		
		// Use contains because other things may have been output
		Mockito.verify(out, Mockito.times(1)).println(ArgumentMatchers.contains("Invalid"));
	}
	
	@Test
	void testRunApp_ValidCommandProducingOutput_PrintToOutput() {
		in = new ByteArrayInputStream("VALIDCMD\nEXIT\n".getBytes());
		Command validCmd = Mockito.mock(Command.class);
		Mockito.when(validCmd.getOutput()).thenReturn("TestOutput");
		Mockito.when(cmdParser.parseCommand("VALIDCMD")).thenReturn(validCmd);
		Mockito.when(cmdParser.parseCommand("EXIT")).thenReturn(Mockito.mock(Command.class));
		
		classUnderTest = new ConsoleToyRobotApp(in, out, deps);
		classUnderTest.runApp();
		
		Mockito.verify(out, Mockito.times(1)).println(ArgumentMatchers.eq("TestOutput"));
	}
	
	@Test
	void testRunApp_ValidCommandProducingEmptyOutput_NoPrintToOutput() {
		in = new ByteArrayInputStream("VALIDCMD\nEXIT\n".getBytes());
		Command validCmd = Mockito.mock(Command.class);
		Mockito.when(validCmd.getOutput()).thenReturn("");
		Mockito.when(cmdParser.parseCommand("VALIDCMD")).thenReturn(validCmd);
		Mockito.when(cmdParser.parseCommand("EXIT")).thenReturn(Mockito.mock(Command.class));
		
		classUnderTest = new ConsoleToyRobotApp(in, out, deps);
		classUnderTest.runApp();
		
		Mockito.verify(out, Mockito.times(0)).println(ArgumentMatchers.eq(""));
	}
}

package com.iress.toyrobot;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.iress.toyrobot.command.Command;
import com.iress.toyrobot.command.CommandParser;
import com.iress.toyrobot.environment.TwoDimensionalUniverse;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Toy Robot app accepting running off the console
 */
public class ConsoleToyRobotApp implements ToyRobotApp, AutoCloseable {

	private InputStream inputStream;
	private PrintStream outputStream;
	private ConsoleToyRobotAppDependencies deps;
	
	/**
	 * Instantiate a console Toy Robot App
	 * @param inputStream - Steam supplying command inputs
	 * @param outputStream - Stream to which outputs (if any) are written
	 * @param deps - A mechanism for injecting dependencies
	 */
	public ConsoleToyRobotApp(InputStream inputStream, PrintStream outputStream, ConsoleToyRobotAppDependencies deps) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.deps = deps;
	}
	
	@Override
	public void runApp() {
		TwoDimensionalUniverse universe = deps.newSimple2DUniverse(5, 5);
		TwoDimensionalRobot robot = deps.newSimple2DRobot(universe);

		outputStream.println("The Universe has been created! Introduce the Robot into it using the PLACE command\n");
		
		try (Scanner in = new Scanner(inputStream).useDelimiter("\n")) {
			// Keep accepting commands till EXIT
			String cmdStr = null;
			CommandParser cmdParser = deps.newConsoleCommandParser();
			while (!"EXIT".equals(cmdStr)) {

				cmdStr = in.next().trim().toUpperCase();

				Command cmd = cmdParser.parseCommand(cmdStr);
				if (cmd == null) {
					outputStream.println("\n\nInvalid Command '" + cmdStr + "'");
				} else {
					cmd.executeCommand(robot);

					String output = cmd.getOutput();
					if (output != null && output.trim().length() > 0) {
						outputStream.println(output);
					}
				}
			}
		}
	}

	@Override
	public void close() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
		
		if (outputStream != null) {
			outputStream.close();
		}
		
	}

}

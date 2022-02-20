package com.iress.toyrobot;

import com.iress.toyrobot.command.CommandParser;
import com.iress.toyrobot.command.ConsoleCommandParser;
import com.iress.toyrobot.environment.Simple2DUniverse;
import com.iress.toyrobot.environment.TwoDimensionalUniverse;
import com.iress.toyrobot.inhabitant.Simple2DRobot;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

public class ConsoleToyRobotAppDependencies {
	
	/**
	 * Get an instance of Simple2DUniverse of the specified width and height
	 */
	public TwoDimensionalUniverse newSimple2DUniverse(int width, int height) {
		return new Simple2DUniverse(width, height);
	}
	
	/**
	 * Get an instance of Simple2DRobot for the input universe
	 */
	public TwoDimensionalRobot newSimple2DRobot(TwoDimensionalUniverse universe) {
		return new Simple2DRobot(universe);
	}

	/**
	 * Get an instance of the Console Command Parser
	 * @return
	 */
	public CommandParser newConsoleCommandParser() {
		return new ConsoleCommandParser();
	}
}

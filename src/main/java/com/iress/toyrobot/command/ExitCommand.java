package com.iress.toyrobot.command;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Exit command
 */
public class ExitCommand implements Command {

	@Override
	public boolean executeCommand(TwoDimensionalRobot robot) {
		// Nothing else to do, but may perform cleanup etc if needed
		return true;
	}
}

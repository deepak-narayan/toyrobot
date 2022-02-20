package com.iress.toyrobot.command;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Command for turning a robot right
 */
public class RightCommand implements Command {

	@Override
	public boolean executeCommand(TwoDimensionalRobot robot) {
		return robot.turnRight();
	}
}

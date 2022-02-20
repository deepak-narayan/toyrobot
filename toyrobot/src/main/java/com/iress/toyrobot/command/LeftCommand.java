package com.iress.toyrobot.command;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Command to turn the robot left
 */
public class LeftCommand implements Command {

	@Override
	public boolean executeCommand(TwoDimensionalRobot robot) {
		return robot.turnLeft();
	}
}

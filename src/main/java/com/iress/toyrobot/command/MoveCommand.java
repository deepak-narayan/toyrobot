package com.iress.toyrobot.command;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Command for moving a robot
 */
public class MoveCommand implements Command {

	@Override
	public boolean executeCommand(TwoDimensionalRobot robot) {
		return robot.moveForward();
	}
}

package com.iress.toyrobot.command;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Interface for executing commands on a Robot
 */
public interface Command {

	/**
	 * Execute the command on the input robot.
	 * @param robot - The robot which will execute the command
	 * @return true if the command was successful
	 */
	public boolean executeCommand(TwoDimensionalRobot robot);
	
	/**
	 * Get the output of the command.
	 * @return Empty String by default. Implementations may override and return something meaningful
	 */
	public default String getOutput() {
		return "";
	}
}

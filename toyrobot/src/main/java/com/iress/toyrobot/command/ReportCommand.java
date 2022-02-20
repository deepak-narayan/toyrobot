package com.iress.toyrobot.command;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobotState;

/**
 * Command which reports the state of the Robot
 */
public class ReportCommand implements Command {

	private String output;
	
	@Override
	public boolean executeCommand(TwoDimensionalRobot robot) {
		try {
			TwoDimensionalRobotState state =  robot.getState();
			
			// Build output in the format Output: 0,1,NORTH
			StringBuilder builder = new StringBuilder("Output: ");
			builder.append(state.getXCoordinate()).append(',');
			builder.append(state.getYCoordinate()).append(',');
			builder.append(state.getDirection().name());

			output = builder.toString();
			return true;
			
		} catch (IllegalStateException e) {
			output = "Robot has not been placed";
			return false;
		}
	}
	
	@Override
	public String getOutput() {
		return this.output;
	}
}

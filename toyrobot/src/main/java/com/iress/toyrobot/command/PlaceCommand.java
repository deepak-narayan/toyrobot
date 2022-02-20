package com.iress.toyrobot.command;

import com.iress.toyrobot.environment.Direction;
import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * Command for placing a robot in the universe
 */
public class PlaceCommand implements Command {

	private int x;
	private int y;
	private Direction direction;
	
	public PlaceCommand(String commandParamsCsv) throws InvalidCommandException {
		parseCommandParams(commandParamsCsv);
	}

	@Override
	public boolean executeCommand(TwoDimensionalRobot robot) {
		return robot.teleport(x, y, direction);
	}
	
	/**
	 * Parse the command and populate class members. It must be in the format x,y,direction. For example 2,3,NORTH
	 * @param commandParamsCsv - A CSV string in the format x,y,direction
	 * @throws InvalidCommandException If commandParamsCsv is not in the requisite format
	 */
	private void parseCommandParams(String commandParamsCsv) throws InvalidCommandException {
		if (commandParamsCsv == null) {
			throw new InvalidCommandException("No parameters found");
		}
		
		String[] params = commandParamsCsv.split(",");
		if (params.length != 3) {
			throw new InvalidCommandException("Incorrect number of parameters " + commandParamsCsv);
		}
		
		try {
			x = Integer.parseInt(params[0].trim());
			y = Integer.parseInt(params[1].trim());
			direction = Direction.valueOf(params[2].trim());
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandException("Invalid parameter found " + commandParamsCsv);
		}
	}
}

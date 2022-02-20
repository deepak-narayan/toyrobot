package com.iress.toyrobot.inhabitant;

import com.iress.toyrobot.environment.Direction;

/**
 * An interface for accessing the state of a TwoDimensionalRobot
 */
public interface TwoDimensionalRobotState {
	
	/**
	 * Get the current X Coordinate
	 */
	public int getXCoordinate();	

	/**
	 * Get the current Y Coordinate
	 */
	public int getYCoordinate();

	/**
	 * Get the direction in which the robot is facing
	 */
	public Direction getDirection();
	
}

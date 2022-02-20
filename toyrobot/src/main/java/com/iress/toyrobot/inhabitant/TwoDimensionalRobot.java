package com.iress.toyrobot.inhabitant;

import com.iress.toyrobot.environment.Direction;
import com.iress.toyrobot.environment.TwoDimensionalUniverse;

/**
 * An interface representing a Two Dimensional Robot.
 */
public interface TwoDimensionalRobot {
	
	/**
	 * The robot is aware of its universe. 
	 * @return The 2D universe the robot lives in
	 */
	public TwoDimensionalUniverse getUniverse();
	
	/**
	 * Move one step forward in the direction the robot is facing.
	 * @return true if successful
	 */
	public boolean moveForward();
	
	/**
	 * Turn 90 degrees left.
	 * @return true if successful  
	 */
	public boolean turnLeft();
	
	/**
	 * Turn 90 degrees right.  
	 * @return true if successful
	 */
	public boolean turnRight();
	
	/**
 	 * Teleport to a location in the universe
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 * @param direction - Orientation
	 * @return true if successful
	 */
	boolean teleport(int x, int y, Direction direction);
	
	/**
	 * Get Current State of the robot
	 */
	public TwoDimensionalRobotState getState();

}

package com.iress.toyrobot.inhabitant;

import com.iress.toyrobot.environment.Direction;

/**
 * Simple bean for maintaining state of a 2D robot
 */
public class Simple2DRobotState implements TwoDimensionalRobotState {

	private int x;
	private int y;
	private Direction direction;
	
	@Override
	public int getXCoordinate() {
		return x;
	}

	@Override
	public int getYCoordinate() {
		return y;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Set the X coordinate
	 */
	public void setXCoordinate(int x) {
		this.x = x;
	}

	/**
	 * Set the Y coordinate
	 */
	public void setYCoordinate(int y) {
		this.y = y;
	}

	/**
	 * Set the Direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
}

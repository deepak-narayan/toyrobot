package com.iress.toyrobot.environment;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

public interface TwoDimensionalUniverse {

	/**
	 * Get the width of the universe
	 */
	int getWidth();

	/**
	 * Get the height of the universe
	 */
	int getHeight();

	/**
	 * Get the X coordinate of the origin
	 */
	int getOriginX();

	/**
	 * Get the Y coordinate of the origin
	 */
	int getOriginY();

	/**
	 * Are the given coordinates within the bounds of the universe?
	 * @param x - X Coordinate
	 * @param y - Y Coordinate
	 * @return true if within bounds, otherwise false
	 */
	boolean isOutsideBounds(int x, int y);

	/**
	 * Place a robot at a specific location
	 * @param robot - The TwoDimensionalRobot to be placed
	 * @param x - X Coordinate
	 * @param y - Y Coordinate
	 * @throws PlacementException - If the TwoDimensionalRobot could not be placed.
	 */
	void placeRobot(TwoDimensionalRobot robot, int x, int y) throws PlacementException;

}
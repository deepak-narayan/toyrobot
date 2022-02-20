package com.iress.toyrobot.environment;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

/**
 * 2D planar universe
 */
public class Simple2DUniverse implements TwoDimensionalUniverse {

	private int width;
	private int height;
		
	private int originX;
	private int originY;
	
	/**
	 * Instantiate the universe with a specific width and height
	 */
	public Simple2DUniverse(int width, int height) {
		this.width = width;
		this.height = height;
		this.originX = 0;
		this.originY = 0;
	}

	/**
	 * Get the width of the universe
	 */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * Get the height of the universe
	 */
	@Override
	public int getHeight() {
		return this.height;
	}

	/**
	 * Get the X coordinate of the origin
	 */
	@Override
	public int getOriginX() {
		return originX;
	}

	/**
	 * Get the Y coordinate of the origin
	 */
	@Override
	public int getOriginY() {
		return originY;
	}
	
	/**
	 * Are the given coordinates within the bounds of the universe?
	 * @param x - X Coordinate
	 * @param y - Y Coordinate
	 * @return true if within bounds, otherwise false
	 */
	@Override
	public boolean isOutsideBounds(int x, int y) {
		return x > getWidth() || y > getHeight() || x < getOriginX() || y < getOriginY();
	}
	
	/**
	 * Place a robot at a specific location
	 * @param robot - The TwoDimensionalRobot to be placed
	 * @param x - X Coordinate
	 * @param y - Y Coordinate
	 * @throws PlacementException - If the TwoDimensionalRobot could not be placed.
	 */
	@Override
	public void placeRobot(TwoDimensionalRobot robot, int x, int y) throws PlacementException {
		if (isOutsideBounds(x, y)) {
			throw new PlacementException("Outside of bounds - " + x + " " + y);
		}
	}
}

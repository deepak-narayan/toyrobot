package com.iress.toyrobot.inhabitant;

import com.iress.toyrobot.environment.Direction;
import com.iress.toyrobot.environment.PlacementException;
import com.iress.toyrobot.environment.TwoDimensionalUniverse;

/**
 * A simple robot which can live in a 2D plane
 */
public class Simple2DRobot implements TwoDimensionalRobot {

	private TwoDimensionalUniverse universe;
	private Simple2DRobotState state;

	/**
	 * Instantiate a robot
	 * @param universe Pass in the universe in which it lives
	 */
	public Simple2DRobot(TwoDimensionalUniverse universe) {
		this.universe = universe;
		this.state = new Simple2DRobotState();
	}

	@Override
	public TwoDimensionalUniverse getUniverse() {
		return this.universe;
	}

	@Override
	public boolean moveForward() {
		boolean result = false;
		Direction dir = this.state.getDirection();
		if (dir != null) {
			int xCoord = this.state.getXCoordinate();
			int yCoord = this.state.getYCoordinate();
			boolean shouldMove = true;
			switch (dir) {
				case NORTH:
					++yCoord;
					break;
	
				case SOUTH:
					--yCoord;
					break;

				case WEST:
					--xCoord;
					break;
				
				case EAST: 
					++xCoord;
					break;
				
				default:
					// Unknown direction
					shouldMove = false;
			}
			
			if (shouldMove) {
				// Reuse this as teleportation takes care of bounds as well
				result = this.teleport(xCoord, yCoord, dir);
			} else {
				result = false;
			}
		}

		return result;
	}

	@Override
	public boolean turnLeft() {
		boolean result = false;
		Direction currentDir = this.state.getDirection();
		if (currentDir != null) {
			this.state.setDirection(currentDir.getPrevious());
			result = true;
		}

		return result;
	}

	@Override
	public boolean turnRight() {
		boolean result = false;
		Direction currentDir = this.state.getDirection();
		if (currentDir != null) {
			this.state.setDirection(currentDir.getNext());
			result = true;
		}

		return result;
	}

	@Override
	public boolean teleport(int x, int y, Direction direction) {
		boolean result = false;

		try {
			// The universe determines if the robot can exist at the coordinates
			// If it can't, we get an exception.
			this.universe.placeRobot(this, x, y);
			
			this.state.setDirection(direction);
			this.state.setXCoordinate(x);
			this.state.setYCoordinate(y);
			result = true;

		} catch (PlacementException e) {
			// Whoopsie, robot cannot exist at those coordinates.
			result = false;
		}

		return result;
	}

	/**
	 * Get the state of the robot.
	 * 
	 * @throws IllegalStateException if the robot has not been placed.
	 */
	@Override
	public TwoDimensionalRobotState getState() {
		if (this.state.getDirection() == null) {
			throw new IllegalStateException("Robot has not been placed");
		}

		return this.state;
	}

}

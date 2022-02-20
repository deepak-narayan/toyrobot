package com.iress.toyrobot.environment;

/**
 * Available directions of motion
 */
public enum Direction {
	
	// These directions must be in sequence
	WEST,  // 0 degrees
	NORTH, // 90degrees
	EAST,  // 180 degrees
	SOUTH  // 270 degrees
	;
	
	/**
	 * Get the previous direction in the sequence.
	 * If we're at the beginning of the sequence this returns the last one.
	 */
	public Direction getPrevious() {
		Direction[] values = Direction.values();
		int idx = this.ordinal();
		if (idx == 0) {
			idx = values.length - 1;
		} else {
			idx--;
		}
		
		return values[idx];
	}

	/**
	 * Get the next direction in the sequence.
	 * If we're at the end of the sequence this returns the first one. 
	 */
	public Direction getNext() {
		Direction[] values = Direction.values();
		int idx = this.ordinal();
		if (idx == values.length - 1) {
			idx = 0;
		} else {
			idx++;
		}
		
		return values[idx];
	}
	
}

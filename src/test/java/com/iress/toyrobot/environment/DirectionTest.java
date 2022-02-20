package com.iress.toyrobot.environment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for the Direction Enum
 */
class DirectionTest {

	@Test
	void testNext_West_ReturnNorth() {
		assertTrue(Direction.WEST.getNext() == Direction.NORTH);
	}
	
	@Test
	void testNext_North_ReturnEast() {
		assertTrue(Direction.NORTH.getNext() == Direction.EAST);
	}
	
	@Test
	void testNext_East_ReturnSouth() {
		assertTrue(Direction.EAST.getNext() == Direction.SOUTH);
	}
	
	@Test
	void testNext_South_ReturnWest() {
		assertTrue(Direction.SOUTH.getNext() == Direction.WEST);
	}

	@Test
	void testPrevious_West_ReturnSouth() {
		assertTrue(Direction.WEST.getPrevious() == Direction.SOUTH);
	}

	@Test
	void testPrevious_South_ReturnEast() {
		assertTrue(Direction.SOUTH.getPrevious() == Direction.EAST);
	}

	@Test
	void testPrevious_East_ReturnNorth() {
		assertTrue(Direction.EAST.getPrevious() == Direction.NORTH);
	}
	
	@Test
	void testPrevious_North_ReturnWest() {
		assertTrue(Direction.NORTH.getPrevious() == Direction.WEST);
	}
	

	

}

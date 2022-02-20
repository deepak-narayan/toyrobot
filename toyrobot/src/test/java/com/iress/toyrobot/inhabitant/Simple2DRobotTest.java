package com.iress.toyrobot.inhabitant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.environment.Direction;
import com.iress.toyrobot.environment.PlacementException;
import com.iress.toyrobot.environment.TwoDimensionalUniverse;

/**
 * Tests for the SimpleRobot implementation
 */
class Simple2DRobotTest {

	private Simple2DRobot classUnderTest;
	
	private TwoDimensionalUniverse universe;
	
	@BeforeEach
	void beforeEach() throws Exception {
		universe = Mockito.mock(TwoDimensionalUniverse.class);
		Mockito.when(universe.getHeight()).thenReturn(5);
		Mockito.when(universe.getWidth()).thenReturn(5);
		Mockito.when(universe.getOriginX()).thenReturn(5);
		
		classUnderTest = new Simple2DRobot(universe);
	}

	@Test
	void testGetUniverser_returnUniverse() {
		assertTrue(classUnderTest.getUniverse() == universe);
	}
	
	@Test
	void testTurnLeft_NotPlaced_returnFalse() {
		assertFalse(classUnderTest.turnLeft());
	}

	@Test
	void testTurnRight_NotPlaced_returnFalse() {
		assertFalse(classUnderTest.turnRight());
	}

	@Test
	void testTurnLeft_PlacedFacingNorth_FaceWestreturnTrue() {
		classUnderTest.teleport(2, 3, Direction.NORTH);
		assertTrue(classUnderTest.turnLeft());
		assertTrue(classUnderTest.getState().getDirection() == Direction.WEST);
	}
	
	@Test
	void testTurnLeft_PlacedFacingNorth_FaceEastreturnTrue() {
		classUnderTest.teleport(2, 3, Direction.NORTH);
		assertTrue(classUnderTest.turnRight());
		assertTrue(classUnderTest.getState().getDirection() == Direction.EAST);
	}
	
	@Test
	void testTeleport_PlacedWithinUniverseBoundsFacingNorth_ReturnTrue() {
		assertTrue(classUnderTest.teleport(2, 3, Direction.NORTH));
		TwoDimensionalRobotState state = classUnderTest.getState();
		assertTrue(state.getDirection() == Direction.NORTH);
		assertTrue(state.getXCoordinate() == 2);
		assertTrue(state.getYCoordinate() == 3);
	}
	
	@Test
	void testTeleport_PlacedOutsideUniverseBoundsFacingNorth_ReturnFalse() throws PlacementException {
		Mockito.doThrow(PlacementException.class).when(universe).placeRobot(Mockito.any(), Mockito.anyInt(), Mockito.anyInt());
		assertFalse(classUnderTest.teleport(2, 10, Direction.NORTH));
	}
	
	@Test
	void testGetState_NotPlaced_ThrowIllegalStateException() {
		assertThrows(IllegalStateException.class, () -> {
			classUnderTest.getState();
		});
	}
	
	@Test
	void testMoveForward_NotPlaced_ReturnFalse() {
		assertFalse(classUnderTest.moveForward());
	}
	
	@Test
	void testMoveForward_PlacedAt2x3FacingSouth_ReturnTrueReduceY() {
		classUnderTest.teleport(2, 3, Direction.SOUTH);
		
		assertTrue(classUnderTest.moveForward());
		
		TwoDimensionalRobotState state = classUnderTest.getState();
		assertTrue(state.getDirection() == Direction.SOUTH);
		assertTrue(state.getXCoordinate() == 2);
		assertTrue(state.getYCoordinate() == 2);
	}
	
	@Test
	void testMoveForward_PlacedAt2x3FacingNorth_ReturnTrueIncreaseY() {
		classUnderTest.teleport(2, 3, Direction.NORTH);
		
		assertTrue(classUnderTest.moveForward());
		
		TwoDimensionalRobotState state = classUnderTest.getState();
		assertTrue(state.getDirection() == Direction.NORTH);
		assertTrue(state.getXCoordinate() == 2);
		assertTrue(state.getYCoordinate() == 4);
	}
	
	@Test
	void testMoveForward_PlacedAt2x3FacingWest_ReturnTrueReduceX() {
		classUnderTest.teleport(2, 3, Direction.WEST);
		
		assertTrue(classUnderTest.moveForward());
		
		TwoDimensionalRobotState state = classUnderTest.getState();
		assertTrue(state.getDirection() == Direction.WEST);
		assertTrue(state.getXCoordinate() == 1);
		assertTrue(state.getYCoordinate() == 3);
	}
	
	@Test
	void testMoveForward_PlacedAt2x3FacingEast_ReturnTrueIncreaseX() {
		classUnderTest.teleport(2, 3, Direction.EAST);
		
		assertTrue(classUnderTest.moveForward());
		
		TwoDimensionalRobotState state = classUnderTest.getState();
		assertTrue(state.getDirection() == Direction.EAST);
		assertTrue(state.getXCoordinate() == 3);
		assertTrue(state.getYCoordinate() == 3);
	}
	
	@Test
	void testTeleport_MoveOutsideUniverseBoundsFacingNorth_ReturnFalse() throws PlacementException {
		classUnderTest.teleport(2, 3, Direction.EAST);
		Mockito.doThrow(PlacementException.class).when(universe).placeRobot(Mockito.any(), Mockito.anyInt(), Mockito.anyInt());
		assertFalse(classUnderTest.moveForward());
	}
}

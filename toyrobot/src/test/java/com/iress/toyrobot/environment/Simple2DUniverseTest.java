package com.iress.toyrobot.environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iress.toyrobot.inhabitant.TwoDimensionalRobot;

class Simple2DUniverseTest {

	private Simple2DUniverse classUnderTest; 
	
	@BeforeEach
	void beforeEach() throws Exception {
		classUnderTest = new Simple2DUniverse(3, 4);
	}

	@Test
	void testGetOriginX_0_Returns0() {
		assertTrue(classUnderTest.getOriginX() == 0);
	}
	
	@Test
	void testGetOriginY_0_ReturnsY() {
		assertTrue(classUnderTest.getOriginY() == 0);
	}
	
	@Test
	void testGetWidth_Width3_getWidthReturns3() {
		assertTrue(classUnderTest.getWidth() == 3);
	}

	@Test
	void testGetHeight_Height4_getHeightReturns4() {
		assertTrue(classUnderTest.getHeight() == 4);
	}
	
	@Test
	void testIsOutsideBounds_3x4Universe_Width3Height5_true() {
		assertTrue(classUnderTest.isOutsideBounds(3, 5));
	}
	
	@Test
	void testIsOutsideBounds_3x4Universe_WidthMinus3Height5_true() {
		assertTrue(classUnderTest.isOutsideBounds(-3, 5));
	}
	
	@Test
	void testIsOutsideBounds_3x4Universe_Width4Height1_true() {
		assertTrue(classUnderTest.isOutsideBounds(4, 1));
	}
	
	@Test
	void testIsOutsideBounds_3x4Universe_WidthMinus4Height1_true() {
		assertTrue(classUnderTest.isOutsideBounds(-4, 1));
	}
	
	@Test
	void testIsOutsideBounds_3x4Universe_Width2Height3_false() {
		assertFalse(classUnderTest.isOutsideBounds(2, 3));
	}
	
	@Test
	void testPlaceInhabitant_3x4UniversePlaceInhabitantAt3x3_noException() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Assertions.assertDoesNotThrow(() -> classUnderTest.placeRobot(robot, 3, 3));
	}
	
	@Test
	void testPlaceInhabitant_3x4UniversePlaceInhabitantAt3x10_exception() {
		TwoDimensionalRobot robot = Mockito.mock(TwoDimensionalRobot.class);
		Assertions.assertThrows(PlacementException.class, () -> classUnderTest.placeRobot(robot, 3, 10));
	}
}

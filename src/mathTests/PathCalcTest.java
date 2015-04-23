package mathTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import mathGame.Missile;
import org.junit.Before;
import org.junit.Test;

public class PathCalcTest {
	Missile testMissile;
	@Before
	public void setUp() throws Exception {
		testMissile = new Missile(100, 500, "Arrow");
		testMissile.setScreenX(800);
		testMissile.setScreenY(600);
		testMissile.setGravity(10);
	}

	//test a path calculation at 10 degrees using an initial velocity of 100
	@Test
	public void testCalc10() {
		ArrayList<Point> pointList = testMissile.calcPath(10, 100);
		//Assert that the list of points contains the launch point
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
		//Assert that the point at t = 1 second exists
		assertTrue(pointList.contains(new Point(198, 487)));
		//Assert that the point at t = 2 seconds exists
		assertTrue(pointList.contains(new Point(296, 485)));
		//Assert that the point at t = 3 seconds exists
		assertTrue(pointList.contains(new Point(395, 492)));
		//Assert that the point at t = 4 seconds exists
		assertTrue(pointList.contains(new Point(493, 510)));
		//Assert that the point at t = 5 seconds exists
		assertTrue(pointList.contains(new Point(592, 538)));

	}

	//test a path calculation at 30 degrees using an initial velocity of 100
	@Test
	public void testCalc30(){
		ArrayList<Point> pointList = testMissile.calcPath(30, 100);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
		//Assert that the point at t = 1 second exists
		assertTrue(pointList.contains(new Point(186, 455)));
		//Assert that the point at t = 1.5 seconds exists
		assertTrue(pointList.contains(new Point(229, 436)));
		//Assert that the point at t = 2 seconds exists
		assertTrue(pointList.contains(new Point(273, 420)));
		//Assert that the point at t = 2.5 seconds exists
		assertTrue(pointList.contains(new Point(316, 406)));
		//Assert that the point at t = 3 seconds exists
		assertTrue(pointList.contains(new Point(359, 395)));
	}

	//test a path calculation at 45 degrees using an initial velocity of 100
	@Test
	public void testCalc45(){
		ArrayList<Point> pointList = testMissile.calcPath(45, 100);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
		//Assert that the point at t = 1 second exists
		assertTrue(pointList.contains(new Point(170, 434)));
		//Assert that the point at t = 1.1 seconds exists
		assertTrue(pointList.contains(new Point(177, 428)));
		//Assert that the point at t = 1.2 seconds exists
		assertTrue(pointList.contains(new Point(184, 422)));
		//Assert that the point at t = 1.3 seconds exists
		assertTrue(pointList.contains(new Point(191, 416)));
		//Assert that the point at t = 1.4 seconds exists
		assertTrue(pointList.contains(new Point(198, 410)));
	}

	//test a path calculation at 90 degrees using an initial velocity of 100
	@Test
	public void testCalc90(){
		ArrayList<Point> pointList = testMissile.calcPath(90, 100);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
		//Assert that the point at t = 1 second exists
		assertTrue(pointList.contains(new Point(100, 405)));
		//Assert that the point at t = 2 seconds exists
		assertTrue(pointList.contains(new Point(100, 319))); //This answer should be 320 but due to rounding the computer has it as 319
		//Assert that the point at t = 3 seconds exists
		assertTrue(pointList.contains(new Point(100, 244))); //This answer should be 245 but due to rounding the computer has it as 244
		//Assert that the point at t = 4 seconds exists
		assertTrue(pointList.contains(new Point(100, 179))); //This answer should be 180 but due to rounding the computer has it as 179
		//Assert that the point at t = 5 seconds exists
		assertTrue(pointList.contains(new Point(100, 125)));
	}	


}

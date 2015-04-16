package mathTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import mathGame.ControlPanel;
import mathGame.Missile;
import mathGame.Question;

import org.junit.Before;
import org.junit.Test;

public class PathCalcTest {
	Missile testMissile;
	@Before
	public void setUp() throws Exception {
		testMissile = new Missile(100, 500);
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
		assertTrue(pointList.contains(new Point(455, 186)));
		//Assert that the point at t = 1.5 seconds exists
		assertTrue(pointList.contains(new Point(436, 229)));
		//Assert that the point at t = 2 seconds exists
		assertTrue(pointList.contains(new Point(420, 273)));
		//Assert that the point at t = 2.5 seconds exists
		assertTrue(pointList.contains(new Point(406, 316)));
		//Assert that the point at t = 3 seconds exists
		assertTrue(pointList.contains(new Point(395, 359)));
	}

	//test a path calculation at 45 degrees using an initial velocity of 100
	@Test
	public void testCalc45(){
		ArrayList<Point> pointList = testMissile.calcPath(45, 100);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
		//Assert that the point at t = 1 second exists
		assertTrue(pointList.contains(new Point(434, 170)));
		//Assert that the point at t = 1.1 seconds exists
		assertTrue(pointList.contains(new Point(428, 177)));
		//Assert that the point at t = 1.2 seconds exists
		assertTrue(pointList.contains(new Point(422, 184)));
		//Assert that the point at t = 1.3 seconds exists
		assertTrue(pointList.contains(new Point(416, 191)));
		//Assert that the point at t = 1.4 seconds exists
		assertTrue(pointList.contains(new Point(410, 198)));
	}

	//test a path calculation at 90 degrees using an initial velocity of 100
	@Test
	public void testCalc90(){
		ArrayList<Point> pointList = testMissile.calcPath(90, 100);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
		//Assert that the point at t = 1 second exists
		assertTrue(pointList.contains(new Point(405, 100)));
		//Assert that the point at t = 2 seconds exists
		assertTrue(pointList.contains(new Point(320, 100)));
		//Assert that the point at t = 3 seconds exists
		assertTrue(pointList.contains(new Point(245, 100)));
		//Assert that the point at t = 4 seconds exists
		assertTrue(pointList.contains(new Point(180, 100)));
		//Assert that the point at t = 5 seconds exists
		assertTrue(pointList.contains(new Point(125, 100)));
	}	


}

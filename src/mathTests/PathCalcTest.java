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

	//test a path calculation at 10 degrees using an initial velocity of 10
	@Test
	public void testCalc10() {
		ArrayList<Point> pointList = testMissile.calcPath(10, 10);
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

	//test a path calculation at 30 degrees using an initial velocity of 10
	@Test
	public void testCalc30(){
		ArrayList<Point> pointList = testMissile.calcPath(30, 10);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
	}

	//test a path calculation at 45 degrees using an initial velocity of 10
	@Test
	public void testCalc45(){
		ArrayList<Point> pointList = testMissile.calcPath(45, 10);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
	}

	//test a path calculation at 90 degrees using an initial velocity of 10
	@Test
	public void testCalc90(){
		ArrayList<Point> pointList = testMissile.calcPath(90, 10);
		assertTrue(pointList.contains(new Point(testMissile.getX(), testMissile.getY())));
	}	


}

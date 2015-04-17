package mathTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import mathGame.BadConfigFormatException;
import mathGame.MathAngleAndFunTimesGUI;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConfigFileTests {
	private static MathAngleAndFunTimesGUI game;
	private static final double GRAVITY = 10.0;
	
	@BeforeClass
	public static void init(){
		game = new MathAngleAndFunTimesGUI("launchConfig.txt");
	}
	
	@Test (expected = BadConfigFormatException.class)
	public void testConfigFormatException(){
		//Assure that bad config errors are thrown when appropriate
		game = new MathAngleAndFunTimesGUI("badConfig.txt");
		game.loadConfigFiles();
	}
	
	@Test
	public void testMissileTypes() {
		//Assure that the correct missile name strings were loaded
		ArrayList<String> name = game.getMissileTypes();
		assertTrue(name.contains("Axe"));
		assertTrue(name.contains("Magic Bolt"));
	}
	
	@Test
	public void testGravity(){
		//Assure that the gravitational constant for our game was loaded correctly
		double grav = game.getGravity();
		assertEquals(grav, GRAVITY, .01);
	}
	
	@Test
	public void testStartingLocations(){
		//Assure that the various information regarding the placement of objects on screen is correctly loaded
		Point ps = game.getPersonStart();
		Point ms = game.getMissileStart();
		assertEquals(ps, new Point(50, 500));
		assertEquals(ms, new Point(100, 500));
	}
}

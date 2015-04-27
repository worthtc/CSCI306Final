package mathTests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import mathGame.BadConfigFormatException;
import mathGame.MathAngleAndFunTimesGUI;
import mathGame.Question;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConfigFileTests {
	private static MathAngleAndFunTimesGUI game;
	private static final double GRAVITY = 10.0;
	
	@BeforeClass
	public static void init(){
		game = new MathAngleAndFunTimesGUI("/data/launchConfig.txt");
	}
	
	@Test (expected = BadConfigFormatException.class)
	public void testConfigFormatException() throws BadConfigFormatException{
		//Assure that bad configuration errors are thrown when appropriate
		MathAngleAndFunTimesGUI game2 = new MathAngleAndFunTimesGUI();
		game2.MAAFTGUITestConstructor("/data/badConfig.txt");
		
	}
	
	@Test
	public void testMissileTypes() {
		//Assure that the correct missile name strings were loaded
		ArrayList<String> name = game.getMissileTypes();
		assertTrue(name.contains("Axe"));
		assertTrue(name.contains("Lightning Bolt"));
	}
	
	@Test
	public void testGravity(){
		//Assure that the gravitational constant for our game was loaded correctly
		double grav = game.getGravity();
		assertEquals(GRAVITY, grav, .01);
	}
	
	@Test
	public void testStartingLocations(){
		//Assure that the various information regarding the placement of objects on screen is correctly loaded
		Point ps = game.getPersonStart();
		Point ms = game.getMissileStart();
		assertEquals(ps, new Point(50, 500));
		assertEquals(ms, new Point(100, 500));
	}
	
	@Test
	public void testQuestionList(){
		Question q1 = new Question("Which trigonometric function can equal or be greater than 1.000?", "Tangent" );
		Question q2 = new Question("If Sin angle A = 0.358, then does angle A = 21°? True or False", "True" );
		boolean check1 = false;
		boolean check2 = false;
		ArrayList<Question> temp = game.getControlGUI().getPossibleQuestions();
		for(Question q : temp){
			if(q.getQuestionText().equals(q1.getQuestionText()) && q.getAnswerText().equals(q1.getAnswerText())){
				check1 = true;
			}
			else if(q.getQuestionText().equals(q2.getQuestionText()) && q.getAnswerText().equals(q2.getAnswerText())){
				check2 = true;
			}
		}
		assertTrue(check1);
		assertTrue(check2);
	}
}

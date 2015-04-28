package mathTests;

import static org.junit.Assert.*;
import mathGame.ControlPanel;
import mathGame.Question;

import org.junit.Before;
import org.junit.Test;

public class QuestionTests {
	private Question q1;
	private Question q2;
	private ControlPanel questionAsker;
	@Before
	public void setUp() throws Exception {
		q1 = new Question( "This is a test Question", "This is the answer", questionAsker);
		q2 = new Question( "This is another test Question", "answer", questionAsker);
		questionAsker = new ControlPanel();
		questionAsker.addQuestion(q1);
		questionAsker.addQuestion(q2);
		
	}
	
	@Test
	public void testRightAnswerCheck(){
		assertTrue(q1.checkAnswer("This is the answer"));
		assertTrue(q2.checkAnswer("answer"));
	}
	
	@Test
	public void testWrongAnswerCheck(){
		assertFalse(q1.checkAnswer("This is not the answer"));
		assertFalse(q2.checkAnswer("not answer"));
		assertFalse(q1.checkAnswer("sgsfgsg"));
		assertFalse(q2.checkAnswer("arartratreat"));
	}
	
	
	@Test
	public void testRandomAsk(){
		Question askedQuestion;
				int numQ1 = 0;
				int numQ2 = 0;
				for( int i = 0; i < 1000; i++ ){
					askedQuestion = questionAsker.askQuestion();
					assertTrue( askedQuestion.equals(q1) || askedQuestion.equals(q2));
					if( askedQuestion.equals(q1) ){
						numQ1++;
					}
					else if( askedQuestion.equals(q2)){
						numQ2++;
					}
				}
				assertTrue(numQ1 > 100);
				assertTrue(numQ2 > 100);
	}
}

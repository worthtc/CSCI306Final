package mathGame;

public class Question {
	private String answer;
	private String questionText;
	
	public boolean checkAnswer( String answer){
		return false;
	}

	public Question(String questionText, String answer) {
		super();
		this.answer = answer;
		this.questionText = questionText;
	}
	
	
}

package mathGame;

public class Question {
	private String answer;
	private String questionText;
	
	public boolean checkAnswer( String answer){
		if(answer == this.answer){
			return true;
		}
		return false;
	}
	public boolean checkQuestion( String q){
		if(q == this.questionText){
			return true;
		}
		return false;
	}
	public Question(String questionText, String answer) {
		super();
		this.answer = answer;
		this.questionText = questionText;
	}
	
	
}

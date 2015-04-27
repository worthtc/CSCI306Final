package mathGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Question extends JFrame {
	private String answer;
	private String questionText;
	private JButton yes;
	private JButton no;
	private Question question;
	private ControlPanel panel;
	
	public boolean checkAnswer( String answer){
		if(answer.equals(this.answer)){
			return true;
		}
		return false;
	}
	public boolean checkQuestion( String q){
		if(q.equals(this.questionText)){
			return true;
		}
		return false;
	}
	public Question(String questionText, String answer) {
		super();
		this.answer = answer;
		this.questionText = questionText;
		
		panel = new ControlPanel();
	}
	
	public String getQuestionText(){
		return questionText;
	}
	
	public String getAnswerText(){
		return answer;
	}
	private JButton submitSetup(){
	 JButton temp = new JButton("yes");
	 class yesListener implements ActionListener{
		Question quest;
		
		public yesListener(Question q){
			this.quest = q;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			panel.askQuestion();
			answer = panel.askQuestion().toString();
			if(checkAnswer(answer)){
				System.out.println("you got it right!");
			} else {
				System.out.println("sorry you got it wrong");
			}
		 	
		  }
	    }
	   temp.addActionListener(new yesListener(this));
	   return temp;
	}
	private JButton noSetup(){
		JButton temp = new JButton("no");
		class noListener implements ActionListener{
			Question question;//To allow closing the frame
			
			public noListener(Question q){
				this.question = q;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				question.dispose();
			}
			
		};
		temp.addActionListener(new noListener(this));
		return temp;
	}
}

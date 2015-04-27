package mathGame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Question extends JFrame {
	private String answer;
	private String questionText;
	private JButton yes;
	private JButton no;
	private ControlPanel panel;
	private JTextField question;
	private JTextField answerField;
	
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
		setLayout(new GridLayout(4,4));
		setTitle("Want to answer a Question?");
		setSize(350,350);
		panel = new ControlPanel();
		yes = submitSetup();
		no = noSetup();
		add(yes);
		add(no);
	    question = new JTextField("Question: ");
	    answerField=new JTextField("");
		add(question, BorderLayout.NORTH);
		add(answerField,BorderLayout.NORTH);
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
			//System.out.println(panel.askQuestion().toString());
			questionText = getQuestionText();
			System.out.println(questionText);
			question.setText(questionText);
			String playerAnswer = answerField.getText();
			System.out.println(answer);
			//answer = panel.askQuestion().toString();
		
			if(checkAnswer(playerAnswer)){
				JOptionPane.showMessageDialog(null,"you got it right!");
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

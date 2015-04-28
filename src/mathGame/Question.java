package mathGame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Question{
	private String answer;
	private String questionText;
	private JButton yes;
	private JButton no;
	private JFrame yesNoPanel;
	private ControlPanel controlGUI;
	
	public boolean checkAnswer( String answer){//checks the answer to see if it is the right answer or not
		if(answer.equals(this.answer)){
			return true;
		}
		return false;
	}
	public boolean checkQuestion( String q){//checks the question used to see if a valid question is asked
		if(q.equals(this.questionText)){
			return true;
		}
		return false;
	}
	public Question(String questionText, String answer, ControlPanel controlGUI) {
		super();
		this.answer = answer;
		this.questionText = questionText;
		this.controlGUI = controlGUI;
	}
	
	public String getQuestionText(){
		return questionText;
	}
	
	public String getAnswerText(){
		return answer;
	}
	private JButton submitSetup(){ //what happens when you hit the yes button on the pop up screen,it asks a question then allows you to answer
	 JButton temp = new JButton("yes");
	 class YesListener implements ActionListener{
		Question quest;
		
		public YesListener(Question q){
			this.quest = q;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			quest.askQuestion();
			yesNoPanel.dispose();
		  }
	    }
	   temp.addActionListener(new YesListener(this));
	   return temp;
	}
	public void askQuestion() {
		JFrame questionPanel = new JFrame();
		questionPanel.setTitle("Your Question!");
		questionPanel.setSize(800,600);
		JTextField question = new JTextField(200);
		question.setEditable(false);
		JTextField answerField = new JTextField(20);
		questionText = getQuestionText();
		question.setText(questionText);
		JButton submitAnswerButton = new JButton("Enter");
		class SubmitAnswerListener implements ActionListener{
			JFrame frame;
			JTextField answerField;
			public SubmitAnswerListener( JTextField answerField, JFrame frame){
				this.frame = frame;
				this.answerField = answerField;
			}
			@Override
			public void actionPerformed(ActionEvent e) { //this checks if you got the right answer or not, if you got it right you get a 5 point increase
				String playerAnswer = answerField.getText();
				if(checkAnswer(playerAnswer)){
					JOptionPane.showMessageDialog(null,"You got it right, Two bonus points!");
					controlGUI.setAnswering(false);
					controlGUI.getDisplay().setDrawPath(false);
					controlGUI.getDisplay().launchMissile();
					controlGUI.getDisplay().setScore(controlGUI.getDisplay().getScore() + 2);
					controlGUI.getDisplay().getScoreField().setText(new Integer(controlGUI.getDisplay().getScore()).toString());
					frame.dispose();
					
				} 
				else{
					JOptionPane.showMessageDialog(null,"That was not correct, better luck next time!");
					controlGUI.setAnswering(false);
					controlGUI.getDisplay().setDrawPath(false);
					controlGUI.getDisplay().launchMissile();
					frame.dispose();
					
				}
			}
			
		};
		submitAnswerButton.addActionListener(new SubmitAnswerListener(answerField, questionPanel));
		questionPanel.setLayout(new GridLayout(3,1));
		questionPanel.add(question);
		questionPanel.add(answerField);
		questionPanel.add(submitAnswerButton);
		questionPanel.setVisible(true);
		
	}
	private JButton noSetup(){//what happens when you hit the no button on the pop up screen, it jsut closes the window
		JButton temp = new JButton("no");
		class NoListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				controlGUI.setAnswering(false);
				controlGUI.getDisplay().setDrawPath(false);
				controlGUI.getDisplay().launchMissile();
				yesNoPanel.dispose();
			}
			
		};
		temp.addActionListener(new NoListener());
		return temp;
	}
	
	public void askYesNoQuestion(){
		yesNoPanel = new JFrame();
		yesNoPanel.setTitle("Want to answer a Question?");
		yesNoPanel.setSize(350,350);
		yesNoPanel.setLayout(new GridLayout( 1,2 ));
		yes = submitSetup();
		no = noSetup();
		yesNoPanel.add(yes);
		yesNoPanel.add(no);
		yesNoPanel.setVisible(true);
	}
}

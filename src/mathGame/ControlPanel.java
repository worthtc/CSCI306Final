package mathGame;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JTextField;


public class ControlPanel {
	private int angle;
	private JTextField angleInput;
	private JComboBox<Missile> possibleTargets;
	private JComboBox<Target> possibleMissiles;
	private JComboBox<Player> possiblePlayers;
	private JMenu fileMenu;
	private ArrayList<Question> possibleQuestions;
	private ArrayList<Missile> missileChoices;
	private ArrayList<Target> targetChoices;
	private ArrayList<Player> playerChoices;
	
	public Question askQuestion(){
		return new Question("","");
	}
	
	public ControlPanel() {
		super();
		possibleQuestions = new ArrayList<Question>();
	}

	public void addQuestion( Question newQuestion ){
		possibleQuestions.add(newQuestion);
	}

	public ArrayList<Question> getPossibleQuestions() {
		return possibleQuestions;
	}
	
	
}

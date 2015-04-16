package mathGame;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JTextField;


public class ControlPanel {
	int angle;
	JTextField angleInput;
	JComboBox<Missile> possibleTargets;
	JComboBox<Target> possibleMissiles;
	JComboBox<Player> possiblePlayers;
	JMenu fileMenu;
	ArrayList<Question> possibleQuestions;
	ArrayList<Missile> missileChoices;
	ArrayList<Target> targetChoices;
	ArrayList<Player> playerChoices;
	
	public void askQuestion(){}
}

package mathGame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlPanel extends JPanel{
	private int angle;
	private JTextField angleInput;
	private JComboBox<Target> possibleTargets;
	private JComboBox<Missile> possibleMissiles;
	private JComboBox<Player> possiblePlayers;
	private JMenuBar fileMenuBar;
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
		//JLabel targetLabel = new JLabel("Targets:");
		possibleTargets = new JComboBox<Target>();
		//JLabel missilesLabel = new JLabel("Missiles");
		possibleMissiles = new JComboBox<Missile>();
		//JLabel playersLabel = new JLabel("Characters");
		possiblePlayers = new JComboBox<Player>();
		JMenu fileMenu = new JMenu("File");
		//JLabel angleLabel = new JLabel("Input Angle:");
		angleInput = new JTextField(5);
		JButton angleInputButton = new JButton("Enter");
		class EnterListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		fileMenuBar = new JMenuBar();
		class ExitListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitListener());
		fileMenu.add(exit);
		fileMenuBar.add(fileMenu);
		this.setLayout(new GridLayout(1,4));
		//this.add(fileMenuBar);
		
		JPanel playerPanel = new JPanel();
		//playerPanel.add(playersLabel);
		playerPanel.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
		playerPanel.add(possiblePlayers);
		this.add(playerPanel);
		
		JPanel missilePanel = new JPanel();
		//missilePanel.add(missilesLabel);
		missilePanel.setBorder(new TitledBorder(new EtchedBorder(), "Missiles"));
		missilePanel.add(possibleMissiles);
		this.add(missilePanel);
		
		JPanel targetPanel = new JPanel();
		//targetPanel.add(targetLabel);
		targetPanel.add(possibleTargets);
		targetPanel.setBorder(new TitledBorder(new EtchedBorder(), "Targets"));
		this.add(targetPanel);
		
		JPanel anglePanel = new JPanel();
		//anglePanel.add(angleLabel);
		anglePanel.setBorder(new TitledBorder(new EtchedBorder(), "Input Angle"));
		anglePanel.add(angleInput);
		anglePanel.add(angleInputButton);
		this.add(anglePanel);
	}

	public void addQuestion( Question newQuestion ){
		possibleQuestions.add(newQuestion);
	}

	public ArrayList<Question> getPossibleQuestions() {
		return possibleQuestions;
	}

	public JMenuBar getFileMenuBar() {
		return fileMenuBar;
	}
	
	
	
}

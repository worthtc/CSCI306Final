package mathGame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ControlPanel extends JPanel{
	private double angle;
	private JTextField angleInput;
	private JComboBox<String> possibleTargets;
	private JComboBox<String> possibleMissiles;
	private JComboBox<String> possiblePlayers;
	private JMenuBar fileMenuBar;
	private ArrayList<Question> possibleQuestions;
	private ArrayList<Missile> missileChoices;
	private ArrayList<Target> targetChoices;
	private ArrayList<Player> playerChoices;
	private MathAngleAndFunTimesGUI gui;
	public Question askQuestion(){
		return new Question("","");
	}
	
	public ControlPanel() {
		super();
		gui = new MathAngleAndFunTimesGUI();
		possibleQuestions = new ArrayList<Question>();
		//JLabel targetLabel = new JLabel("Targets:");
		possibleTargets = new JComboBox<String>();
		//JLabel missilesLabel = new JLabel("Missiles");
		possibleMissiles = new JComboBox<String>();
		//JLabel playersLabel = new JLabel("Characters");
		possiblePlayers = new JComboBox<String>();
		JMenu fileMenu = new JMenu("File");
		//JLabel angleLabel = new JLabel("Input Angle:");
		angleInput = new JTextField(5);
		JButton angleInputButton = new JButton("Enter");
		class EnterListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				try{
					String input = angleInput.getText();
					angle = Double.parseDouble(input);
					if( !(angle >= 0) || !(angle <= 360)){
						JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 360", "Invalid input", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				catch( NumberFormatException exc){
					JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 360", "Invalid input", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		}
		angleInputButton.addActionListener(new EnterListener());
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
		possiblePlayers = createPlayersCombo();
		playerPanel.add(possiblePlayers);
		this.add(playerPanel);
		
		JPanel missilePanel = new JPanel();
		//missilePanel.add(missilesLabel);
		missilePanel.setBorder(new TitledBorder(new EtchedBorder(), "Missiles"));
		possibleMissiles = createMissleCombo();
		missilePanel.add(possibleMissiles);
		this.add(missilePanel);
		
		JPanel targetPanel = new JPanel();
		//targetPanel.add(targetLabel);
		possibleTargets = createTargetCombo();
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
	private  JComboBox<String> createPlayersCombo()  {
		
		
		
			possiblePlayers.addItem("Lumber Jack");
			possiblePlayers.addItem("Wizzzzzerd");
			possiblePlayers.addItem("Archer");
		
		return possiblePlayers;
	}
	private  JComboBox<String> createMissleCombo()  {
		
		
		
			possibleMissiles.addItem("Axe");
			possibleMissiles.addItem("Lighting Bolt");
			possibleMissiles.addItem("Arrow");
		
		return possibleMissiles;
		
	}
	private  JComboBox<String> createTargetCombo()  {
		
		
			possibleTargets.addItem("Tree");
			possibleTargets.addItem("Dragon");
			possibleTargets.addItem("Target");
		
		return possibleTargets;
		
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

	public double getAngle() {
		return angle;
	}
	
	@SuppressWarnings("resource")
	private String[] readFile(String fname) {
		  ArrayList<String> arr = new ArrayList<>();
		  try {
		     FileInputStream fstream = new FileInputStream(fname);
		     BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		     String strLine;
		     while ((strLine = br.readLine()) != null) {
		        arr.add(strLine);
		     }
		     
		  } catch (Exception e) {
		  }
		  return arr.toArray(new String[arr.size()]);
		}
	
	
}

package mathGame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class ControlPanel extends JPanel{
	private double angle;
	private double velocity;
	private JTextField scoreField;
	private final double maxAngle = 360;
	private final double minAngle = 0;
	private final double maxVelocity = 250;
	private final double minVelocity = 0;
	private JTextField angleInput;
	private JComboBox<String> possibleTargets;
	private JComboBox<String> possibleMissiles;
	private JComboBox<String> possiblePlayers;
	private JMenuBar fileMenuBar;
	private ArrayList<Question> possibleQuestions;
	private ArrayList<Missile> missileChoices;
	private ArrayList<Target> targetChoices;
	private ArrayList<Player> playerChoices;
	private DisplayPanel display;
	private JTextField velocityInput;
	public Question askQuestion(){
		int index = (int) (Math.random()*possibleQuestions.size());
		return possibleQuestions.get(index);
	}
	
	public ControlPanel() {
		super();
		missileChoices = new ArrayList<Missile>();
		playerChoices = new ArrayList<Player>();
		targetChoices = new ArrayList<Target>();
		possibleQuestions = new ArrayList<Question>();
		//JLabel targetLabel = new JLabel("Targets:");
		possibleTargets = new JComboBox<String>();
		//JLabel missilesLabel = new JLabel("Missiles");
		possibleMissiles = new JComboBox<String>();
		//JLabel playersLabel = new JLabel("Characters");
		possiblePlayers = new JComboBox<String>();
	}

	private  JComboBox<String> createPlayersCombo()  {
		for(Player p:playerChoices){
			possiblePlayers.addItem(p.getName());
		}
		possiblePlayers.addActionListener(new ComboListener());
		return possiblePlayers;
	}
	private  JComboBox<String> createMissileCombo()  {
		for(Missile m:missileChoices){
			possibleMissiles.addItem(m.getName());
		}
		possibleMissiles.addActionListener(new ComboListener());
		return possibleMissiles;
		
	}
	private  JComboBox<String> createTargetCombo()  {
		for(Target t:targetChoices){
			possibleTargets.addItem(t.getName());
		}
		possibleTargets.addActionListener(new ComboListener());
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

	public void setDisplay(DisplayPanel display) {
		this.display = display;
	}
	
	public void setupGUI(ArrayList<String> missileTypes, ArrayList<String> playerTypes, ArrayList<String> targetTypes){
		for( String missileString: missileTypes ){
			Missile m = display.getCurrentMissile();
			missileChoices.add(new Missile(m.getX(), m.getY(), missileString));
		}
		for( String playerString: playerTypes ){
			Player p = display.getCurrentPlayer();
			playerChoices.add(new Player(p.getX(), p.getY(), playerString));
		}
		for( String targetString: targetTypes ){
			Target t = display.getCurrentTarget();
			targetChoices.add(new Target(t.getX(), t.getY(), t.getWidth(), t.getHeight(), targetString));
		}
		JMenu fileMenu = new JMenu("File");
		//JLabel angleLabel = new JLabel("Input Angle:");
		velocityInput = new JTextField(5);
		velocityInput.setText("0");
		JButton velocityInputButton = new JButton("Enter");
		
		velocityInputButton.addActionListener( new VelocityListener());
		
		angleInput = new JTextField(5);
		JButton angleInputButton = new JButton("Enter");
		class LaunchListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				display.launchMissile();
				//scoreField.setText(new Integer(display.getScore()).toString());
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
		this.setLayout(new GridLayout(1,2));
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
		possiblePlayers = createPlayersCombo();
		playerPanel.add(possiblePlayers);
		
		JPanel missilePanel = new JPanel();
		missilePanel.setBorder(new TitledBorder(new EtchedBorder(), "Missiles"));
		possibleMissiles = createMissileCombo();
		missilePanel.add(possibleMissiles);
		
		JPanel targetPanel = new JPanel();
		possibleTargets = createTargetCombo();
		targetPanel.add(possibleTargets);
		targetPanel.setBorder(new TitledBorder(new EtchedBorder(), "Targets"));
		
		JPanel ComboBoxPanel = new JPanel();
		ComboBoxPanel.setLayout(new GridLayout(1, 3));
		ComboBoxPanel.add(targetPanel);
		ComboBoxPanel.add(missilePanel);
		ComboBoxPanel.add(playerPanel);
		this.add(ComboBoxPanel);
		
		angleInputButton.addActionListener(new AngleButtonListener());
		JPanel anglePanel = new JPanel();
		anglePanel.setBorder(new TitledBorder(new EtchedBorder(), "Input Angle"));
		anglePanel.add(angleInput);
		anglePanel.add(angleInputButton);
		
		JPanel velocityPanel = new JPanel();
		velocityPanel.setBorder(new TitledBorder( new EtchedBorder(), "Input Velocity"));
		velocityPanel.add(velocityInput);
		velocityPanel.add(velocityInputButton);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 2));
		inputPanel.add(anglePanel);
		inputPanel.add(velocityPanel);
		this.add(inputPanel);
		
		JButton launchButton = new JButton("Launch");
		launchButton.addActionListener(new LaunchListener());
		
		scoreField = new JTextField(5);
		display.setScoreField(scoreField);
		scoreField.setEditable(false);
		scoreField.setText(new Integer(display.getScore()).toString());
		JPanel scorePanel = new JPanel();
		scorePanel.add(scoreField);
		scorePanel.setBorder(new TitledBorder( new EtchedBorder(), "Score"));
		
		JPanel otherPanel = new JPanel();
		otherPanel.setLayout(new GridLayout(1, 2));
		otherPanel.add(scorePanel);
		otherPanel.add(launchButton);
		this.add(otherPanel);
		
		JPanel looksPanel = new JPanel();
		looksPanel.setLayout(new BorderLayout());
		looksPanel.add(otherPanel, BorderLayout.SOUTH);
		looksPanel.add(inputPanel, BorderLayout.CENTER);
		this.add(looksPanel);
	}
	
	class AngleButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				String input = angleInput.getText();
				angle = Double.parseDouble(input);
				if( !(angle >= 0) || !(angle <= maxAngle)){
					JOptionPane.showMessageDialog(null, "Please enter a number between " + minAngle + " and " + maxAngle, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			catch( NumberFormatException exc){
				JOptionPane.showMessageDialog(null, "Please enter a number between " + minAngle + " and " + maxAngle, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			display.setAngle(angle);
			display.setLaunchPoints(display.getCurrentMissile().calcPath(display.getAngle(), display.getVelocity() ));
			display.getCurrentMissile().drawPath(getGraphics());
		}
	}
	class VelocityListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			try{
				String input = velocityInput.getText();
				velocity = Double.parseDouble(input);
				if( !(velocity >= minVelocity) || !(velocity <= maxVelocity)){
					JOptionPane.showMessageDialog(null, "Please enter a number between " + minVelocity + " and " + maxVelocity, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			catch( NumberFormatException exc){
				JOptionPane.showMessageDialog(null, "Please enter a number between " + minVelocity + " and " + maxVelocity, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			display.setVelocity(velocity);
			display.setLaunchPoints(display.getCurrentMissile().calcPath(display.getAngle(), display.getVelocity() ));
			display.getCurrentMissile().drawPath(getGraphics());
		}
	}
	class ComboListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			if( e.getSource() == possiblePlayers ){
				display.getCurrentPlayer().setName(possiblePlayers.getSelectedItem().toString());
			}
			else if( e.getSource() == possibleMissiles){
				display.getCurrentMissile().setName(possibleMissiles.getSelectedItem().toString());
			}
			else if( e.getSource() == possibleTargets){
				display.getCurrentTarget().setName(possibleTargets.getSelectedItem().toString());
			}
		}
	}
}


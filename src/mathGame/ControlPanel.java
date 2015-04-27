package mathGame;
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
		JButton velocityInputButton = new JButton("Enter");
		class VelocityListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				try{
					String input = velocityInput.getText();
					velocity = Double.parseDouble(input);
					if( !(velocity > minVelocity) || !(velocity <= maxVelocity)){
						JOptionPane.showMessageDialog(null, "Please enter a number between " + minVelocity + " and " + maxVelocity, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				catch( NumberFormatException exc){
					JOptionPane.showMessageDialog(null, "Please enter a number between " + minVelocity + " and " + maxVelocity, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				display.setVelocity(velocity);
			}
		}
		velocityInputButton.addActionListener( new VelocityListener());
		
		angleInput = new JTextField(5);
		JButton angleInputButton = new JButton("Enter");
		class EnterListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
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
				//display.printValues();
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
		this.setLayout(new GridLayout(1,5));
		//this.add(fileMenuBar);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
		possiblePlayers = createPlayersCombo();
		playerPanel.add(possiblePlayers);
		this.add(playerPanel);
		
		JPanel missilePanel = new JPanel();
		missilePanel.setBorder(new TitledBorder(new EtchedBorder(), "Missiles"));
		possibleMissiles = createMissileCombo();
		missilePanel.add(possibleMissiles);
		this.add(missilePanel);
		
		JPanel targetPanel = new JPanel();
		possibleTargets = createTargetCombo();
		targetPanel.add(possibleTargets);
		targetPanel.setBorder(new TitledBorder(new EtchedBorder(), "Targets"));
		this.add(targetPanel);
		
		
		JPanel anglePanel = new JPanel();
		anglePanel.setBorder(new TitledBorder(new EtchedBorder(), "Input Angle"));
		anglePanel.add(angleInput);
		anglePanel.add(angleInputButton);
		this.add(anglePanel);
		
		JPanel velocityPanel = new JPanel();
		velocityPanel.setBorder(new TitledBorder( new EtchedBorder(), "Input Velocity"));
		velocityPanel.add(velocityInput);
		velocityPanel.add(velocityInputButton);
		this.add(velocityPanel);
	}
	
	class AngleFeildListener implements FocusListener{


		
		public void focusLost(FocusEvent e) {
		
				String input = angleInput.getText();
				angle = Double.parseDouble(input);
				if( !(angle >= 0) || !(angle <= maxAngle)){
					JOptionPane.showMessageDialog(null, "Please enter a number between " + minAngle + " and " + maxAngle, "Invalid input", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			
			
				
			
			display.getCurrentMissile().drawPath(getGraphics());;
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
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
			//display.printValues();
		}
	}
}


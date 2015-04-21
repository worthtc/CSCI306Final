package mathGame;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;


public class MathAngleAndFunTimesGUI extends JFrame{
	private ControlPanel controlGUI;
	private DisplayPanel displayPanel;
	private String filename;
	private ArrayList<String> missileTypes;
	
	private double gravity; //Could be an int, though equally as functional as a double and allows for more complex gravity if desired.
	private Point personStart;
	private Point missileStart;
	
	public MathAngleAndFunTimesGUI(String filename){
		this.setResizable(false);
		this.filename = filename;
		missileTypes = new ArrayList<String>();
		controlGUI = new ControlPanel();
		setSize(800, 600);
		setTitle("Math and Angle Fun Times!");// Note: title is a work in progress
		setLayout(new BorderLayout());
		add(controlGUI, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(controlGUI.getFileMenuBar());
		setVisible(true);
	}
	
	public void loadConfigFiles(){}
	
	public ArrayList<String> getMissileTypes(){
		return missileTypes;
	}
	
	public double getGravity(){
		return gravity;
	}
	
	public Point getPersonStart(){
		return personStart;
	}
	
	public Point getMissileStart(){
		return missileStart;
	}

	public ControlPanel getControlGUI() {
		return controlGUI;
	}
	
	public static void main(String[] args){
		MathAngleAndFunTimesGUI game = new MathAngleAndFunTimesGUI("THIS GAME IS FUN!");
		
	}
}

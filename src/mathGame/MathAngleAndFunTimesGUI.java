package mathGame;

import java.awt.Point;
import java.util.ArrayList;

public class MathAngleAndFunTimesGUI {
	private ControlPanel controlGUI;
	private DisplayPanel displayPanel;
	private String filename;
	private ArrayList<String> missileTypes;
	
	private double gravity; //Could be an int, though equally as functional as a double and allows for more complex gravity if desired.
	private Point personStart;
	private Point missileStart;
	
	public MathAngleAndFunTimesGUI(String filename){
		this.filename = filename;
		missileTypes = new ArrayList<String>();
		controlGUI = new ControlPanel();
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
	
	
}

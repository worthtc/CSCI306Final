package mathGame;

import java.awt.BorderLayout;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


public class MathAngleAndFunTimesGUI extends JFrame{
	private ControlPanel controlGUI;
	private DisplayPanel displayPanel;
	private String filename;
	private ArrayList<String> missileTypes;
	
	private double gravity; //Could be an int, though equally as functional as a double and allows for more complex gravity if desired.
	private int screenX;
	private int screenY;
	private Point personStart;
	private Point missileStart;
	
	public MathAngleAndFunTimesGUI(String filename){
		this.setResizable(false);
		this.filename = filename;
		try{
			loadConfigFiles();
		}catch(BadConfigFormatException e){
			System.out.println(e);
		}
		missileTypes = new ArrayList<String>();
		controlGUI = new ControlPanel();
		setSize(screenX, screenY);
		setTitle("Math and Angles Fun Times!");// Note: title is a work in progress
		setLayout(new BorderLayout());
		add(controlGUI, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(controlGUI.getFileMenuBar());
		setVisible(true);
	}
	
	public void loadConfigFiles() throws BadConfigFormatException{
		try{
			FileReader configReader = new FileReader(filename);
			Scanner inf = new Scanner(configReader);
			String currentLine = inf.nextLine();
			String[] lineParse = currentLine.split(" ");
			if(lineParse.length > 2){
				inf.close();
				throw new BadConfigFormatException("The first line must have exactly 2 integers for the height and width of the frame!");
			}
			try{
				screenX = Integer.parseInt(lineParse[0]);
				screenY = Integer.parseInt(lineParse[1]);
			}catch(NumberFormatException e){
				System.out.println(e);
			}
			while(inf.hasNextLine()){
				currentLine = inf.nextLine();
				lineParse = currentLine.split(":");
				switch(lineParse[0]){
				case "Missile":
					if(lineParse.length > 3){
						inf.close();
						throw new BadConfigFormatException("Missile cannot be given more than two coordinates!");
					}
					break;
				case "MissileType":
					if(lineParse.length > 2){
						inf.close();
						throw new BadConfigFormatException("MissileType lines cannot be followed by more than one string name!" + lineParse[1] + " " + lineParse[2]);
					}
					missileTypes.add(lineParse[1]);
					break;
				case "Person":
					break;
				case "Gravity":
					break;
				case "Question":
					break;
				default:
					inf.close();
					throw new BadConfigFormatException("The keyword " + lineParse[0] + " is not a valid keyword to start a line.");
				}
			}
			inf.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
	}
	
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
		MathAngleAndFunTimesGUI game = new MathAngleAndFunTimesGUI("launchConfig.txt");
		
	}
}

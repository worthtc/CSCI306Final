package mathGame;

import java.awt.BorderLayout;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MathAngleAndFunTimesGUI extends JFrame{
	private ControlPanel controlGUI;
	private DisplayPanel displayPanel;
	private String filename;
	private ArrayList<String> missileTypes;
	private ArrayList<String> personTypes;
	private ArrayList<String> targetTypes;
	
	private double gravity; //Could be an int, though equally as functional as a double and allows for more complex gravity if desired.
	private int screenX;
	private int screenY;
	private Point personStart;
	private Point missileStart;
	private Point targetStart;
	private int targetWidth;
	private int targetHeight;
	
	public MathAngleAndFunTimesGUI(){
		//basic constructor for testing
		
	}	
	public MathAngleAndFunTimesGUI(String filename){
		this.setResizable(false); //Since our locations are all set pixel values we want to make sure that the screen is not resized
		this.filename = filename;
		missileTypes = new ArrayList<String>();
		personTypes = new ArrayList<String>();
		targetTypes = new ArrayList<String>();
		controlGUI = new ControlPanel();
		try{
			loadConfigFiles();
		}catch(BadConfigFormatException e){
			System.out.println(e);
		}
		Missile startMissile = new Missile((int)missileStart.getX(), (int)missileStart.getY(), missileTypes.get(0));
		Player startPlayer = new Player((int)personStart.getX(), (int)personStart.getY(), personTypes.get(0));
		Target startTarget = new Target((int)targetStart.getX(), (int)targetStart.getY(), targetWidth, targetHeight, targetTypes.get(0));
		startMissile.setScreenX(screenX);
		startMissile.setScreenY(screenY);
		displayPanel = new DisplayPanel(startMissile, startPlayer, startTarget );
		controlGUI.setDisplay(displayPanel);
		controlGUI.setupGUI(missileTypes, personTypes, targetTypes);
		setSize(screenX, screenY);
		setTitle("Math and Angles Fun Times!");// Note: title is a work in progress
		setLayout(new BorderLayout());
		add(controlGUI, BorderLayout.NORTH);
		add(displayPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(controlGUI.getFileMenuBar());
		setVisible(true);
	}
	
	public void MAAFTGUITestConstructor(String filename) throws BadConfigFormatException{
		this.setResizable(false);
		this.filename = filename;
		missileTypes = new ArrayList<String>();
		personTypes = new ArrayList<String>();
		targetTypes = new ArrayList<String>();
		controlGUI = new ControlPanel();
		loadConfigFiles();
		controlGUI.setDisplay(displayPanel);
		controlGUI.setupGUI(missileTypes, personTypes, targetTypes);
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
					if(lineParse.length != 3){
						inf.close();
						throw new BadConfigFormatException("Missile cannot be given more than two coordinates!");
					}
					missileStart = new Point(Integer.parseInt(lineParse[1]), Integer.parseInt(lineParse[2]));
					break;
				case "MissileType":
					if(lineParse.length != 2){
						inf.close();
						throw new BadConfigFormatException("MissileType lines cannot be followed by more than one string name!" + lineParse[1] + " " + lineParse[2]);
					}
					missileTypes.add(lineParse[1]);
					break;
				case "Person":
					if(lineParse.length != 3){
						inf.close();
						throw new BadConfigFormatException("Person cannot have more than two coordinates!");
					}
					personStart = new Point(Integer.parseInt(lineParse[1]),Integer.parseInt(lineParse[2]));
					break;
				case "PersonType":
					if(lineParse.length != 2){
						inf.close();
						throw new BadConfigFormatException("PersonType lines cannot be followed by more than one string name!" + lineParse[1] + " " + lineParse[2]);
					}
					personTypes.add(lineParse[1]);
					break;
				case "Gravity":
					if(lineParse.length != 2){
						inf.close();
						throw new BadConfigFormatException("Gravity must be followed by exactly one string, and that string must contain a double.");
					}
					try{
						gravity = Double.parseDouble(lineParse[1]);
					}catch(NumberFormatException e){
						System.out.println(e);
						inf.close();
						throw new BadConfigFormatException("The value after Gravity was not a double!");
					}
					break;
				case "Target":
					if(lineParse.length != 5){
						inf.close();
						throw new BadConfigFormatException("Target cannot have more than a startX, a startY, a width, and a height!");
					}
					targetStart = new Point(Integer.parseInt(lineParse[1]),Integer.parseInt(lineParse[2]));
					targetWidth = Integer.parseInt(lineParse[3]);
					targetHeight = Integer.parseInt(lineParse[4]);
					break;
				case "TargetType":
					if(lineParse.length != 2){
						inf.close();
						throw new BadConfigFormatException("Can't have more than one name for a target!");
					}
					targetTypes.add(lineParse[1]);
					break;
				case "Question":
					if(lineParse.length != 2){
						inf.close();
						throw new BadConfigFormatException("Cannot have more than one question part!");
					}
					String ans = inf.nextLine();
					String[] answer = ans.split(":");
					if(!answer[0].equals("Answer")){
						inf.close();
						throw new BadConfigFormatException("Questions must be followed by Answers!");
					}
					if(answer.length != 2){
						inf.close();
						throw new BadConfigFormatException("Answers can't have more than one text body!");
					}
					controlGUI.addQuestion(new Question(lineParse[1], answer[1]));
					break;
				case "Answer":
					inf.close();
					throw new BadConfigFormatException("Answers must only follow questions!");
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
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		MathAngleAndFunTimesGUI game = new MathAngleAndFunTimesGUI("launchConfig.txt");
	}
}

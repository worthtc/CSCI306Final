package mathGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel{
	private JTextField scoreField;
	private int score = 0;
	private Target currentTarget;
	private Missile currentMissile;
	private Player currentPlayer;
	private int missileStartX;
	private int missileStartY;
	private double angle;
	private double velocity;
	private ArrayList<Point> launchPoints;
	private Timer timer;
	private int currentIndex;
	private boolean drawPath;
	private boolean isLaunching;
	public DisplayPanel(Missile currentMissile, Player currentPlayer, Target currentTarget) {
		this.currentTarget = currentTarget;
		this.currentMissile = currentMissile;
		missileStartX = currentMissile.getX();
		missileStartY = currentMissile.getY();
		this.currentPlayer = currentPlayer;
		timer = new Timer(10, new TimerListener());
	}
	
	public void launchMissile(){ //launches the missile and out puts a message if no angle is entered
		if( launchPoints == null){
			JOptionPane.showMessageDialog(null, "You must enter an angle before launching the missile!", "Invalid input", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		isLaunching = true;
		timer.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//Draw the pretty sky and grass
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, currentMissile.getScreenX(), (int)((double)currentMissile.getScreenY()/2));
		g.setColor(Color.GREEN);
		g.fillRect(0, (int)(((double)currentMissile.getScreenY())/2), currentMissile.getScreenX(), (int)((double)currentMissile.getScreenY()/2));
		//Then draw the items on the board
		currentTarget.draw(g);
		currentMissile.draw(g);
		currentPlayer.draw(g);
		if( drawPath ){
			currentMissile.drawPath(g);
		}
	}
	
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint(); 
			shootHelper();
		}
	}
	
	private void shootHelper() { //does all the calculations needed to shoot the missile
		if( currentMissile.isColliding(currentTarget) ){
			currentIndex = 0;
			timer.stop();
			currentMissile.setX(missileStartX);
			currentMissile.setY(missileStartY);
			currentTarget.setX((int)((Math.random()*(this.getSize().getWidth()))));
			currentTarget.setY((int) ((Math.random()*(this.getSize().getHeight()))));
			//Try to ensure the Target is randomly assigned to a good place on the screen
			while( currentMissile.isColliding(currentTarget) || currentTarget.getX() <= 0 || currentTarget.getY() <= 0 || (currentTarget.getX() + currentTarget.getWidth()) >= currentMissile.getScreenX() || (currentTarget.getY() + currentTarget.getHeight()) >= currentMissile.getScreenY()){
				currentTarget.setX((int) (Math.random()*(this.getSize().getWidth()-100)));
				currentTarget.setY((int) (Math.random()*(this.getSize().getHeight()-150)));
			}
			score++;
			scoreField.setText(new Integer(score).toString());
			isLaunching = false;
		}
		//If we have left the screen, we are at the end of launchPoints and we stop the timer
		else if(currentIndex >= launchPoints.size()){
			currentIndex = 0;
			timer.stop();
			currentMissile.setX(missileStartX);
			currentMissile.setY(missileStartY);
			isLaunching = false;
		}
		//Otherwise we move to the next point
		else {
			Point pathPoint = launchPoints.get(currentIndex);
			currentMissile.setX(pathPoint.x);
			currentMissile.setY(pathPoint.y);
			currentIndex++;
			
		}
	}
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public void setScoreField(JTextField scoreField) {
		this.scoreField = scoreField;
	}
	public void setDrawPath(boolean drawPath) {
		this.drawPath = drawPath;
		this.repaint();
	}
	public JTextField getScoreField() {
		return scoreField;
	}
	public boolean isLaunching() {
		return isLaunching;
	}
	public void setLaunching(boolean isLaunching) {
		this.isLaunching = isLaunching;
	}
	public Target getCurrentTarget() {
		return currentTarget;
	}
	public void setCurrentTarget(Target currentTarget) {
		this.currentTarget = currentTarget;
	}
	public Missile getCurrentMissile() {
		return currentMissile;
	}
	public void setCurrentMissile(Missile currentMissile) {
		this.currentMissile = currentMissile;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public void setVelocity( double velocity ){
		this.velocity = velocity;
	}
	public double getAngle() {
		return angle;
	}
	public double getVelocity() {
		return velocity;
	}
	
	public void setLaunchPoints(ArrayList<Point> launchPoints) {
		this.launchPoints = launchPoints;
	}
}

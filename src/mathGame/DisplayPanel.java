package mathGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel{
	private Target currentTarget;
	private Missile currentMissile;
	private Player currentPlayer;
	private double angle;
	private double velocity;
	private ArrayList<Point> launchPoints;
	
	public DisplayPanel(Missile currentMissile, Player currentPlayer, Target currentTarget) {
		this.currentTarget = currentTarget;
		this.currentMissile = currentMissile;
		this.currentPlayer = currentPlayer;
		//printValues();
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
	public void launchMissile(){
		if( launchPoints == null){
			JOptionPane.showMessageDialog(null, "You must enter an angle before launching the missile!", "Invalid input", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		for( Point pathPoint: launchPoints ){
			currentMissile.setX(pathPoint.x);
			currentMissile.setY(pathPoint.y);
			if( currentMissile.isColliding(currentTarget) ){
				return;
			}
		}
	}
	public void printValues(){
		System.out.println(currentTarget.getName());
		System.out.println(currentMissile.getName());
		System.out.println(currentPlayer.getName());
		System.out.println(angle);
		System.out.println(velocity);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		System.out.println(currentMissile.getScreenX());
		System.out.println(currentMissile.getScreenY());
		g.fillRect(0, 0, currentMissile.getScreenX(), (int)((double)currentMissile.getScreenY()/2));
		g.setColor(Color.GREEN);
		g.fillRect(0, (int)(((double)currentMissile.getScreenY())/2), currentMissile.getScreenX(), (int)((double)currentMissile.getScreenY()/2));
		//currentTarget.draw(g);
		//currentMissile.draw(g);
		//currentPlayer.draw(g);
		
	}
}

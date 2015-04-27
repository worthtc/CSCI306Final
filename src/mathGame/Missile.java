package mathGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;



public class Missile {
	private int x;
	private int y;
	private int screenX, screenY;
	private double gravity;
	private String name;
	private ArrayList<Point> launchPoints;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void draw( Graphics g ){
		g.setColor(Color.RED);
		g.fillRect(x, y, 5, 5);
	}
	public boolean isColliding( Target boardTarget){
		if (x >= boardTarget.getX() && x <= boardTarget.getX() + boardTarget.getWidth()){
			if (y >= boardTarget.getY() && y <= boardTarget.getY() + boardTarget.getHeight()){
				return true;
			}
		}
		return false;
	}
	public void drawPath( Graphics g ){
		g.setColor(Color.RED);
		for (int i = 0; i < launchPoints.size(); i++){
			g.fillOval((int)(launchPoints.get(i).getX()),(int)(launchPoints.get(i).getY()),6,6);
		}
	}
	public ArrayList<Point> calcPath(double inputAngle, double intialVelocity ){
		int nextX = this.x;
		int nextY = this.y;
		double angleRadians = Math.toRadians(inputAngle); //Convert our angle to radians
		double velocityX = intialVelocity*Math.cos(angleRadians);
		double velocityY = intialVelocity*Math.sin(angleRadians);
		ArrayList<Point> pathList = new ArrayList<Point>();
		double time = 0.0;
		Point nextPoint = new Point(nextX, nextY);
		pathList.add(nextPoint);
		
		//We continue to add points to the list until our missile goes off of the screen 
		//We can just test for the screenX and Y if we want the missile to be able to go above y=0
		while( nextPoint.x >= 0 && nextPoint.x <= screenX && nextPoint.y <= screenY){
			time += 0.1; //Increment our timesteps by 0.1 seconds. This value can be changed if needed
			//Calculate X and Y for the next point according to the equation X = X_0 + v_0*t + (1/2)*a*t^2
			nextX =(int) (this.x + velocityX*time); 
			nextY = (int) (this.y - velocityY*time + (0.5)*gravity*time*time); //Here we subtract velocityY*time as velocityY is upwards which is negative
			nextPoint = new Point(nextX, nextY);
			pathList.add(nextPoint);
		}
		launchPoints = pathList;
		return pathList;
	}
	public Missile(int x, int y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}
	public Missile() {
		super();
	}
	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}
	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScreenX() {
		return screenX;
	}
	public int getScreenY() {
		return screenY;
	}
	public ArrayList<Point> getLaunchPoints() {
		return launchPoints;
	}
	
	
	
	
	
	
	
}

package mathGame;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Missile {
	private int x;
	private int y;
	private int screenX, screenY;
	private double gravity;
	
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
	public void launchMissile( double inputAngle ){}
	public void draw( Graphics g ){}
	public boolean isColliding( Target boardTarget){
		if (x >= boardTarget.getx() && x <= boardTarget.getx() + boardTarget.getwidth()){
			if (y >= boardTarget.gety() && y <= boardTarget.gety() + boardTarget.getheight()){
				return true;
			}
		}
		return false;
	}
	public void drawPath( Graphics g){}
	public ArrayList<Point> calcPath(double inputAngle, int intialVelocity ){
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
		while( nextPoint.x >= 0 && nextPoint.x <= screenX && nextPoint.y >= 0 && nextPoint.y <= screenY){
			time += 0.1; //Increment our timesteps by 0.1 seconds. This value can be changed if needed
			//Calculate X and Y for the next point according to the equation X = X_0 + v_0*t + (1/2)*a*t^2
			nextX =(int) (this.x + velocityX*time); 
			nextY = (int) (this.y - velocityY*time + (0.5)*gravity*time*time); //Here we subtract velocityY*time as velocityY is upwards which is negative
			nextPoint = new Point(nextX, nextY);
			pathList.add(nextPoint);
		}
		return pathList;
	}
	public Missile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
	
	
	
	
	
	
}

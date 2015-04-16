package mathGame;
import java.awt.Graphics;
import java.util.ArrayList;


public class Missile {
	int x;
	int y;
	
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
	public void launchMissile( int inputAngle ){}
	public void draw( Graphics g ){}
	public boolean isColliding( Target boardTarget){
		
		return false;
	}
	public void drawPath( Graphics g){}
	public ArrayList<Integer> calcPath(){
		return null;
	}
	
	
}

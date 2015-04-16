package mathGame;
import java.awt.Graphics;
import java.util.ArrayList;


public class Missile {
	int x;
	int y;
	
	public void launchMissile( int inputAngle ){}
	public void draw( Graphics g ){}
	public boolean isColliding( Target boardTarget ){
		return false;
	}
	public void drawPath( Graphics g){}
	public ArrayList<Integer> calcPath(){
		return null;
	}
	
	
}

package mathGame;
import java.awt.Graphics;


public class Target {
	private int x;
	private int y;
	private int width;
	private int height;
	public void draw( Graphics g ){}
	
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public int getwidth(){
		return width;
	}
	public int getheight(){
		return height;
	}
	public void setwidth(int w){
		 this.width = w;
	}
	public void setheight(int h){
		 this.height = h;
	}
	public void setx(int xpos){
		 this.x = xpos;
	}
	public void sety(int ypos){
		 this.y = ypos;
	}
}

package mathGame;
import java.awt.Graphics;


public class Target {
	private int x;
	private int y;
	private int width;
	private int height;
	private String name;
	public void draw( Graphics g ){}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setWidth(int w){
		 this.width = w;
	}
	public void setHeight(int h){
		 this.height = h;
	}
	public void setX(int xpos){
		 this.x = xpos;
	}
	public void setY(int ypos){
		 this.y = ypos;
	}

	public Target() {
		super();
	}

	public Target(int x, int y, int width, int height, String name) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	
}

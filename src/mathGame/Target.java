package mathGame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Target {
	private int x;
	private int y;
	private int width;
	private int height;
	private String name;
	private BufferedImage img = null;
	public void draw( Graphics g ){
		try{
			img = ImageIO.read(new File("src/images/"+name+"_target.png"));
		}catch(IOException e){
			System.out.println(e);
		}
		g.drawImage(img, x, y, null);
	}
	
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
	//sets the variables needed for the target 
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

	public Target(int x, int y, int width, int height, String name) {//sets up the target used on the screen
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

	public void setName(String name) {
		this.name = name;
	}

	
	
}

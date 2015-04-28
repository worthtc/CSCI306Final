package mathGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player {
	private int x;
	private int y;
	private String name;
	private BufferedImage img = null;
	
	public Player(int x, int y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}
	public void draw( Graphics g ){
		try{
			img = ImageIO.read(new File("src/images/"+name+"_player.png"));
		}catch(IOException e){
			System.out.println(e);
		}
		g.drawImage(img,  x,  y,  null);
		//g.setColor(Color.BLACK);
		//g.fillRect(x, y, 5, 5);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

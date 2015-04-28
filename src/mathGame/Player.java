package mathGame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
			img = ImageIO.read(getClass().getResource("/images/"+name+"_player.png"));
		}catch(IOException e){
			System.out.println(e);
		}
		g.drawImage(img,  x,  y,  null);
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

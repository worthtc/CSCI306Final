package mathGame;
import java.awt.Color;
import java.awt.Graphics;


public class Player {
	private int x;
	private int y;
	private String name;
	
	public Player(int x, int y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}
	public void draw( Graphics g ){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 5, 5);
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

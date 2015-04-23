package mathGame;

public class DisplayPanel {
	private Target currentTarget;
	private Missile currentMissile;
	private Player currentPlayer;
	private double angle;

	public DisplayPanel(Missile currentMissile, Player currentPlayer, Target currentTarget) {
		this.currentTarget = currentTarget;
		this.currentMissile = currentMissile;
		this.currentPlayer = currentPlayer;
		//printValues();
	}
	public Target getCurrentTarget() {
		return currentTarget;
	}
	public void setCurrentTarget(Target currentTarget) {
		this.currentTarget = currentTarget;
	}
	public Missile getCurrentMissile() {
		return currentMissile;
	}
	public void setCurrentMissile(Missile currentMissile) {
		this.currentMissile = currentMissile;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	/*
	public void printValues(){
		System.out.println(currentTarget.getName());
		System.out.println(currentMissile.getName());
		System.out.println(currentPlayer.getName());
		System.out.println(angle);
	}*/
	
}

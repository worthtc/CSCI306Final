package mathGame;

@SuppressWarnings("serial")
public class BadConfigFormatException extends Exception {
	
	public BadConfigFormatException(String error){
		super(error);
	}
	
	public String toString(){
		return getMessage();
	}
}

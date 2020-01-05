package database;

public class FormatException extends Exception {
	int error;
	public FormatException(String message,int errorPlace) {
        super(message);
        error=errorPlace;
    }
}

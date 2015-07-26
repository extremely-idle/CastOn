package impl.convert.excp;

public class InvalidArgumentException extends Exception {
	
	public InvalidArgumentException(String message){
		super(message);
	}
	
	public InvalidArgumentException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	public InvalidArgumentException(Throwable throwable){
		super(throwable);
	}
}

package net.rossmoug.cast_on.impl.convert.excp;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class InvalidArgumentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8737525853640498568L;

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

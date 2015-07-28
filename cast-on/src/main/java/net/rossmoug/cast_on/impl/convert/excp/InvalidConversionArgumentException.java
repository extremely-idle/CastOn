package net.rossmoug.cast_on.impl.convert.excp;

/**
 * An Exception which will be thrown by the application when invalid parameters
 * are given to the pattern converter.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class InvalidConversionArgumentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8737525853640498568L;

	/**
	 * 
	 * @param message
	 */
	public InvalidConversionArgumentException(String message){
		super(message);
	}
	
	/**
	 * 
	 * @param message
	 * @param throwable
	 */
	public InvalidConversionArgumentException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	/**
	 * 
	 * @param throwable
	 */
	public InvalidConversionArgumentException(Throwable throwable){
		super(throwable);
	}
}

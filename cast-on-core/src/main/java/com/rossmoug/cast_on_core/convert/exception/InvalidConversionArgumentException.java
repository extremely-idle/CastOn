package com.rossmoug.cast_on_core.convert.exception;

/**
 *
 */
public class InvalidConversionArgumentException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    /**
     *
     * @param string
     */
	public InvalidConversionArgumentException(String string) {
		super(string);
	}

}
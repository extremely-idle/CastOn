package com.rossmoug.cast_on_core.convert.exception;

/**
 * An exception flagging that invalid values were encountered during pattern conversion.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class InvalidConversionArgumentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidConversionArgumentException(String string) {
        super(string);
    }

}
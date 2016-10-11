package com.rossmoug.cast_on.convert;

import com.rossmoug.cast_on.state.pattern.IPattern;

/**
 * Pattern Conversion Engine.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface IPatternConverter {

	/**
	 * 
	 * @param pattern
	 * @param conversionInput
	 * @return
	 */
	public IConversionResult convertPattern(IPattern pattern, IConversionInput conversionInput);
}

package net.rossmoug.cast_on.impl.convert;

import net.rossmoug.cast_on.impl.state.IPattern;

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

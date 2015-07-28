package net.rossmoug.cast_on.impl.convert;

import net.rossmoug.cast_on.impl.state.IPattern;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
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

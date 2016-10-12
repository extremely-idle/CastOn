package com.rossmoug.cast_on.convert;

import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on.state.gauge.IGauge;
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
	 * @throws InvalidConversionArgumentException 
	 */
	public IPattern convertPattern(IPattern pattern, IGauge gauge) throws InvalidConversionArgumentException;
}

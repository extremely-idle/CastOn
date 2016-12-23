package com.rossmoug.cast_on_core.convert;

import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.pattern.IPattern;

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
	IPattern convertPattern(IPattern pattern, IGauge gauge) throws InvalidConversionArgumentException;
}

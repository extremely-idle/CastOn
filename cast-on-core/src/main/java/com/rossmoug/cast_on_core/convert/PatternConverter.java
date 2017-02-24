package com.rossmoug.cast_on_core.convert;

import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;

/**
 * Pattern Conversion Engine.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface PatternConverter {

	/**
	 *
	 * @param pattern
	 * @param gauge
	 * @return
	 * @throws InvalidConversionArgumentException
	 */
	Pattern convertPattern(Pattern pattern, Gauge gauge) throws InvalidConversionArgumentException;
}
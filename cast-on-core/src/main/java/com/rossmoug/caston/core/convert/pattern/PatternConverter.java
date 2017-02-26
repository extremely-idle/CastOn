package com.rossmoug.caston.core.convert.pattern;

import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;

/**
 * An abstraction which provides methods to implement a pattern conversion engine.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface PatternConverter {

    /**
     * Converts the pattern with respect to the withGauge provided by the user.
     *
     * @param pattern
     *         the base pattern, that must be converted
     * @param gauge
     *         the withGauge used by the user, this is used as a basis to convert the base pattern
     * @return the converted pattern
     * @throws InvalidConversionArgumentException an exception is thrown if the conversion arguments are invalid
     */
    Pattern convertPattern(Pattern pattern, Gauge gauge) throws InvalidConversionArgumentException;
}
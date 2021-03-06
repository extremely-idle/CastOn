package com.rossmoug.caston.core.convert.converter;

import com.rossmoug.caston.core.convert.converter.Converter;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;

/**
 * A representation of a builder which is used during converter creation.
 *
 * <b>Note</b> - this interface allows implementing classes to follow the <i>builder</i> pattern.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface ConverterFactory<C extends Converter> {

    /**
     * Create a new converter based on the given input parameters.
     *
     * @param pattern
     *         the base pattern
     * @param gauge
     *         the withGauge to be during pattern conversion
     * @return a converter object
     */
    C create(Pattern pattern, Gauge gauge);
}

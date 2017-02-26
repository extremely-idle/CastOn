package com.rossmoug.caston.core.convert.row.factory;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;
import com.rossmoug.caston.core.convert.row.RowConverter;
import com.rossmoug.caston.core.util.ConverterFactory;

/**
 * A representation of a factory which is used to create row converter objects.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class RowConverterFactory implements ConverterFactory<RowConverter> {

    /**
     * Create a new row converter based on the given input parameters.
     *
     * @param pattern
     *         the base pattern
     * @param gauge
     *         the withGauge to be during pattern conversion
     * @return a row converter object
     */
    @Override
    public RowConverter create(Pattern pattern, Gauge gauge) {
        final RowConverter rowConverter = new RowConverter();
        rowConverter.setBasePattern(pattern);
        rowConverter.setGauge(gauge);

        return rowConverter;
    }
}
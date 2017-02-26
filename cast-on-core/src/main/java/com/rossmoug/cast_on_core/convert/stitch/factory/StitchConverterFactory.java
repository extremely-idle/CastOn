package com.rossmoug.cast_on_core.convert.stitch.factory;

import com.rossmoug.cast_on_core.convert.stitch.StitchConverter;
import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;
import com.rossmoug.cast_on_core.util.ConverterFactory;

/**
 * A representation of a factory which is used to create stitch converter objects.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class StitchConverterFactory implements ConverterFactory<StitchConverter> {

    /**
     * Create a new stitch converter based on the given input parameters.
     *
     * @param pattern
     *         the base pattern
     * @param gauge
     *         the withGauge to be during pattern conversion
     * @return a stitch converter object
     */
    @Override
    public StitchConverter create(Pattern pattern, Gauge gauge) {
        final StitchConverter stitchConverter = new StitchConverter();
        stitchConverter.setBasePattern(pattern);
        stitchConverter.setGauge(gauge);

        return stitchConverter;
    }
}

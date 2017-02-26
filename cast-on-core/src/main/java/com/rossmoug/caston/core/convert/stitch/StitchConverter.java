package com.rossmoug.caston.core.convert.stitch;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.util.Converter;
import org.apache.log4j.Logger;

/**
 * A stitch converter to be used during pattern conversion. This class holds all stitch-specific methods which are
 * required to allow patterns to be converted.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class StitchConverter extends Converter {
    private static final Logger LOGGER = Logger.getLogger(StitchConverter.class);

    /**
     * Calculates and returns the number of stitches per withUnit.
     *
     * @param gauge
     *         the withGauge used in the calculation
     * @param dimension
     *         the size of the swatch
     * @return the number of stitches per withUnit
     */
    @Override
    public double calculateElementPerUnit(Gauge gauge, double dimension) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("calculateElementPerUnit(\n" + "  withGauge     => " + gauge + "\n" + " ,withDimension => " + dimension + "\n" + ")");
        }

        return gauge.getStitchCount() / dimension;
    }
}

package com.rossmoug.caston.core.convert.row;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.util.Converter;
import org.apache.log4j.Logger;

/**
 * A row converter to be used during pattern conversion. This class holds all row-specific methods which are required to
 * allow patterns to be converted.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class RowConverter extends Converter {

    private static final Logger LOGGER = Logger.getLogger(RowConverter.class);

    /**
     * Calculates and returns the number of rows per withUnit.
     *
     * @param gauge
     *         the withGauge used in the calculation
     * @param dimension
     *         the size of the swatch
     * @return the number of rows per withUnit
     */
    @Override
    public double calculateElementPerUnit(final Gauge gauge, final double dimension) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("calculateElementPerUnit(\n" + "  withGauge     => " + gauge + "\n" + " ,withDimension => " + dimension + "\n" + ")");
        }

        return gauge.getRowCount() / dimension;
    }

    /**
     * Retrieves the number of rows in the gauge.
     *
     * @param gauge
     *         the gauge used in the calculation
     * @return the number of rows in the gauge
     */
    @Override
    protected long retrieveGaugeElementCount(final Gauge gauge) {
        return gauge.getRowCount();
    }
}
package com.rossmoug.caston.core.util;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;

import org.apache.log4j.Logger;
import java.lang.Math;

/**
 * A representation of a converter which is used during pattern conversion.
 *
 * <b>Note</b> - this class follows the <i>template</i> pattern.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public abstract class Converter {

    private static final Logger LOGGER = Logger.getLogger(Converter.class);

    private Pattern basePattern;
    private Gauge gauge;

    /**
     * Calculates and returns the number of rows in the converted pattern based on the row count of the base pattern and
     * the row conversion factor.
     *
     * @return the number of rows in the converted pattern
     */
    public final long convert() {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("convert(\n" + "  pattern => " + basePattern + "\n" + " ,withGauge => " + gauge + "\n" + ")");
        }

        final double conversionFactor = calculateElementConversionFactor(basePattern, gauge);
        final long baseNumberOfOccurrences = gauge.getRowCount();
        final long convertedElementCount = Math.round(baseNumberOfOccurrences * conversionFactor);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("convertedRows => " + convertedElementCount);
        }

        return convertedElementCount;
    }

    /**
     * Calculates and returns the conversion factor to be used with respect to rows.
     *
     * @param pattern
     *         the pattern to be converted
     * @param gauge
     *         the withGauge that is to be used to convert the pattern
     * @return the row conversion factor
     */
    public final double calculateElementConversionFactor(final Pattern pattern, final Gauge gauge) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("calculateElementConversionFactor(\n" + "  pattern => " + pattern + "\nwithGauge => " + gauge + ")");
        }

        final double patternRowCountPerUnit = calculateElementPerUnit(pattern.getGauge(), pattern.getDimension());
        final double gaugeRowCountPerUnit = calculateElementPerUnit(gauge, pattern.getDimension());

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("rows/withUnit pattern => " + patternRowCountPerUnit + ", rows/withUnit user => " + gaugeRowCountPerUnit);
        }

        return gaugeRowCountPerUnit / patternRowCountPerUnit;
    }

    /**
     * Calculates and returns the number of elements per withUnit.
     *
     * @param gauge
     *         the withGauge used in the calculation
     * @param dimension
     *         the size of the swatch
     * @return the number of elements per withUnit
     */
    protected abstract double calculateElementPerUnit(final Gauge gauge, final double dimension);

    public final void setBasePattern(Pattern basePattern) {
        this.basePattern = basePattern;
    }

    public final void setGauge(Gauge gauge) {
        this.gauge = gauge;
    }
}
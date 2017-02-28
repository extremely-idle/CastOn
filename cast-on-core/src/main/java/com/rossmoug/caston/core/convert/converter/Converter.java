package com.rossmoug.caston.core.convert.converter;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;

import org.apache.log4j.Logger;

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
        final long numberOfElementOccurrencesInGauge = retrieveGaugeElementCount(gauge);
        final long convertedElementCount = Math.round(numberOfElementOccurrencesInGauge * conversionFactor);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("convert => " + convertedElementCount);
        }

        return convertedElementCount;
    }

    /**
     * Calculates and returns the conversion factor to be used with respect to rows.
     *
     * @param pattern
     *         the pattern to be converted
     * @param gauge
     *         the gauge that is to be used to convert the pattern
     * @return the row conversion factor
     */
    public final double calculateElementConversionFactor(final Pattern pattern, final Gauge gauge) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("calculateElementConversionFactor(\n" + "  pattern => " + pattern + "\ngauge => " + gauge + ")");
        }

        final double patternRowCountPerUnit = calculateElementPerUnit(pattern.getGauge(), pattern.getDimension());
        final double gaugeRowCountPerUnit = calculateElementPerUnit(gauge, pattern.getDimension());

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("rows/unit pattern => " + patternRowCountPerUnit + ", rows/unit user => " + gaugeRowCountPerUnit);
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
     * @return the number of elements per unit
     */
    protected abstract double calculateElementPerUnit(final Gauge gauge, final double dimension);

    /**
     * Retrieves the number of elements in the gauge.
     *
     * @param gauge
     *         the gauge used in the calculation
     * @return the number of elements in the gauge
     */
    protected abstract long retrieveGaugeElementCount(final Gauge gauge);

    public final void setBasePattern(Pattern basePattern) {
        this.basePattern = basePattern;
    }

    public final void setGauge(Gauge gauge) {
        this.gauge = gauge;
    }
}
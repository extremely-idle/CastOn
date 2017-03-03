package com.rossmoug.caston.core.convert.pattern.impl;

import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.convert.pattern.PatternConverter;
import com.rossmoug.caston.core.convert.converter.row.RowConverter;
import com.rossmoug.caston.core.convert.converter.row.factory.RowConverterFactory;
import com.rossmoug.caston.core.convert.converter.stitch.StitchConverter;
import com.rossmoug.caston.core.convert.converter.stitch.factory.StitchConverterFactory;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.gauge.builder.GaugeBuilder;
import com.rossmoug.caston.core.state.pattern.Pattern;
import com.rossmoug.caston.core.state.pattern.builder.PatternBuilder;
import com.rossmoug.caston.core.convert.converter.ConverterFactory;
import org.apache.log4j.Logger;

/**
 * A concrete implementation of a pattern conversion engine.
 * <p>
 * <b>Note</b> - this class follows the <i>singleton</i> pattern.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.3
 */
public class PatternConverterImpl implements PatternConverter {

    private static final Logger LOGGER = Logger.getLogger(PatternConverter.class);

    private static PatternConverter instance;

    private PatternConverterImpl() {
    }

    /**
     * Retrieve the singleton object for this class, if this has not yet been initialised then create it and return it.
     *
     * @return the singleton object
     */
    public static PatternConverter getInstance() {
        synchronized (PatternConverterImpl.class) {
            if (instance == null) {
                instance = new PatternConverterImpl();
            }
        }

        return instance;
    }

    /**
     * Convert the given pattern with respect to the withGauge provided, this withGauge is the withGauge used when
     * creating a swatch.
     *
     * @param pattern
     *         the pattern to be converted
     * @param gauge
     *         the withGauge to be used during conversion
     * @return the converted pattern
     * @throws InvalidConversionArgumentException
     *         an exception is thrown if the conversion arguments are invalid
     */
    @Override
    public Pattern convertPattern(final Pattern pattern, final Gauge gauge) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("convertPattern(\n" + "  factor => " + pattern + "\n" + " ,withStitchCount => " + gauge + "\n" + ")");
        }

        final long convertedRowCount = convertRows(pattern, gauge);
        final long convertedStitchCount = convertStitches(pattern, gauge);

        final Pattern convertedPattern = buildConvertedPattern(pattern, gauge, convertedRowCount, convertedStitchCount);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("rows => " + convertedPattern.getGauge().getRowCount());
            LOGGER.debug("stitches => " + convertedPattern.getGauge().getStitchCount());
        }

        return convertedPattern;
    }

    /**
     * Convert the number of stitches listed in the pattern with respect to the withGauge.
     *
     * @param pattern
     *         the pattern to be converted
     * @param gauge
     *         the withGauge to be used during conversion
     * @return the converted number of stitches
     */
    private long convertStitches(final Pattern pattern, final Gauge gauge) {
        final ConverterFactory<StitchConverter> stitchConverterFactory = new StitchConverterFactory();
        final StitchConverter stitchConverter = stitchConverterFactory.create(pattern, gauge);

        return stitchConverter.convert();
    }

    /**
     * Convert the number of rows listed in the pattern with respect to the withGauge.
     *
     * @param pattern
     *         the pattern to be converted
     * @param gauge
     *         the withGauge to be used during conversion
     * @return the converted number of rows
     */
    private long convertRows(final Pattern pattern, final Gauge gauge) {
        final ConverterFactory<RowConverter> rowConverterFactory = new RowConverterFactory();
        final RowConverter rowConverter = rowConverterFactory.create(pattern, gauge);

        return rowConverter.convert();
    }

    /**
     * Create the new converted pattern.
     *
     * @param pattern
     *         the base pattern
     * @param gauge
     *         the withGauge used during conversion
     * @param convertedRowCount
     *         the converted number of rows to be used
     * @param convertedStitchCount
     *         the converted number of stitches to be used
     * @return the converted pattern
     */
    private Pattern buildConvertedPattern(final Pattern pattern, final Gauge gauge, final long convertedRowCount, final long convertedStitchCount) {
        final PatternBuilder patternBuilder = new PatternBuilder();
        final GaugeBuilder gaugeBuilder = new GaugeBuilder();

        final Gauge convertedGauge = gaugeBuilder.withRowCount(convertedRowCount).withStitchCount(convertedStitchCount).withUnit(gauge.getUnit()).build();
        final Pattern convertedPattern = patternBuilder.withGauge(convertedGauge).withDimension(pattern.getDimension()).build();

        return convertedPattern;
    }
}
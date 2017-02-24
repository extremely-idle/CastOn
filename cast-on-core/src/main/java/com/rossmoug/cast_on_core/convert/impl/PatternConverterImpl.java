package com.rossmoug.cast_on_core.convert.impl;

import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;
import org.apache.log4j.Logger;

import com.rossmoug.cast_on_core.convert.PatternConverter;
import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.state.gauge.builder.GaugeBuilder;
import com.rossmoug.cast_on_core.state.pattern.builder.PatternBuilder;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class PatternConverterImpl implements PatternConverter {

	private static final Logger LOGGER = Logger.getLogger(PatternConverter.class);
	private static PatternConverter instance;

	private PatternConverterImpl() {}

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */

    private double calcualteRowsPerUnit(final Gauge gauge, final double dimension) {
		LOGGER.trace("calculateRowsPerUnit(\n" + "  gauge     => " + gauge + "\n" + " ,dimension => " + dimension + "\n" + ")");

		return gauge.getRowCount() / dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double calculateRowConversionFactor(final Pattern pattern, final Gauge gauge) {
		LOGGER.trace("calculateRowConversionFactor(\n" + "  pattern => " + pattern + "\ngauge => " + gauge + ")");

		final double patternRowCountPerUnit = calcualteRowsPerUnit(pattern.getGauge(), pattern.getDimension());
		final double gaugeRowCountPerUnit = calcualteRowsPerUnit(gauge, pattern.getDimension());

		LOGGER.debug("rows/unit pattern => " + patternRowCountPerUnit + ", rows/unit user => " + gaugeRowCountPerUnit);

		return gaugeRowCountPerUnit / patternRowCountPerUnit;
	}

    /**
	 * 
	 * @param factor
	 * @param rowCount
	 * @return
	 */
	private long calculateConvertedRowCount(final double factor, final long rowCount) {
		LOGGER.trace("calculateConvertedRowCount(\n" + "  factor => " + factor + "\n" + " ,rowCount => " + rowCount + "\n" + ")");

		final long convertedRowCount = Math.round(rowCount * factor);

		LOGGER.debug("convertedRows => " + convertedRowCount);

		return convertedRowCount;
	}

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double calculateStitchesPerUnit(final Gauge gauge, final double dimension) {
		LOGGER.trace("calculateStitchesPerUnit(\n" + "  gauge => " + gauge + "\n" + " ,dimension => " + dimension + "\n" + ")");

		return gauge.getStitchCount() / dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double calculateStitchConversionFactor(final Pattern pattern, final Gauge gauge) {
		LOGGER.trace("calculateStitchConversionFactor(\n" + "  pattern => " + pattern.toString() + "\n" + ")");

		final double patternStitchesPerUnit = calculateStitchesPerUnit(pattern.getGauge(), pattern.getDimension());
		final double gaugeStitchesPerUnit = calculateStitchesPerUnit(gauge, pattern.getDimension());

		LOGGER.debug("stitches/unit pattern => " + patternStitchesPerUnit + ", stitches/unit user => " + gaugeStitchesPerUnit);

		return gaugeStitchesPerUnit / patternStitchesPerUnit;
	}

	/**
	 * 
	 * @param factor
	 * @param stitchCount
	 * @return
	 */
	private long calculateConvertedStitchCount(final double factor, final long stitchCount) {
		LOGGER.trace("calculateConvertedStitchCount(\n" + "  factor => " + factor + "\n" + " ,stitchCount => " + stitchCount + "\n" + ")");

		final long convertedStitchCount = Math.round(stitchCount * factor);

		LOGGER.debug("convertedStitches => " + convertedStitchCount);

		return convertedStitchCount;
	}

	/**
	 * 
	 * @param pattern
	 * @param gauge
	 * @throws InvalidConversionArgumentException
	 */
	public Pattern convertPattern(final Pattern pattern, final Gauge gauge) throws InvalidConversionArgumentException {
		LOGGER.trace("convertPattern(\n" + "  factor => " + pattern + "\n" + " ,stitchCount => " + gauge + "\n" + ")");

        final PatternBuilder patternBuilder = new PatternBuilder();
        final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final long convertedRowCount = calculateConvertedRowCount(calculateRowConversionFactor(pattern, gauge), gauge.getRowCount());
		final long convertedStitchCount = calculateConvertedStitchCount(calculateStitchConversionFactor(pattern, gauge), gauge.getStitchCount());

		final Gauge convertedGauge = gaugeBuilder.rowCount(convertedRowCount).stitchCount(convertedStitchCount).unit(gauge.getUnit()).build();
		final Pattern convertedPattern = patternBuilder.gauge(convertedGauge).dimension(pattern.getDimension()).build();

		LOGGER.debug("rows => " + convertedPattern.getGauge().getRowCount());
		LOGGER.debug("stitches => " + convertedPattern.getGauge().getStitchCount());

		return convertedPattern;
	}

    /**
     *
     * @return
     */
	public static PatternConverter getInstance() {
		if (instance == null) {
			synchronized (PatternConverterImpl.class) {
				if (instance == null) {
					instance = new PatternConverterImpl();
				}
			}
		}

		return instance;
	}
}
package com.rossmoug.cast_on.convert.impl;

import org.apache.log4j.Logger;

import com.rossmoug.cast_on.convert.IPatternConverter;
import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.gauge.impl.Gauge;
import com.rossmoug.cast_on.state.pattern.IPattern;
import com.rossmoug.cast_on.state.pattern.builder.PatternBuilder;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class PatternConverter implements IPatternConverter {

	private static final Logger logger = Logger.getLogger(PatternConverter.class);

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double rowsPerUnit(IGauge gauge, double dimension) {
		logger.trace("rowsPerUnit(\n" + "  gauge     => " + gauge + "\n" + " ,dimension => " + dimension
				+ "\n" + ")");

		return gauge.getRowCount() / dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double rowConversionFactor(IPattern pattern, IGauge gauge) {
		logger.trace("rowConversionFactor(\n" + "  pattern => " + pattern + "\ngauge => " + gauge + ")");

		logger.info("rows/unit pattern => " + rowsPerUnit(pattern.getGauge(), pattern.getDimension()));
		logger.info("rows/unit user => " + rowsPerUnit(gauge, pattern.getDimension()));

		return rowsPerUnit(gauge, pattern.getDimension())
				/ rowsPerUnit(pattern.getGauge(), pattern.getDimension());
	}

	/**
	 * 
	 * @param factor
	 * @param rowCount
	 * @return
	 */
	private int convertRows(double factor, int rowCount) {
		logger.trace("convertRows(\n" + "  factor => " + factor + "\n" + " ,rowCount => " + rowCount + "\n" + ")");
		logger.debug("convertedRows => " + Math.round(rowCount * factor));

		return (int) Math.round(rowCount * factor);
	}

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double stitchesPerUnit(IGauge gauge, double dimension) {
		logger.trace("stitchesPerUnit(\n" + "  gauge => " + gauge + "\n" + " ,dimension => " + dimension
				+ "\n" + ")");

		return gauge.getStitchCount() / dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double stitchConversionFactor(IPattern pattern, IGauge gauge) {
		logger.trace("stitchConversionFactor(\n" + "  pattern => " + pattern.toString() + "\n" + ")");

		return stitchesPerUnit(gauge, pattern.getDimension())
				/ stitchesPerUnit(pattern.getGauge(), pattern.getDimension());
	}

	/**
	 * 
	 * @param factor
	 * @param stitchCount
	 * @return
	 */
	private int convertStitch(double factor, int stitchCount) {
		logger.trace("convertStitch(\n" + "  factor => " + factor + "\n" + " ,stitchCount => " + stitchCount
				+ "\n" + ")");

		return (int) Math.round(stitchCount * factor);
	}

	/**
	 * 
	 * @param pattern
	 * @param conversionInput
	 * @throws InvalidConversionArgumentException 
	 */
	public IPattern convertPattern(IPattern pattern, IGauge gauge) throws InvalidConversionArgumentException {
		logger.trace("convertPattern(\n" + "  factor => " + pattern + "\n" + " ,stitchCount => " + gauge
				+ "\n" + ")");

		PatternBuilder builder = new PatternBuilder();

		int convertedRowCount = convertRows(rowConversionFactor(pattern, gauge), gauge.getRowCount());
		int convertedStitchCount = convertStitch(stitchConversionFactor(pattern, gauge), gauge.getStitchCount());

		IGauge convertedGauge = new Gauge(convertedRowCount, convertedStitchCount, gauge.getUnit());
		IPattern convertedPattern = builder.patternGauge(convertedGauge).dimension(pattern.getDimension()).build();

		logger.debug("rows => " + convertedPattern.getGauge().getRowCount());
		logger.debug("stitches => " + convertedPattern.getGauge().getStitchCount());

		return convertedPattern;
	}

}

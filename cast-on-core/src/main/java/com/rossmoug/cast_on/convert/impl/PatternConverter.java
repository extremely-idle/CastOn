package com.rossmoug.cast_on.convert.impl;

import org.apache.log4j.Logger;

import com.rossmoug.cast_on.convert.IConversionInput;
import com.rossmoug.cast_on.convert.IConversionResult;
import com.rossmoug.cast_on.convert.IPatternConverter;
import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.pattern.IPattern;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class PatternConverter implements IPatternConverter {

	static Logger logger = Logger.getLogger(PatternConverter.class);

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double rowsPerUnit(IGauge gauge, double dimension) {
		logger.trace("rowsPerUnit(\n" + "  gauge     => " + gauge.toString() + "\n" + " ,dimension => " + dimension
				+ "\n" + ")");
		return gauge.getRowCount() / dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double rowConversionFactor(IPattern pattern) {
		logger.trace("rowConversionFactor(\n" + "  pattern => " + pattern.toString() + "\n" + ")");

		logger.info("rows/unit pattern => " + rowsPerUnit(pattern.getPatternGauge(), pattern.getDimension()));
		logger.info("rows/unit user => " + rowsPerUnit(pattern.getUserGauge(), pattern.getDimension()));

		return rowsPerUnit(pattern.getUserGauge(), pattern.getDimension())
				/ rowsPerUnit(pattern.getPatternGauge(), pattern.getDimension());
	}

	/**
	 * 
	 * @param factor
	 * @param rowCount
	 * @return
	 */
	private double convertRows(double factor, int rowCount) {
		logger.trace("convertRows(\n" + "  factor => " + factor + "\n" + " ,rowCount => " + rowCount + "\n" + ")");

		logger.debug("convertedRows => " + Math.round(rowCount * factor));

		return Math.round(rowCount * factor);
	}

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double stitchesPerUnit(IGauge gauge, double dimension) {
		logger.trace("stitchesPerUnit(\n" + "  gauge => " + gauge.toString() + "\n" + " ,dimension => " + dimension
				+ "\n" + ")");
		return gauge.getStitchCount() / dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double stitchConversionFactor(IPattern pattern) {
		logger.trace("stitchConversionFactor(\n" + "  pattern => " + pattern.toString() + "\n" + ")");

		return stitchesPerUnit(pattern.getUserGauge(), pattern.getDimension())
				/ stitchesPerUnit(pattern.getPatternGauge(), pattern.getDimension());
	}

	/**
	 * 
	 * @param factor
	 * @param stitchCount
	 * @return
	 */
	private double convertStitch(double factor, int stitchCount) {
		logger.trace("stitchConversionFactor(\n" + "  factor => " + factor + "\n" + " ,stitchCount => " + stitchCount
				+ "\n" + ")");
		return Math.round(stitchCount * factor);
	}

	/**
	 * 
	 * @param pattern
	 * @param conversionInput
	 */
	public IConversionResult convertPattern(IPattern pattern, IConversionInput conversionInput) {
		logger.trace("convertPattern(\n" + "  factor => " + pattern.toString() + "\n" + " ,stitchCount => " + conversionInput.toString()
				+ "\n" + ")");
		IConversionResult result = new ConversionResult();

		result.setConvertedRowCount(convertRows(rowConversionFactor(pattern), conversionInput.getInputRowCount()));
		result.setConvertedStitchCount(
				convertStitch(stitchConversionFactor(pattern), conversionInput.getInputStitchCount()));

		logger.debug("rows => " + result.getConvertedRowCount());
		logger.debug("stitches => " + result.getConvertedStitchCount());

		return result;
	}

}

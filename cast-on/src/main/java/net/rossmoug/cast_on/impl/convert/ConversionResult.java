package net.rossmoug.cast_on.impl.convert;

/**
 * Class representing the output from the Pattern Conversion Engine
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class ConversionResult implements IConversionResult {

	private double rowCount;
	private double stitchCount;
	
	
	/**
	 * The converted row count which can be used.
	 * 
	 * @return a double value representing the converted row count
	 */
	public double getConvertedRowCount() {
		return rowCount;
	}

	
	/**
	 * 
	 * @param
	 */
	public void setConvertedRowCount(double convertedRowCount) {
		this.rowCount = convertedRowCount;
	}

	
	/**
	 * The converted stitch count which can be used.
	 * 
	 * @return a double value representing the converted stitch count
	 */
	public double getConvertedStitchCount() {
		return stitchCount;
	}

	
	/**
	 * 
	 * @param 
	 */
	public void setConvertedStitchCount(double convertedStitchCount) {
		this.stitchCount = convertedStitchCount;
	}

}

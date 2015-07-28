package net.rossmoug.cast_on.impl.convert;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class ConversionResult implements IConversionResult {

	private double rowCount;
	private double stitchCount;
	
	
	/**
	 * 
	 * @return
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
	 * 
	 * @return
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

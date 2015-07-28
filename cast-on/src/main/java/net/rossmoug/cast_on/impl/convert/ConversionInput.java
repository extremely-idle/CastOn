package net.rossmoug.cast_on.impl.convert;

import net.rossmoug.cast_on.impl.convert.excp.InvalidConversionArgumentException;

/**
 * Input parameters to the Pattern Conversion Engine.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class ConversionInput implements IConversionInput {

	private static final int POSITIVE_VALUE = 1;
	
	private int rowCount;
	private int stitchCount;

	/**
	 * Standard constructor, performs a check to ensure that the row and stitch counts
	 * are positive (so not zero or negative). An exception will be thrown when this
	 * is not the case.
	 * 
	 * @param rowCount
	 * @param stitchCount
	 * @throws InvalidConversionArgumentException
	 */
	public ConversionInput(int rowCount, int stitchCount) throws InvalidConversionArgumentException{
		if (Math.signum(rowCount) != POSITIVE_VALUE || Math.signum(stitchCount) != POSITIVE_VALUE){
			throw new InvalidConversionArgumentException("Row and stitch count can not be zero or negative.");
		}

		this.rowCount = rowCount;
		this.stitchCount = stitchCount;
	}
	
	
	/**
	 * Retrieve the row count
	 * 
	 * @return integer value representing the row count input parameter
	 */
	public int getInputRowCount() {
		return rowCount;
	}

	
	/**
	 * Retrieve the stitch count
	 * 
	 * @return integer value representing the stitch count input parameter
	 */
	public int getInputStitchCount() {
		return stitchCount;
	}

}

package com.rossmoug.cast_on.convert.impl;

import com.rossmoug.cast_on.convert.IConversionInput;
import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;

/**
 * Input parameters to the Pattern Conversion Engine.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rowCount;
		result = prime * result + stitchCount;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConversionInput other = (ConversionInput) obj;
		if (rowCount != other.rowCount)
			return false;
		if (stitchCount != other.stitchCount)
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConversionInput [rowCount=" + rowCount + ", stitchCount=" + stitchCount + "]";
	}

}

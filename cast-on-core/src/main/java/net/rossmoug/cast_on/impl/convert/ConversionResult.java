package net.rossmoug.cast_on.impl.convert;

/**
 * Class representing the output from the Pattern Conversion Engine
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(rowCount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stitchCount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ConversionResult other = (ConversionResult) obj;
		if (Double.doubleToLongBits(rowCount) != Double.doubleToLongBits(other.rowCount))
			return false;
		if (Double.doubleToLongBits(stitchCount) != Double.doubleToLongBits(other.stitchCount))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConversionResult [rowCount=" + rowCount + ", stitchCount=" + stitchCount + "]";
	}

}

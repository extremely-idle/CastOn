package com.rossmoug.cast_on.impl.state;

import net.rossmoug.cast_on.impl.convert.excp.InvalidConversionArgumentException;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class Gauge implements IGauge {

	private static final float POSITIVE_VALUE = 1;

	private int rowCount;
	private int stitchCount;
	private Unit unit;
	
	/**
	 * 
	 * @param rowCount
	 * @param stitchCount
	 * @param unit
	 * @throws InvalidConversionArgumentException 
	 */
	public Gauge(int rowCount, int stitchCount, Unit unit) throws InvalidConversionArgumentException{
		if (Math.signum(rowCount) != POSITIVE_VALUE || Math.signum(stitchCount) != POSITIVE_VALUE){
			throw new InvalidConversionArgumentException("Row and stitch count can not be zero or negative.");
		} else if (unit == null) {
			throw new InvalidConversionArgumentException("Unit must be provided.");
		}

		this.rowCount = rowCount;
		this.stitchCount = stitchCount;
		this.unit = unit;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int getRowCount() {
		return rowCount;
	}

	
	/**
	 * 
	 * @return
	 */
	public int getStitchCount() {
		return stitchCount;
	}

	
	/**
	 * 
	 * @return
	 */
	public Unit getUnit() {
		return unit;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gauge [rowCount=" + rowCount + ", stitchCount=" + stitchCount + ", unit=" + unit + "]";
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
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Gauge other = (Gauge) obj;
		if (rowCount != other.rowCount)
			return false;
		if (stitchCount != other.stitchCount)
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}

}

package net.rossmoug.cast_on.impl.state;

import net.rossmoug.cast_on.impl.convert.excp.InvalidConversionArgumentException;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
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

}

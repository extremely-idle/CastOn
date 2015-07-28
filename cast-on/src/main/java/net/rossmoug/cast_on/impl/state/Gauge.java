package net.rossmoug.cast_on.impl.state;

import net.rossmoug.cast_on.impl.convert.excp.InvalidArgumentException;

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
	 * @throws InvalidArgumentException 
	 */
	public Gauge(int rowCount, int stitchCount, Unit unit) throws InvalidArgumentException{
		if (Math.signum(rowCount) != POSITIVE_VALUE || Math.signum(stitchCount) != POSITIVE_VALUE){
			throw new InvalidArgumentException("Row and stitch count can not be zero or negative.");
		} else if (unit == null) {
			throw new InvalidArgumentException("Unit must be provided.");
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

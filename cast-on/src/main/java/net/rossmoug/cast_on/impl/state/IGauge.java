package net.rossmoug.cast_on.impl.state;

/**
 * The representation of a gauge used in knitting.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface IGauge {

	/**
	 * Retrieve the number of rows within the gauge.
	 * 
	 * @return integer value representing the number of rows.
	 */
	public int getRowCount();
	
	/**
	 * Retrieve the number of stitches within the gauge.
	 * 
	 * @return integer value representing the number of stitches.
	 */
	public int getStitchCount();
	
	/**
	 * Retrieve the unit of measurement used to create this gauge.
	 * 
	 * @return a Unit value
	 */
	public Unit getUnit();
}

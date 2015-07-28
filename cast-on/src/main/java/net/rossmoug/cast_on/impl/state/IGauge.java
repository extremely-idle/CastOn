package net.rossmoug.cast_on.impl.state;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public interface IGauge {

	/**
	 * 
	 * @return
	 */
	public int getRowCount();
	
	/**
	 * 
	 * 
	 * @return
	 */
	public int getStitchCount();
	
	/**
	 * 
	 * @return
	 */
	public Unit getUnit();
}

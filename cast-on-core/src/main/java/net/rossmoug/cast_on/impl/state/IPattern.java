package net.rossmoug.cast_on.impl.state;

/**
 * A representation of a knitting pattern.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface IPattern {

	/**
	 * 
	 * @return
	 */
	public IGauge getUserGauge();
	
	/**
	 * 
	 * @return
	 */
	public IGauge getPatternGauge();
	
	/**
	 * 
	 * @return
	 */
	public double getDimension();
}

package net.rossmoug.cast_on.impl.state;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
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

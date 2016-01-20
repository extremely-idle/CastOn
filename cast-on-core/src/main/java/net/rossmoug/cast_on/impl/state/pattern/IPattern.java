package net.rossmoug.cast_on.impl.state.pattern;

import net.rossmoug.cast_on.impl.db.Mappable;
import net.rossmoug.cast_on.impl.state.IGauge;
import net.rossmoug.cast_on.impl.state.Persistable;

/**
 * A representation of a knitting pattern.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface IPattern extends Mappable, Persistable {

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

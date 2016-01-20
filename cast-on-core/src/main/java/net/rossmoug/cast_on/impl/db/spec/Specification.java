package net.rossmoug.cast_on.impl.db.spec;

import net.rossmoug.cast_on.impl.state.Persistable;

/**
 * 
 * @author Ross
 */
public interface Specification {

	/**
	 * 
	 * @param object
	 * @return
	 */
	boolean isSpecified(Persistable object);
}

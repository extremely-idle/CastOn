package net.rossmoug.cast_on.impl.db.pattern;

import javax.sql.DataSource;

import net.rossmoug.cast_on.impl.db.Repository;
import net.rossmoug.cast_on.impl.db.RepositoryFactory;

/**
 * Factory Sub-class which is decdicated to creating PatternRepository objects. 
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class PatternRepositoryFactory extends RepositoryFactory {

	@Override
	/**
	 * 
	 */
	protected Repository createRepository(DataSource datasource) {
		return new PatternRepository(datasource);
	}

}

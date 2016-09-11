package com.rossmoug.cast_on.impl.db;

import javax.sql.DataSource;

/**
 * Factory to create repositories.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public abstract class RepositoryFactory {

	/**
	 * 
	 * @return
	 */
	abstract protected Repository createRepository(DataSource datasource);
}

package net.rossmoug.cast_on.impl.db.user;

import javax.sql.DataSource;

import net.rossmoug.cast_on.impl.db.Repository;
import net.rossmoug.cast_on.impl.db.RepositoryFactory;

/**
 * Factory Sub-class which is decdicated to creating UserRepository objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class UserRepositoryFactory extends RepositoryFactory {

	@Override
	/**
	 * 
	 */
	protected Repository createRepository(DataSource datasource) {
		return new UserRepository(datasource);
	}
}

package com.rossmoug.cast_on.impl.db;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import net.rossmoug.cast_on.impl.db.spec.Specification;
import net.rossmoug.cast_on.impl.state.Persistable;

/**
 * Abstract representation of a repository as per the Repository pattern. The
 * sub-classes of this abstract class must provide CRUD operations and the ability
 * to query the underlying DB data for the given object type.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public abstract class Repository {

	protected DataSource datasource;
	
	public Repository(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public abstract void addObject(Persistable obj);

	public abstract void removeObject(Persistable obj);

	public abstract void updateObject(Persistable obj);

	public abstract List<Mappable> query(Specification specification);

}

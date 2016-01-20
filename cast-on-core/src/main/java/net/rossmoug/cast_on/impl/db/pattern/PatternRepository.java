package net.rossmoug.cast_on.impl.db.pattern;

import java.util.List;

import javax.sql.DataSource;

import net.rossmoug.cast_on.impl.db.Mappable;
import net.rossmoug.cast_on.impl.db.Repository;
import net.rossmoug.cast_on.impl.db.spec.Specification;
import net.rossmoug.cast_on.impl.state.Persistable;

/**
 * Repository to access and amend data relating to Pattern objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class PatternRepository extends Repository {

	public PatternRepository(DataSource datasource) {
		super(datasource);
	}

	@Override
	/**
	 * 
	 */
	public void addObject(Persistable obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObject(Persistable obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObject(Persistable obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Mappable> query(Specification specification) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

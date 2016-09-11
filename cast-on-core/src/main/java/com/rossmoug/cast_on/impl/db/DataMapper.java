package com.rossmoug.cast_on.impl.db;

import java.sql.ResultSet;
import java.util.List;

/**
 * Generic representation of a data mapper, this must map data
 * from a result set to an application object.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public abstract class DataMapper {

	public abstract List<Mappable> map(ResultSet results);
}

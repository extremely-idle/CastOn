package net.rossmoug.cast_on.impl.db.spec;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

/**
 * 
 * @author Ross
 */
public interface SQLSpecification {

	/**
	 * 
	 * @return
	 */
	PreparedStatement toSQLClauses(DataSource datasource);
}

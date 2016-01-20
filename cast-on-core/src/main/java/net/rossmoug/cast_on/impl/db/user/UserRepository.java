package net.rossmoug.cast_on.impl.db.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.rossmoug.cast_on.impl.db.Mappable;
import net.rossmoug.cast_on.impl.db.Repository;
import net.rossmoug.cast_on.impl.db.spec.SQLSpecification;
import net.rossmoug.cast_on.impl.db.spec.Specification;
import net.rossmoug.cast_on.impl.state.Persistable;
import net.rossmoug.cast_on.impl.state.user.User;

/**
 * Repository to access and amend data relating to User objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class UserRepository extends Repository {

	public UserRepository(DataSource datasource) {
		super(datasource);
	}

	// TODO - refactor to remove dependence on DB vendor

	@Override
	/**
	 * 
	 */
	public synchronized void addObject(Persistable obj) {
		try {
			Connection conn = datasource.getConnection();
			
			String sql = "insert into user("
					   + "  user_id"
					   + " ,username"
					   + ") values ("
					   + "  ? -- user_id"
					   + " ,? -- username"
					   + ")"
			;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBigDecimal(1, ((User)obj).getUserID()); 
			stmt.setString(2, ((User)obj).getUsername());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 
	 */
	public synchronized void removeObject(Persistable obj) {
		try {
			Connection conn = datasource.getConnection();
			
			String sql = "delete from user"
					   + "where user_id = ?"
			;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBigDecimal(1, ((User)obj).getUserID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 
	 */
	public synchronized void updateObject(Persistable obj) {
		try {
			Connection conn = datasource.getConnection();
			
			String sql = "update user"
					   + "set   user_name = ?"
					   + "where user_id   = ?"
			;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBigDecimal(1, ((User)obj).getUserID());
			stmt.setString(2, ((User)obj).getUsername());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 
	 */
	public synchronized List<Mappable> query(Specification specification) {
		try {			
			PreparedStatement stmt = (PreparedStatement) (((SQLSpecification) (specification)).toSQLClauses(datasource));
			ResultSet results = stmt.executeQuery();
			new UserDataMapper().map(results);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

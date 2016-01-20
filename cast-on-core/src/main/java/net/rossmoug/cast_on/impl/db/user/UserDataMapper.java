package net.rossmoug.cast_on.impl.db.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.rossmoug.cast_on.impl.db.DataMapper;
import net.rossmoug.cast_on.impl.db.Mappable;
import net.rossmoug.cast_on.impl.state.user.UserBuilder;

/**
 * 
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class UserDataMapper extends DataMapper {

	@Override
	/**
	 * 
	 */
	public List<Mappable> map(ResultSet results) {
		List<Mappable> userList = new ArrayList<Mappable>();
		try {
			while (results.next()) {
				userList.add(new UserBuilder().userID(results.getBigDecimal("user_id"))
						.username(results.getNString("user_name")).build());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}

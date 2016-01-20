package net.rossmoug.cast_on.impl.state.user;

import java.math.BigDecimal;

import net.rossmoug.cast_on.impl.db.Mappable;
import net.rossmoug.cast_on.impl.state.Persistable;

public interface IUser extends Mappable, Persistable {

	/**
	 * @return the user_id
	 */
	public BigDecimal getUserID();

	/**
	 * @return the username
	 */
	public String getUsername();
}

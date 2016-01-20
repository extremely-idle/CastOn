package net.rossmoug.cast_on.impl.state.user;

import java.math.BigDecimal;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class User implements IUser {

	private BigDecimal userID;
	private String username;

	public User(UserBuilder builder){
		this.userID = builder.userID;
		this.username = builder.username;
	}
	
	@Override
	public BigDecimal getUserID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}

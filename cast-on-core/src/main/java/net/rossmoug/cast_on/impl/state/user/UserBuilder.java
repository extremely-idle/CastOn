package net.rossmoug.cast_on.impl.state.user;

import java.math.BigDecimal;

import net.rossmoug.cast_on.impl.state.pattern.Pattern;

/**
 * Builder for User objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see User
 */
public class UserBuilder {

    public BigDecimal userID;
    public String username;
	
    /**
     * 
     * @param userID
     * @return
     */
	public UserBuilder userID(BigDecimal userID){
		this.userID = userID;
		return this;
	}
	
    /**
     * 
     * @param username
     * @return
     */
	public UserBuilder username(String username){
		this.username = username;
		return this;
	}
	
    /**
     * 
     * @return
     */
	public User build(){
		return new User(this);
	}
}

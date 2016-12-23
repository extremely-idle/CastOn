package com.rossmoug.cast_on_core.command;

/**
 * 
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @param <E>
 */
public abstract class Command<E> {

	/**
	 * 
	 */
	protected abstract E execute();
}

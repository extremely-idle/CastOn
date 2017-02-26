package com.rossmoug.caston.core.command;

/**
 * Class representing a command that can be triggered with Cast-On.
 *
 * <b>Note</b> - this class is an implementation of the <i>command</i> pattern.
 *
 * @param <E>
 *         The object that the command will operate on
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 */
public abstract class Command<E> {

    /**
     * Carry out the command and return the result, if appropriate.
     *
     * @return the result object
     */
    protected abstract E execute();
}

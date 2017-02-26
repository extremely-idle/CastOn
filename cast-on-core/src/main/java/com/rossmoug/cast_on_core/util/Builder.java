package com.rossmoug.cast_on_core.util;

/**
 * A representation of an object which builds another.
 *
 * <b>Note</b> - this class follows the <i>builder</i> pattern.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public interface Builder<E> {

    /**
     * Create a new object.
     *
     * @return the built object
     */
    E build();

}

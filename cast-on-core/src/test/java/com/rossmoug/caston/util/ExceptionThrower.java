package com.rossmoug.caston.util;

/**
 * Test interface to assist with the testing of throwables.
 * <p>
 * <b>Note</b> - this was <b><u>not</u></b> created as a part of this project, all credit for this class go to Rafal
 * Borowiec.
 *
 * @see <a href = https://github.com/kolorobot/unit-testing-demo>Unit Testing Demo on GitHub</a>
 */
@FunctionalInterface
public interface ExceptionThrower {

    void throwException() throws Throwable;
}

package com.rossmoug.caston.util;

/**
 * Test interface to assist with the testing of throwables.
 * <p>
 * <b>Note</b> - this was <b><u>not</u></b> created as a part of this project, all credit for this class go to Rafal
 * Borowiec. Please see https://github.com/kolorobot/unit-testing-demo for more information.
 */
@FunctionalInterface
public interface ExceptionThrower {

    @SuppressWarnings("RedundantThrows")
    void throwException() throws Throwable;
}

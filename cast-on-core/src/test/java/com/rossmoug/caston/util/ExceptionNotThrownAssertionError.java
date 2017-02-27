package com.rossmoug.caston.util;

/**
 * Test exception to assist with the testing of throwables, this is thrown when a throwable is caught which is
 * unexpected.
 * <p>
 * <b>Note</b> - this was <b><u>not</u></b> created as a part of this project, all credit for this class go to Rafal
 * Borowiec. Please see https://github.com/kolorobot/unit-testing-demo for more information.
 */
class ExceptionNotThrownAssertionError extends AssertionError {

    public ExceptionNotThrownAssertionError() {
        super("Expected exception was not thrown.");
    }
}

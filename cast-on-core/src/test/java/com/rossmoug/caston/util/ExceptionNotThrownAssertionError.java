package com.rossmoug.caston.util;

/**
 * Test exception to assist with the testing of throwables, this is thrown when a throwable is caught which is
 * unexpected.
 * <p>
 * <b>Note</b> - this was <b><u>not</u></b> created as a part of this project, all credit for this class go to Rafal
 * Borowiec.
 *
 * @see <a href = https://github.com/kolorobot/unit-testing-demo>Unit Testing Demo on GitHub</a>
 */
public class ExceptionNotThrownAssertionError extends AssertionError {

    public ExceptionNotThrownAssertionError() {
        super("Expected exception was not thrown.");
    }
}

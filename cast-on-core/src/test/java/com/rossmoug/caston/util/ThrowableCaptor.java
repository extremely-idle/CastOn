package com.rossmoug.caston.util;

/**
 * Test class to assist with the testing of throwables, this will trap and return a throwable if one is caught.
 * <p>
 * <b>Note</b> - this was <b><u>not</u></b> created as a part of this project, all credit for this class go to Rafal
 * Borowiec.
 *
 * @see <a href = https://github.com/kolorobot/unit-testing-demo>Unit Testing Demo on GitHub</a>
 */
public class ThrowableCaptor {

    public static Throwable captureThrowable(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
            return null;
        } catch (Throwable caught) {
            return caught;
        }
    }
}

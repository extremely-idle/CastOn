package com.rossmoug.caston.util;

import org.hamcrest.Matchers;
import org.junit.Assert;

/**
 * Test class to assist with the testing of throwables, this provides various assertions for attributes of a throwable.
 * <p>
 * <b>Note</b> - this was <b><u>not</u></b> created as a part of this project, all credit for this class go to Rafal
 * Borowiec. Please see https://github.com/kolorobot/unit-testing-demo for more information.
 */
public class ThrowableAssertion {

    private final Throwable caught;

    private ThrowableAssertion(Throwable caught) {
        this.caught = caught;
    }

    public static ThrowableAssertion assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable caught) {
            return new ThrowableAssertion(caught);
        }
        throw new ExceptionNotThrownAssertionError();
    }

    public ThrowableAssertion isInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(caught, Matchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }

    public ThrowableAssertion hasMessage(String expectedMessage) {
        Assert.assertThat(caught.getMessage(), Matchers.equalTo(expectedMessage));
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public ThrowableAssertion hasNoCause() {
        Assert.assertThat(caught.getCause(), Matchers.nullValue());
        return this;
    }

    public ThrowableAssertion hasCauseInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(caught.getCause(), Matchers.notNullValue());
        Assert.assertThat(caught.getCause(), Matchers.isA((Class<Throwable>) exceptionClass));
        return this;
    }
}

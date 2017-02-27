package com.rossmoug.caston.core.util;

import java.math.BigDecimal;

/**
 * A utility library of various maths methods.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public final class MathUtil {

    /**
     * A wrapper method for the <code>signum</code> method in {@link java.lang.Math}. This method will return a {@link
     * BigDecimal} instead of a float.
     *
     * @param value
     *         the numeric value that the signum method must be performed on
     * @return a BigDecimal value containing the output of the signum method
     */
    public static BigDecimal sign(double value) {
        final BigDecimal sign = BigDecimal.valueOf(Math.signum(value)).stripTrailingZeros();

        return sign;
    }
}
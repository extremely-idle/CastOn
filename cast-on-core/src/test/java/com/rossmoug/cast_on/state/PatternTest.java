package com.rossmoug.cast_on.state;

import org.junit.Assert;
import org.junit.Test;

import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on.state.Unit;
import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.gauge.impl.Gauge;
import com.rossmoug.cast_on.state.pattern.IPattern;
import com.rossmoug.cast_on.state.pattern.impl.Pattern;
import com.rossmoug.cast_on.state.pattern.builder.PatternBuilder;

/**
 * Test cases to ensure that Pattern objects can be generated consistently.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see Pattern
 */
public class PatternTest {

	@Test
	/**
	 * 
	 */
	public void validPatternTest() {
		try {
			IGauge userGauge = new Gauge(15, 10, Unit.INCHES);
			IGauge patternGauge = new Gauge(30, 20, Unit.INCHES);

			IPattern pattern = new PatternBuilder().userGauge(userGauge).patternGauge(patternGauge).dimension(4)
					.build();

			Assert.assertNotNull("", pattern.getUserGauge());
			Assert.assertNotNull("", pattern.getPatternGauge());
			Assert.assertEquals(4, pattern.getDimension(), 0);
		} catch (InvalidConversionArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}
}

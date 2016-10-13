package com.rossmoug.cast_on.state;

import org.junit.Assert;
import org.junit.Test;

import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on.state.Unit;
import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.gauge.impl.Gauge;
import com.rossmoug.cast_on.state.pattern.IPattern;
import com.rossmoug.cast_on.state.pattern.impl.Pattern;

import junitx.extensions.EqualsHashCodeTestCase;

import com.rossmoug.cast_on.state.pattern.builder.PatternBuilder;

/**
 * Test cases to ensure that Pattern objects can be generated consistently.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see Pattern
 */
public class PatternTest extends EqualsHashCodeTestCase {

	public PatternTest(String name) {
		super(name);
	}

	@Test
	/**
	 * 
	 */
	public void validPatternTest() {
		try {
			IGauge patternGauge = new Gauge(30, 20, Unit.INCHES);

			IPattern pattern = new PatternBuilder().gauge(patternGauge).dimension(4)
					.build();

			Assert.assertNotNull("", pattern.getGauge());
			Assert.assertEquals(4, pattern.getDimension(), 0);
		} catch (InvalidConversionArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}

	@Override
	protected Object createInstance() throws Exception {
		return new PatternBuilder().dimension(1).gauge(new Gauge(1, 1, Unit.CM)).build();
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		return new PatternBuilder().dimension(2).gauge(new Gauge(2, 2, Unit.INCHES)).build();
	}
}

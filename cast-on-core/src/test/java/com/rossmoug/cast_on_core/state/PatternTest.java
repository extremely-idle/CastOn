package com.rossmoug.cast_on_core.state;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.gauge.impl.Gauge;
import com.rossmoug.cast_on_core.state.pattern.IPattern;
import com.rossmoug.cast_on_core.state.pattern.builder.PatternBuilder;
import com.rossmoug.cast_on_core.state.pattern.impl.Pattern;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Test cases to ensure that Pattern objects can be generated consistently.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
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
		IGauge patternGauge = mock(Gauge.class);
		when(patternGauge.getRowCount()).thenReturn(30);
		when(patternGauge.getStitchCount()).thenReturn(20);
		when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

		IPattern pattern = new PatternBuilder().gauge(patternGauge).dimension(4).build();

		Assert.assertNotNull("Pattern gauge is not null", pattern.getGauge());
		Assert.assertEquals(4, pattern.getDimension(), 0);
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

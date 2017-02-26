package com.rossmoug.cast_on_core.state.pattern;

import static org.mockito.Mockito.*;

import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.gauge.builder.GaugeBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.rossmoug.cast_on_core.state.pattern.builder.PatternBuilder;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Test cases to ensure that {@link Pattern} objects can be generated consistently.
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
	public void validPatternTest() {
		final Gauge patternGauge = mock(Gauge.class);
		when(patternGauge.getRowCount()).thenReturn((long) 30);
		when(patternGauge.getStitchCount()).thenReturn((long) 20);
		when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

		final Pattern pattern = new PatternBuilder().withGauge(patternGauge).withDimension(4).build();

		Assert.assertNotNull("Pattern withGauge is not null", pattern.getGauge());
		Assert.assertEquals(4, pattern.getDimension(), 0);
	}

	@Override
	protected Object createInstance() throws Exception {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder().withRowCount(1).withStitchCount(1).withUnit(Unit.CM);
		final PatternBuilder patternBuilder = new PatternBuilder().withDimension(1).withGauge(gaugeBuilder.build());

		return patternBuilder.build();
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder().withRowCount(2).withStitchCount(2).withUnit(Unit.INCHES);
		final PatternBuilder patternBuilder = new PatternBuilder().withDimension(2).withGauge(gaugeBuilder.build());

		return patternBuilder.build();
	}
}
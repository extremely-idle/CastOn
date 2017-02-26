package com.rossmoug.cast_on_core.convert.pattern;

import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.convert.pattern.impl.PatternConverterImpl;
import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test cases for pattern conversion.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 * @see PatternConverter
 */
public class PatternConverterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void converterTest() throws InvalidConversionArgumentException {
		// given:
		final Gauge userGauge = mock(Gauge.class);
		when(userGauge.getRowCount()).thenReturn((long) 10);
		when(userGauge.getStitchCount()).thenReturn((long) 10);
		when(userGauge.getUnit()).thenReturn(Unit.INCHES);

		final Gauge patternGauge = mock(Gauge.class);
		when(patternGauge.getRowCount()).thenReturn((long) 30);
		when(patternGauge.getStitchCount()).thenReturn((long) 20);
		when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

		final Pattern pattern = mock(Pattern.class);
		when(pattern.getGauge()).thenReturn(patternGauge);
		when(pattern.getDimension()).thenReturn(4.0);

		// when:
		final PatternConverter converter = PatternConverterImpl.getInstance();
		final Pattern convertedPattern = converter.convertPattern(pattern, userGauge);

		// then:
		Assert.assertEquals(3.0, convertedPattern.getGauge().getRowCount(), 0.01);
		Assert.assertEquals(5.0, convertedPattern.getGauge().getStitchCount(), 0.01);
	}
}
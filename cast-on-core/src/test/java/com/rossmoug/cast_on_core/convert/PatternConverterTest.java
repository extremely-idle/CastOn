package com.rossmoug.cast_on_core.convert;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rossmoug.cast_on_core.convert.IPatternConverter;
import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.convert.impl.PatternConverter;
import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.gauge.impl.Gauge;
import com.rossmoug.cast_on_core.state.pattern.IPattern;
import com.rossmoug.cast_on_core.state.pattern.impl.Pattern;

/**
 * Test cases for pattern conversion.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 * @see PatternConversion
 */
public class PatternConverterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	/**
	 * 
	 */
	public void converterTest() throws InvalidConversionArgumentException {
		// given:
		IGauge userGauge = mock(Gauge.class);
		when(userGauge.getRowCount()).thenReturn(10);
		when(userGauge.getStitchCount()).thenReturn(10);
		when(userGauge.getUnit()).thenReturn(Unit.INCHES);

		IGauge patternGauge = mock(Gauge.class);
		when(patternGauge.getRowCount()).thenReturn(30);
		when(patternGauge.getStitchCount()).thenReturn(20);
		when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

		IPattern pattern = mock(Pattern.class);
		when(pattern.getGauge()).thenReturn(patternGauge);
		when(pattern.getDimension()).thenReturn(4.0);

		// when:
		IPatternConverter converter = PatternConverter.getInstance();
		IPattern convertedPattern = converter.convertPattern(pattern, userGauge);

		// then:
		Assert.assertEquals(3.0, convertedPattern.getGauge().getRowCount(), 0.01);
		Assert.assertEquals(5.0, convertedPattern.getGauge().getStitchCount(), 0.01);
	}

}

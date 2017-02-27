package com.rossmoug.caston.core.convert.pattern;

import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.convert.pattern.impl.PatternConverterImpl;
import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test cases for pattern conversion.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.3
 * @see PatternConverter
 */
public class PatternConverterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setupTest(){
		Logger.getRootLogger().setLevel(Level.TRACE);
	}

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
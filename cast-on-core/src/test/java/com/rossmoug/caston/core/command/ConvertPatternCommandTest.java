package com.rossmoug.caston.core.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.pattern.Pattern;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rossmoug.caston.core.command.impl.ConvertPatternCommand;
import com.rossmoug.caston.core.convert.pattern.PatternConverter;
import com.rossmoug.caston.core.state.gauge.Gauge;

/**
 * Test cases for the {@link ConvertPatternCommand} class.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 */
public class ConvertPatternCommandTest {

	@BeforeClass
	public static void setupTest(){
        Logger.getRootLogger().setLevel(Level.TRACE);
	}

	@Test
	public void happyPathTest() throws InvalidConversionArgumentException {
		// given:
		final Gauge userGauge = mock(Gauge.class);
		when(userGauge.getRowCount()).thenReturn((long) 10);
		when(userGauge.getStitchCount()).thenReturn((long) 10);
		when(userGauge.getUnit()).thenReturn(Unit.INCHES);

		Gauge patternGauge = mock(Gauge.class);
		when(patternGauge.getRowCount()).thenReturn((long) 30);
		when(patternGauge.getStitchCount()).thenReturn((long) 20);
		when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

		final Pattern pattern = mock(Pattern.class);
		when(pattern.getGauge()).thenReturn(patternGauge);
		when(pattern.getDimension()).thenReturn(4.0);

		final Gauge resultGauge = mock(Gauge.class);
		when(resultGauge.getRowCount()).thenReturn((long) 3);
		when(resultGauge.getStitchCount()).thenReturn((long) 5);
		when(resultGauge.getUnit()).thenReturn(Unit.INCHES);

		final Pattern result = mock(Pattern.class);
		when(result.getDimension()).thenReturn(4.0);
		when(result.getGauge()).thenReturn(resultGauge);

		final PatternConverter converter = mock(PatternConverter.class);
		when(converter.convertPattern(pattern, userGauge)).thenReturn(result);
		
		// when:
		final Command<Pattern> command = new ConvertPatternCommand(pattern, userGauge);
		final Pattern convertedPattern = command.execute();

		// then:
		Assert.assertEquals(3.0, convertedPattern.getGauge().getRowCount(), 0.01);
		Assert.assertEquals(5.0, convertedPattern.getGauge().getStitchCount(), 0.01);
	}
}
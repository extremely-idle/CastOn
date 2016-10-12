package com.rossmoug.cast_on.convert;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rossmoug.cast_on.convert.IPatternConverter;
import com.rossmoug.cast_on.convert.impl.PatternConverter;
import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on.state.gauge.impl.Gauge;
import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.Unit;
import com.rossmoug.cast_on.state.pattern.IPattern;
import com.rossmoug.cast_on.state.pattern.builder.PatternBuilder;

/**
 * Test cases for pattern conversion.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see PatternConversion
 */
public class PatternConverterTest {

	private final String INVALID_ARGS_EXCP_STR = "Row and stitch count can not be zero or negative.";
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	/**
	 * 
	 */
	public void converterTest(){
		try {			
			IGauge userGauge = new Gauge(10, 10, Unit.INCHES);// sub-class gauge?
			IGauge patternGauge = new Gauge(30, 20, Unit.INCHES);
			
			IPattern pattern = new PatternBuilder().patternGauge(patternGauge).dimension(4)
					.build();
			
			IPatternConverter converter = new PatternConverter();
			IPattern convertedPattern = converter.convertPattern(pattern, userGauge);
			
			Assert.assertEquals(3.0, convertedPattern.getGauge().getRowCount(), 0.01);
			Assert.assertEquals(5.0, convertedPattern.getGauge().getStitchCount(), 0.01);
		} catch (InvalidConversionArgumentException e) {
			e.printStackTrace();
		}
	}

	//@Test(expected=InvalidConversionArgumentException.class)
	/**
	 * Ensure that an exception is thrown when invalid arguments, negative, are provided.
	 * 
	 * @see InvalidArgumentException
	 */
	/*public void negativeConverterTest() throws InvalidConversionArgumentException {
		IConversionInput input = new ConversionInput(-10, -10);
		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage(INVALID_ARGS_EXCP_STR);
	}

	@Test(expected=InvalidConversionArgumentException.class)
	*//**
	 * Ensure that an exception is thrown when invalid arguments are provided. When
	 * the row and/or stitch counts are zero.
	 * 
	 * @see InvalidArgumentException
	 *//*
	public void zeroConverterTest() throws InvalidConversionArgumentException {
		IConversionInput input = new ConversionInput(0, 0);
		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage(INVALID_ARGS_EXCP_STR);
	}*/
}

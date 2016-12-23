package com.rossmoug.cast_on_core.state;

import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.gauge.impl.Gauge;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Tests to ensure that the generation of Gauge objects is consistent.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 * @see Gauge
 */
public class GaugeTest extends EqualsHashCodeTestCase {

	public GaugeTest(String name) {
		super(name);
	}

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	/**
	 * 
	 */
	public void validGaugeTest(){
		IGauge knittingGauge;
		try {
			knittingGauge = new Gauge(1, 1, Unit.INCHES);

			Assert.assertEquals(1, knittingGauge.getRowCount());
			Assert.assertEquals(1, knittingGauge.getStitchCount());
			Assert.assertEquals(Unit.INCHES, knittingGauge.getUnit());
		} catch (InvalidConversionArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}
	
	@Test(expected=InvalidConversionArgumentException.class)
	/**
	 * 
	 * @throws InvalidArgumentException
	 */
	public void invalidCountTest() throws InvalidConversionArgumentException{
		IGauge knittingGauge = new Gauge(0, 0, Unit.INCHES);

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Row and stitch count can not be zero or negative.");
	}

	@Test(expected=InvalidConversionArgumentException.class)
	/**
	 * 
	 * @throws InvalidArgumentException
	 */
	public void invalidUnitTest() throws InvalidConversionArgumentException{
		IGauge knittingGauge = new Gauge(0, 0, null);

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Unit must be provided.");
	}

	@Override
	protected Object createInstance() throws Exception {
		return new Gauge(1, 1, Unit.INCHES);
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		return new Gauge(2, 2, Unit.INCHES);
	}
}

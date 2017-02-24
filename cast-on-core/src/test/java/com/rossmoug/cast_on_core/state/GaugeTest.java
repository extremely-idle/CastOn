package com.rossmoug.cast_on_core.state;

import com.rossmoug.cast_on_core.state.gauge.builder.GaugeBuilder;
import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.Gauge;

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
		Gauge knittingGauge;
		try {
			final GaugeBuilder gaugeBuilder = new GaugeBuilder();

			knittingGauge = gaugeBuilder.rowCount(1).stitchCount(1).unit(Unit.INCHES).build();

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
	public void invalidCountTest() {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge knittingGauge = gaugeBuilder.rowCount(0).stitchCount(0).unit(Unit.INCHES).build();

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Row and stitch count can not be zero or negative.");
	}

	@Test(expected=InvalidConversionArgumentException.class)
	/**
	 * 
	 * @throws InvalidArgumentException
	 */
	public void invalidUnitTest() {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge knittingGauge = gaugeBuilder.rowCount(0).stitchCount(0).unit(null).build();

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Unit must be provided.");
	}

	@Override
	protected Object createInstance() throws Exception {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge guage = gaugeBuilder.rowCount(1).stitchCount(1).unit(Unit.INCHES).build();

		return guage;
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge guage = gaugeBuilder.rowCount(2).stitchCount(2).unit(Unit.CM).build();

		return guage;
	}
}
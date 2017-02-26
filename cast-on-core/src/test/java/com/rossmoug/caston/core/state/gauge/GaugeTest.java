package com.rossmoug.caston.core.state.gauge;

import com.rossmoug.caston.core.state.gauge.builder.GaugeBuilder;
import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.state.Unit;
import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Tests to ensure that the generation of {@link Gauge} objects is consistent.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 * @see Gauge
 */
public class GaugeTest extends EqualsHashCodeTestCase {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

	public GaugeTest(String name) {
        super(name);
	}

	@Test
	public void validGaugeTest(){
		Gauge knittingGauge;
		try {
			final GaugeBuilder gaugeBuilder = new GaugeBuilder();

			knittingGauge = gaugeBuilder.withRowCount(1).withStitchCount(1).withUnit(Unit.INCHES).build();

			Assert.assertEquals(1, knittingGauge.getRowCount());
			Assert.assertEquals(1, knittingGauge.getStitchCount());
			Assert.assertEquals(Unit.INCHES, knittingGauge.getUnit());
		} catch (InvalidConversionArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}
	
	@Test(expected=InvalidConversionArgumentException.class)
	public void invalidCountTest() {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge knittingGauge = gaugeBuilder.withRowCount(0).withStitchCount(0).withUnit(Unit.INCHES).build();

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("RowConverter and stitch count can not be zero or negative.");
	}

	@Test(expected=InvalidConversionArgumentException.class)
	public void invalidUnitTest() {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge knittingGauge = gaugeBuilder.withRowCount(0).withStitchCount(0).withUnit(null).build();

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Unit must be provided.");
	}

	@Override
	protected Object createInstance() throws Exception {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge gauge = gaugeBuilder.withRowCount(1).withStitchCount(1).withUnit(Unit.INCHES).build();

		return gauge;
	}

	@Override
	protected Object createNotEqualInstance() throws Exception {
		final GaugeBuilder gaugeBuilder = new GaugeBuilder();

		final Gauge gauge = gaugeBuilder.withRowCount(2).withStitchCount(2).withUnit(Unit.CM).build();

		return gauge;
	}
}
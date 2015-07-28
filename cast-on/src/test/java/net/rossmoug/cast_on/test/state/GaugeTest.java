package net.rossmoug.cast_on.test.state;

import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import net.rossmoug.cast_on.impl.convert.excp.InvalidConversionArgumentException;
import net.rossmoug.cast_on.impl.state.Gauge;
import net.rossmoug.cast_on.impl.state.IGauge;
import net.rossmoug.cast_on.impl.state.Unit;

/**
 * Tests to ensure that the generation of Gauge objects is consistent.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see Gauge
 */
public class GaugeTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	/**
	 * 
	 */
	public void validGaugeTest(){
		IGauge gauge;
		try {
			gauge = new Gauge(1, 1, Unit.INCHES);

			Assert.assertEquals(1, gauge.getRowCount());
			Assert.assertEquals(1, gauge.getStitchCount());
			Assert.assertEquals(Unit.INCHES, gauge.getUnit());
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
		IGauge gauge = new Gauge(0, 0, Unit.INCHES);

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Row and stitch count can not be zero or negative.");
	}

	@Test(expected=InvalidConversionArgumentException.class)
	/**
	 * 
	 * @throws InvalidArgumentException
	 */
	public void invalidUnitTest() throws InvalidConversionArgumentException{
		IGauge gauge = new Gauge(0, 0, null);

		thrown.expect(InvalidConversionArgumentException.class);
		thrown.expectMessage("Unit must be provided.");
	}
}

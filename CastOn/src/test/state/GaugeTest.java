package test.state;

import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import impl.convert.excp.InvalidArgumentException;
import impl.state.Gauge;
import impl.state.IGauge;
import impl.state.Unit;

/**
 * 
 * @author Ross
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
		} catch (InvalidArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}
	
	@Test(expected=InvalidArgumentException.class)
	/**
	 * 
	 * @throws InvalidArgumentException
	 */
	public void invalidCountTest() throws InvalidArgumentException{
		IGauge gauge = new Gauge(0, 0, Unit.INCHES);

		thrown.expect(InvalidArgumentException.class);
		thrown.expectMessage("Row and stitch count can not be zero or negative.");
	}

	@Test(expected=InvalidArgumentException.class)
	/**
	 * 
	 * @throws InvalidArgumentException
	 */
	public void invalidUnitTest() throws InvalidArgumentException{
		IGauge gauge = new Gauge(0, 0, null);

		thrown.expect(InvalidArgumentException.class);
		thrown.expectMessage("Unit must be provided.");
	}
}

package net.rossmoug.cast_on.test.state;

import org.junit.Assert;
import org.junit.Test;

import net.rossmoug.cast_on.impl.convert.excp.InvalidConversionArgumentException;
import net.rossmoug.cast_on.impl.state.Gauge;
import net.rossmoug.cast_on.impl.state.IGauge;
import net.rossmoug.cast_on.impl.state.Pattern;
import net.rossmoug.cast_on.impl.state.IPattern;
import net.rossmoug.cast_on.impl.state.Unit;

/**
 * Test cases to ensure that Pattern objects can be generated consistently.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see Pattern
 */
public class PatternTest {

	@Test
	/**
	 * 
	 */
	public void validPatternTest(){
		try{
			IGauge userGauge = new Gauge(15, 10, Unit.INCHES);
			IGauge patternGauge = new Gauge(30, 20, Unit.INCHES);
	
			IPattern pattern = new Pattern(userGauge, patternGauge, 4);

			Assert.assertNotNull("", pattern.getUserGauge());
			Assert.assertNotNull("", pattern.getPatternGauge());
			Assert.assertEquals(4, pattern.getDimension(), 0);
		} catch (InvalidConversionArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}
}

package net.rossmoug.cast_on.test.state;

import org.junit.Assert;
import org.junit.Test;

import net.rossmoug.cast_on.impl.convert.excp.InvalidArgumentException;
import net.rossmoug.cast_on.impl.state.Gauge;
import net.rossmoug.cast_on.impl.state.IGauge;
import net.rossmoug.cast_on.impl.state.Pattern;
import net.rossmoug.cast_on.impl.state.IPattern;
import net.rossmoug.cast_on.impl.state.Unit;

/**
 * 
 * @author Ross
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
		} catch (InvalidArgumentException e) {
			Assert.fail("Unexpected exception encountered.");
		}
	}
}

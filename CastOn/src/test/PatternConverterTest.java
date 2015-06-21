package test;

import org.junit.Assert;
import org.junit.Test;

import impl.convert.ConversionInput;
import impl.convert.IConversionInput;
import impl.convert.IConversionResult;
import impl.convert.IPatternConverter;
import impl.convert.PatternConverter;
import impl.state.Gauge;
import impl.state.IGauge;
import impl.state.IPattern;
import impl.state.Pattern;
import impl.state.Unit;

/**
 * 
 * @author Ross
 */
public class PatternConverterTest {
	
	@Test
	/**
	 * 
	 */
	public void converterTest(){
		IConversionInput input = new ConversionInput(10, 10);
		
		IGauge userGauge = new Gauge(15, 10, Unit.INCHES);// sub-class gauge?
		IGauge patternGauge = new Gauge(30, 20, Unit.INCHES);
		
		IPattern pattern = new Pattern(userGauge, patternGauge, 4);
		
		IPatternConverter converter = new PatternConverter();
		IConversionResult result = converter.convertPattern(pattern, input);
		
		Assert.assertEquals(5.0, result.getConvertedRowCount(), 0.01);
		Assert.assertEquals(5.0, result.getConvertedStitchCount(), 0.01);
	}
}

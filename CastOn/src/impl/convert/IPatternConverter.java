package impl.convert;

import impl.state.IPattern;

/**
 * 
 * @author Ross
 */
public interface IPatternConverter {

	/**
	 * 
	 * @param pattern
	 * @param conversionInput
	 * @return
	 */
	public IConversionResult convertPattern(IPattern pattern, IConversionInput conversionInput);
}

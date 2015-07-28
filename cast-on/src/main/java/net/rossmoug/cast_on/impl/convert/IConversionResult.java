package net.rossmoug.cast_on.impl.convert;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public interface IConversionResult {

	/**
	 * 
	 * @return
	 */
	public double getConvertedRowCount();
	
	/**
	 * 
	 * @param d
	 */
	public void setConvertedRowCount(double d);
	
	/**
	 * 
	 * @return
	 */
	public double getConvertedStitchCount();
	
	/**
	 * 
	 * @param d
	 */
	public void setConvertedStitchCount(double d);
}

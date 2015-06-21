package impl.convert;

/**
 * 
 * @author Ross
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

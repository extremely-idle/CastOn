package impl.convert;

/**
 * 
 * @author Ross
 */
public class ConversionResult implements IConversionResult {

	private double rowCount;
	private double stitchCount;
	
	@Override
	/**
	 * 
	 * @return
	 */
	public double getConvertedRowCount() {
		return rowCount;
	}

	@Override
	/**
	 * 
	 * @param
	 */
	public void setConvertedRowCount(double convertedRowCount) {
		this.rowCount = convertedRowCount;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public double getConvertedStitchCount() {
		return stitchCount;
	}

	@Override
	/**
	 * 
	 * @param
	 */
	public void setConvertedStitchCount(double convertedStitchCount) {
		this.stitchCount = convertedStitchCount;
	}

}

package impl.convert;

/**
 * 
 * @author Ross
 */
public class ConversionInput implements IConversionInput {

	private int rowCount;
	private int stitchCount;

	/**
	 * 
	 * @param rowCount
	 * @param stitchCount
	 */
	public ConversionInput(int rowCount, int stitchCount){
		this.rowCount = rowCount;
		this.stitchCount = stitchCount;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public int getInputRowCount() {
		return rowCount;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public int getInputStitchCount() {
		return stitchCount;
	}

}

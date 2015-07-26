package impl.convert;

import impl.convert.excp.InvalidArgumentException;

/**
 * 
 * @author Ross
 */
public class ConversionInput implements IConversionInput {

	private static final int POSITIVE_VALUE = 1;
	
	private int rowCount;
	private int stitchCount;

	/**
	 * 
	 * @param rowCount
	 * @param stitchCount
	 */
	public ConversionInput(int rowCount, int stitchCount) throws InvalidArgumentException{
		if (Math.signum(rowCount) != POSITIVE_VALUE || Math.signum(stitchCount) != POSITIVE_VALUE){
			throw new InvalidArgumentException("Row and stitch count can not be zero or negative.");
		}

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

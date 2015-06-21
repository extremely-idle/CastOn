package impl.state;

/**
 * 
 * @author Ross
 */
public class Gauge implements IGauge {

	private int rowCount;
	private int stitchCount;
	private Unit unit;
	
	/**
	 * 
	 * @param rowCount
	 * @param stitchCount
	 * @param unit
	 */
	public Gauge(int rowCount, int stitchCount, Unit unit){
		this.rowCount = rowCount;
		this.stitchCount = stitchCount;
		this.unit = unit;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public int getRowCount() {
		return rowCount;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public int getStitchCount() {
		return stitchCount;
	}

	@Override
	/**
	 * 
	 * @return
	 */
	public Unit getUnit() {
		return unit;
	}

}

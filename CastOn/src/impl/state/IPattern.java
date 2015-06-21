package impl.state;

/**
 * 
 * @author Ross
 */
public interface IPattern {

	/**
	 * 
	 * @return
	 */
	public IGauge getUserGauge();
	
	/**
	 * 
	 * @return
	 */
	public IGauge getPatternGauge();
	
	/**
	 * 
	 * @return
	 */
	public double getDimension();
}

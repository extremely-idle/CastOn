package net.rossmoug.cast_on.impl.state;

/**
 *
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class Pattern implements IPattern {

	private IGauge userGauge;
	private IGauge patternGauge;
	private double dimension;
	
	public Pattern(IGauge userGauge, IGauge patternGauge, double dimension){
		this.userGauge = userGauge;
		this.patternGauge = patternGauge;
		this.dimension = dimension;
	}
	
	public IGauge getUserGauge() {
		return userGauge;
	}

	public IGauge getPatternGauge() {
		return patternGauge;
	}

	public double getDimension() {
		return dimension;
	}

}

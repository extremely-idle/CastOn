package impl.state;

public class Pattern implements IPattern {

	private IGauge userGauge;
	private IGauge patternGauge;
	private double dimension;
	
	public Pattern(IGauge userGauge, IGauge patternGauge, double dimension){
		this.userGauge = userGauge;
		this.patternGauge = patternGauge;
		this.dimension = dimension;
	}
	
	@Override
	public IGauge getUserGauge() {
		return userGauge;
	}

	@Override
	public IGauge getPatternGauge() {
		return patternGauge;
	}

	@Override
	public double getDimension() {
		return dimension;
	}

}

package net.rossmoug.cast_on.impl.state;

/**
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class Pattern implements IPattern {

	private IGauge userGauge;
	private IGauge patternGauge;
	private double dimension;

	public Pattern(IGauge userGauge, IGauge patternGauge, double dimension) {
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

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Pattern [userGauge=" + userGauge + ", patternGauge=" + patternGauge + ", dimension=" + dimension + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pattern other = (Pattern) obj;
		if (Double.doubleToLongBits(dimension) != Double.doubleToLongBits(other.dimension))
			return false;
		if (patternGauge == null) {
			if (other.patternGauge != null)
				return false;
		} else if (!patternGauge.equals(other.patternGauge))
			return false;
		if (userGauge == null) {
			if (other.userGauge != null)
				return false;
		} else if (!userGauge.equals(other.userGauge))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dimension);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((patternGauge == null) ? 0 : patternGauge.hashCode());
		result = prime * result + ((userGauge == null) ? 0 : userGauge.hashCode());
		return result;
	}

}

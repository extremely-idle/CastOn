package com.rossmoug.cast_on.state.pattern.builder;

import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.pattern.impl.Pattern;

/**
 * Builder for Pattern objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see Pattern
 */
public class PatternBuilder {

	public IGauge patternGauge;
	public double dimension;

	/**
	 * 
	 * @param patternGauge
	 * @return
	 */
	public PatternBuilder patternGauge(IGauge patternGauge) {
		this.patternGauge = patternGauge;
		return this;
	}

	/**
	 * 
	 * @param dimension
	 * @return
	 */
	public PatternBuilder dimension(double dimension) {
		this.dimension = dimension;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public Pattern build() {
		return new Pattern(this);
	}
}
package com.rossmoug.cast_on_core.state.pattern.builder;

import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.pattern.impl.Pattern;

/**
 * Builder for Pattern objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see Pattern
 */
public class PatternBuilder {

	public IGauge gauge;
	public double dimension;

	/**
	 * 
	 * @param gauge
	 * @return
	 */
	public PatternBuilder gauge(IGauge gauge) {
		this.gauge = gauge;
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
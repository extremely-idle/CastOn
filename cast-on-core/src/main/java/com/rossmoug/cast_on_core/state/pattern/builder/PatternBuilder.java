package com.rossmoug.cast_on_core.state.pattern.builder;

import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;
import com.rossmoug.cast_on_core.util.Builder;

/**
 * Builder for Pattern objects.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see Pattern
 */
public class PatternBuilder implements Builder<Pattern> {

	public Gauge gauge;
	public double dimension;

	/**
	 * 
	 * @param gauge
	 * @return
	 */
	public PatternBuilder gauge(final Gauge gauge) {
		this.gauge = gauge;
		return this;
	}

	/**
	 * 
	 * @param dimension
	 * @return
	 */
	public PatternBuilder dimension(final double dimension) {
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
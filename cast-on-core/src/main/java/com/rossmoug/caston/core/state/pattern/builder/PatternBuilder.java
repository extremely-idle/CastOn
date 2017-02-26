package com.rossmoug.caston.core.state.pattern.builder;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;
import com.rossmoug.caston.core.util.Builder;

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
	 * Set the withGauge for the new pattern and return the builder.
	 *
	 * @param gauge the withGauge
	 * @return the builder object
	 */
	public PatternBuilder withGauge(final Gauge gauge) {
		this.gauge = gauge;
		return this;
	}

	/**
     * Set the withDimension for the new pattern and return the builder.
     *
     * @param dimension the withGauge
     * @return the builder object
	 */
	public PatternBuilder withDimension(final double dimension) {
		this.dimension = dimension;
		return this;
	}

    /**
     * Create a new pattern object.
     *
     * @return the built pattern object
     */
    @Override
	public Pattern build() {
		return new Pattern(this);
	}
}
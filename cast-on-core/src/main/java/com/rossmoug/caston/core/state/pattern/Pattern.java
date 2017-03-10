package com.rossmoug.caston.core.state.pattern;

import java.io.Serializable;
import java.util.Objects;

import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.builder.PatternBuilder;

/**
 * A representation of a knitting pattern
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 */
public class Pattern implements Comparable<Pattern>, Serializable {

	private final Gauge gauge;
	private final double dimension;

	public Pattern(PatternBuilder builder) {
		this.gauge = builder.gauge;
		this.dimension = builder.dimension;
	}

	public Gauge getGauge() {
		return gauge;
	}

	public double getDimension() {
		return dimension;
	}

	@Override
	/*
	 * (nonJavadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getClass().getSimpleName() + " [" + Objects.toString(gauge) + ", " + Objects.toString(dimension)
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(dimension) + Objects.hashCode(gauge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pattern)) {
			return false;
		}
		final Pattern other = (Pattern) obj;
		return Objects.equals(this.gauge, other.gauge) && Objects.equals(this.dimension, other.dimension);
	}

	@Override
	public int compareTo(Pattern o) {
		if (this.equals(o)) {
			return 0;
		} else {
			return 1;
		}
	}
}
package com.rossmoug.cast_on_core.state.pattern.impl;

import java.util.Objects;

import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.pattern.IPattern;
import com.rossmoug.cast_on_core.state.pattern.builder.PatternBuilder;

/**
 * 
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class Pattern implements IPattern, Comparable<Pattern> {

	private final IGauge gauge;
	private final double dimension;

	public Pattern(PatternBuilder builder) {
		this.gauge = builder.gauge;
		this.dimension = builder.dimension;
	}

	public IGauge getGauge() {
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
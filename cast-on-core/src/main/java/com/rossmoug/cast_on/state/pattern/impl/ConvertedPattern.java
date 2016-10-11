package com.rossmoug.cast_on.state.pattern.impl;

import com.rossmoug.cast_on.state.gauge.IGauge;
import com.rossmoug.cast_on.state.pattern.IPattern;
import com.rossmoug.cast_on.state.pattern.builder.PatternBuilder;

public class ConvertedPattern implements IPattern {

	private IGauge patternGauge;
	private double dimension;

	public ConvertedPattern(PatternBuilder builder) {
		this.patternGauge = builder.patternGauge;
		this.dimension = builder.dimension;
	}

	@Override
	public double getDimension() {
		return dimension;
	}

	@Override
	public IGauge getPatternGauge() {
		return patternGauge;
	}

	@Override
	public IGauge getUserGauge() {
		return null;
	}

}

package com.rossmoug.cast_on_core.command.impl;

import com.rossmoug.cast_on_core.command.Command;
import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.convert.impl.PatternConverterImpl;
import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;

/**
 * 
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @param <E>
 */
public class ConvertPatternCommand<E> extends Command<E> {

	private Pattern pattern;
	private Gauge gauge;

	public ConvertPatternCommand(final Pattern pattern, final Gauge gauge){
		this.pattern = pattern;
		this.gauge = gauge;
	}
	
	@Override
	/**
	 *
	 */
	public E execute() {
		Pattern convertedPattern = null;
		try {
			 convertedPattern= PatternConverterImpl.getInstance().convertPattern(pattern, gauge);
		} catch (InvalidConversionArgumentException e) {
			System.err.println("Invalid argument given for pattern conversion: " + e.getMessage());
		}
		
		return (E) convertedPattern;
	}

}

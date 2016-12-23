package com.rossmoug.cast_on_core.command.impl;

import com.rossmoug.cast_on_core.command.Command;
import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.convert.impl.PatternConverter;
import com.rossmoug.cast_on_core.state.gauge.IGauge;
import com.rossmoug.cast_on_core.state.pattern.IPattern;

/**
 * 
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @param <E>
 */
public class ConvertPatternCommand<E> extends Command<E> {

	private IPattern pattern;
	private IGauge gauge;

	public ConvertPatternCommand(final IPattern pattern, final IGauge gauge){
		this.pattern = pattern;
		this.gauge = gauge;
	}
	
	@Override
	public E execute() {
		IPattern convertedPattern = null;
		try {
			 convertedPattern= PatternConverter.getInstance().convertPattern(pattern, gauge);
		} catch (InvalidConversionArgumentException e) {
			System.err.println("Invalid argument given for pattern conversion: " + e.getMessage());
		}
		
		return (E) convertedPattern;
	}

}

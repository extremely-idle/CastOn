package com.rossmoug.caston.core.command.impl;

import com.rossmoug.caston.core.command.Command;
import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.convert.pattern.PatternConverter;
import com.rossmoug.caston.core.convert.pattern.impl.PatternConverterImpl;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;

import org.apache.log4j.Logger;

/**
 * A command which instructs the system to convert the given pattern to the given withGauge.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class ConvertPatternCommand extends Command<Pattern> {

    private static final Logger LOGGER = Logger.getLogger(PatternConverter.class);

    private final Pattern pattern;
    private final Gauge gauge;

    public ConvertPatternCommand(final Pattern pattern, final Gauge gauge) {
        this.pattern = pattern;
        this.gauge = gauge;
    }

    /**
     * Carry out the pattern conversion based on the provided withGauge.
     *
     * @return the converted pattern
     */
    @Override
    public Pattern execute() {
        Pattern convertedPattern = null;
        try {
            convertedPattern = PatternConverterImpl.getInstance().convertPattern(pattern, gauge);
        } catch (InvalidConversionArgumentException e) {
            LOGGER.fatal("Invalid argument given for pattern conversion: " + e.getMessage());
        }

        return convertedPattern;
    }
}

package com.rossmoug.caston.core.command.impl;

import com.rossmoug.caston.core.command.Command;
import com.rossmoug.caston.core.command.impl.builder.ConvertPatternCommandBuilder;
import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.convert.pattern.PatternConverter;
import com.rossmoug.caston.core.convert.pattern.impl.PatternConverterImpl;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;

import org.apache.log4j.Logger;

/**
 * A command which instructs the system to convert the given pattern to the given gauge.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class ConvertPatternCommand extends Command<Pattern> {

    private static final Logger LOGGER = Logger.getLogger(PatternConverter.class);

    private final Pattern pattern;
    private final Gauge gauge;

    public ConvertPatternCommand(final ConvertPatternCommandBuilder builder) {
        super();
        this.pattern = builder.pattern;
        this.gauge = builder.gauge;
    }

    /**
     * Carry out the pattern conversion based on the provided gauge.
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

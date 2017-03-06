package com.rossmoug.caston.core.command.impl.builder;

import com.rossmoug.caston.core.command.impl.ConvertPatternCommand;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;
import com.rossmoug.caston.core.util.Builder;

/**
 * Builder for {@link ConvertPatternCommand} objects.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see ConvertPatternCommand
 */
public class ConvertPatternCommandBuilder implements Builder<ConvertPatternCommand> {

    public Pattern pattern;
    public Gauge gauge;

    /**
     * Set the pattern and return the builder.
     *
     * @param pattern the pattern
     * @return the builder object
     */
    public ConvertPatternCommandBuilder withPattern(Pattern pattern) {
        this.pattern = pattern;
        return this;
    }

    /**
     * Set the gauge and return the builder.
     *
     * @param gauge the gauge
     * @return the builder object
     */
    public ConvertPatternCommandBuilder withGauge(Gauge gauge) {
        this.gauge = gauge;
        return this;
    }

    /**
     * Create a new command object.
     *
     * @return the built command object
     */
    @Override
    public ConvertPatternCommand build() {
        return new ConvertPatternCommand(this);
    }
}
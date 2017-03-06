package com.rossmoug.caston.core.state.gauge.builder;

import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.util.Builder;
import com.rossmoug.caston.core.state.gauge.Gauge;

/**
 * Builder for {@link Gauge} objects.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 * @see Gauge
 */
public class GaugeBuilder implements Builder<Gauge> {

    public long rowCount;
    public long stitchCount;
    public Unit unit;

    /**
     * Set the number of rows for the new gauge and return the builder.
     *
     * @param rowCount the number of rows
     * @return the builder object
     */
    public GaugeBuilder withRowCount(final long rowCount) {
        this.rowCount = rowCount;
        return this;
    }

    /**
     * Set the number of stitch for the new gauge and return the builder.
     *
     * @param stitchCount the number of rows
     * @return the builder object
     */
    public GaugeBuilder withStitchCount(final long stitchCount) {
        this.stitchCount = stitchCount;
        return this;
    }
    /**
     * Set the unit of measurement for the new gauge and return the builder.
     *
     * @param unit the unit of measurement
     * @return the builder object
     */
    public GaugeBuilder withUnit(final Unit unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Create a new withGauge object.
     *
     * @return the built withGauge object
     */
    @Override
    public Gauge build() {
        return new Gauge(this);
    }
}
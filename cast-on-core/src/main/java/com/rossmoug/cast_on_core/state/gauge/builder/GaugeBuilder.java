package com.rossmoug.cast_on_core.state.gauge.builder;

import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.util.Builder;
import com.rossmoug.cast_on_core.state.gauge.Gauge;

/**
 * Builder for Gauge objects.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see Gauge
 */
public class GaugeBuilder implements Builder<Gauge> {

    public long rowCount;
    public long stitchCount;
    public Unit unit;

    /**
     *
     * @param rowCount
     * @return
     */
    public GaugeBuilder rowCount(final long rowCount) {
        this.rowCount = rowCount;
        return this;
    }

    /**
     *
     * @param stitchCount
     * @return
     */
    public GaugeBuilder stitchCount(final long stitchCount) {
        this.stitchCount = stitchCount;
        return this;
    }

    public GaugeBuilder unit(final Unit unit) {
        this.unit = unit;
        return this;
    }

    /**
     *
     * @return
     */
    public Gauge build() {
        return new Gauge(this);
    }
}
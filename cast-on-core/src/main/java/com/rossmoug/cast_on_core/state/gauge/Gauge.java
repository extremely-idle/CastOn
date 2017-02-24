package com.rossmoug.cast_on_core.state.gauge;

import com.rossmoug.cast_on_core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.builder.GaugeBuilder;

import java.util.Objects;

/**
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class Gauge implements Comparable<Gauge> {

    /**
     *
     */
    private static final float POSITIVE_VALUE = 1.0f;

    private long rowCount;
    private long stitchCount;
    private Unit unit;

    public Gauge() {
    }

    public Gauge(final GaugeBuilder builder) throws InvalidConversionArgumentException {
        if (Math.signum(builder.rowCount) != POSITIVE_VALUE || Math.signum(builder.stitchCount) != POSITIVE_VALUE) {
            throw new InvalidConversionArgumentException("Row and stitch count can not be zero or negative.");
        } else if (builder.unit == null) {
            throw new InvalidConversionArgumentException("Unit must be provided.");
        }

        this.rowCount = builder.rowCount;
        this.stitchCount = builder.stitchCount;
        this.unit = builder.unit;
    }

    /**
     * @return
     */
    public long getRowCount() {
        return rowCount;
    }

    /**
     * @return
     */
    public long getStitchCount() {
        return stitchCount;
    }

    /**
     * @return
     */
    public Unit getUnit() {
        return unit;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [" + Objects.toString(rowCount) + ", "
                + Objects.toString(stitchCount) + ", " + Objects.toString(unit) + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(rowCount) + Objects.hashCode(stitchCount) + Objects.hashCode(unit);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Gauge)) {
            return false;
        }
        final Gauge other = (Gauge) obj;
        return Objects.equals(this.rowCount, other.rowCount) && Objects.equals(this.stitchCount, other.stitchCount)
                && Objects.equals(this.unit, other.unit);
    }

    public int compareTo(Gauge o) {
        return 0;
    }
}
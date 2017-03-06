package com.rossmoug.caston.core.state.gauge;

import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.gauge.builder.GaugeBuilder;
import com.rossmoug.caston.core.util.MathUtil;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * A representation of a knitting withGauge.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 */
public class Gauge implements Comparable<Gauge> {

    private long rowCount;
    private long stitchCount;
    private Unit unit;

    public Gauge(final GaugeBuilder builder) throws InvalidConversionArgumentException {
        if (isGaugeCountsInvalid(builder.rowCount, builder.stitchCount)) {
            throw new InvalidConversionArgumentException("Row count and stitch count can not be zero or negative.");
        } else if (builder.unit == null) {
            throw new InvalidConversionArgumentException("Unit must be provided.");
        }

        this.rowCount = builder.rowCount;
        this.stitchCount = builder.stitchCount;
        this.unit = builder.unit;
    }

    /**
     * Determine whether the row and stitch count values provided are invalid.
     *
     * @param rowCount
     *         the number of rows for this gauge
     * @param stitchCount
     *         the number of stitches for this gauge
     * @return true/false depending on whether the values are valid/invalid
     */
    private boolean isGaugeCountsInvalid(long rowCount, long stitchCount) {
        final boolean isRowCountValid = MathUtil.sign(((Long) rowCount).doubleValue()).equals(BigDecimal.ONE);
        final boolean isStitchCountValid = MathUtil.sign(((Long) stitchCount).doubleValue()).equals(BigDecimal.ONE);

        return !(isRowCountValid && isStitchCountValid);
    }

    public long getRowCount() {
        return rowCount;
    }

    public long getStitchCount() {
        return stitchCount;
    }

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

    @Override
    public int compareTo(Gauge o) {
        if (this.equals(o)) {
            return 0;
        } else {
            return 1;
        }
    }
}
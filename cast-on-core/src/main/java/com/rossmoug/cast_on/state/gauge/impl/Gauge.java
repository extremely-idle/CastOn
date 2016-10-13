package com.rossmoug.cast_on.state.gauge.impl;

import java.util.Objects;

import com.rossmoug.cast_on.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.cast_on.state.Unit;
import com.rossmoug.cast_on.state.gauge.IGauge;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class Gauge implements IGauge {

	private static final float POSITIVE_VALUE = 1;

	private int rowCount;
	private int stitchCount;
	private Unit unit;

	/**
	 * 
	 * @param rowCount
	 * @param stitchCount
	 * @param unit
	 * @throws InvalidConversionArgumentException
	 */
	public Gauge(final int rowCount, final int stitchCount, final Unit unit) throws InvalidConversionArgumentException {
		if (Math.signum(rowCount) != POSITIVE_VALUE || Math.signum(stitchCount) != POSITIVE_VALUE) {
			throw new InvalidConversionArgumentException("Row and stitch count can not be zero or negative.");
		} else if (unit == null) {
			throw new InvalidConversionArgumentException("Unit must be provided.");
		}

		this.rowCount = rowCount;
		this.stitchCount = stitchCount;
		this.unit = unit;
	}

	/**
	 * 
	 * @return
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 
	 * @return
	 */
	public int getStitchCount() {
		return stitchCount;
	}

	/**
	 * 
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

}

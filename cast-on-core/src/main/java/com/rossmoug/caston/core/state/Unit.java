package com.rossmoug.caston.core.state;

import java.util.HashMap;
import java.util.Map;

/**
 * The unit of measurement that a pattern or gauge is measured in.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public enum Unit {
	INCHES("Inches"), CM("Centimetres");

	private static Map<String, Unit> unitMap;

	static {
		unitMap = new HashMap<String, Unit>();
		unitMap.put(Unit.INCHES.getUnitLongName(), Unit.INCHES);
		unitMap.put(Unit.CM.getUnitLongName(), Unit.CM);
	}

	private String unitLongName;

	Unit(String unitLongName) {
		this.unitLongName = unitLongName;
	}

	public String getUnitLongName() {
		return this.unitLongName;
	}

	public static Unit parseUnitLongName(String unitLongName) {
		return unitMap.get(unitLongName);
	}
}
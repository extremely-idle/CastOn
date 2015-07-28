package net.rossmoug.cast_on.impl.convert;

import net.rossmoug.cast_on.impl.state.IGauge;
import net.rossmoug.cast_on.impl.state.IPattern;

/**
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class PatternConverter implements IPatternConverter {

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double rowsPerUnit(IGauge gauge, double dimension){
		System.out.println("---------------------------------------");
		System.out.println("rows => " + gauge.getRowCount());
		System.out.println("dimension => " + dimension);
		System.out.println("---------------------------------------");
		return gauge.getRowCount()/dimension;
	}
	
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double rowConversionFactor(IPattern pattern){
		System.out.println("---------------------------------------");
		System.out.println("rows/unit pattern => " + rowsPerUnit(pattern.getPatternGauge(), pattern.getDimension()));
		System.out.println("rows/unit user => " + rowsPerUnit(pattern.getUserGauge(), pattern.getDimension()));
		System.out.println("return => " + Math.round(rowsPerUnit(pattern.getUserGauge(), pattern.getDimension())/rowsPerUnit(pattern.getPatternGauge(), pattern.getDimension())));
		System.out.println("---------------------------------------");
		return rowsPerUnit(pattern.getUserGauge(), pattern.getDimension())/rowsPerUnit(pattern.getPatternGauge(), pattern.getDimension());
	}
	
	/**
	 * 
	 * @param factor
	 * @param rowCount
	 * @return
	 */
	private double convertRows(double factor, int rowCount){
		System.out.println("---------------------------------------");
		System.out.println("rowCount => " + rowCount);
		System.out.println("factor => " + factor);
		System.out.println("return => " + Math.round(rowCount * factor));
		System.out.println("---------------------------------------");
		return Math.round(rowCount * factor);
	}

	/**
	 * 
	 * @param gauge
	 * @param dimension
	 * @return
	 */
	private double stitchesPerUnit(IGauge gauge, double dimension){
		return gauge.getStitchCount()/dimension;
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private double stitchConversionFactor(IPattern pattern){
		return stitchesPerUnit(pattern.getUserGauge(), pattern.getDimension())/stitchesPerUnit(pattern.getPatternGauge(), pattern.getDimension());
	}
	

	/**
	 * 
	 * @param factor
	 * @param stitchCount
	 * @return
	 */
	private double convertStitch(double factor, int stitchCount){
		return Math.round(stitchCount * factor);
	}
	
	
	/**
	 * 
	 * @param pattern
	 * @param conversionInput
	 */
	public IConversionResult convertPattern(IPattern pattern,
			IConversionInput conversionInput) {
		IConversionResult result = new ConversionResult();

		result.setConvertedRowCount(convertRows(rowConversionFactor(pattern), conversionInput.getInputRowCount()));
		result.setConvertedStitchCount(convertStitch(stitchConversionFactor(pattern), conversionInput.getInputStitchCount()));
		
		System.out.println("rows => " + result.getConvertedRowCount());
		System.out.println("stitches => " + result.getConvertedStitchCount());
		
		return result;
	}

}

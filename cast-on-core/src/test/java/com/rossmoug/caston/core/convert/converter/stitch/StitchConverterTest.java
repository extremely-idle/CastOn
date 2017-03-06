package com.rossmoug.caston.core.convert.converter.stitch;

import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test cases for the {@link StitchConverter} class. This test class will ensure that stitch conversion works as
 * expected.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see StitchConverter
 */
public class StitchConverterTest {

    @BeforeClass
    public static void setupTest(){
        Logger.getRootLogger().setLevel(Level.TRACE);
    }

    @Test
    public void stitchesPerUnitTest() {
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 45);
        when(patternGauge.getStitchCount()).thenReturn((long) 28);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 9);
        when(gauge.getStitchCount()).thenReturn((long) 6);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(2.0);

        final StitchConverter stitchConverter = new StitchConverter();
        stitchConverter.setBasePattern(pattern);
        stitchConverter.setGauge(gauge);

        // when:
        double numberOfStitchesPerUnit = stitchConverter.calculateElementPerUnit(gauge, pattern.getDimension());

        // then:
        Assert.assertNotNull(numberOfStitchesPerUnit);
        Assert.assertEquals(3.0, numberOfStitchesPerUnit, 0.01);
    }

    @Test
    public void stitchConversionFactorCalculationTest() {
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 80);
        when(patternGauge.getStitchCount()).thenReturn((long) 36);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 36);
        when(gauge.getStitchCount()).thenReturn((long) 18);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(9.0);

        final StitchConverter stitchConverter = new StitchConverter();
        stitchConverter.setBasePattern(pattern);
        stitchConverter.setGauge(gauge);

        // when:
        double stitchConversionFactor = stitchConverter.calculateElementConversionFactor(pattern, gauge);

        // then:
        Assert.assertNotNull(stitchConversionFactor);
        Assert.assertEquals(0.5, stitchConversionFactor, 0.01);
    }

    @Test
    public void stitchConversionTest() {
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 120);
        when(patternGauge.getStitchCount()).thenReturn((long) 86);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 30);
        when(gauge.getStitchCount()).thenReturn((long) 65);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(15.0);

        final StitchConverter stitchConverter = new StitchConverter();
        stitchConverter.setBasePattern(pattern);
        stitchConverter.setGauge(gauge);

        // when:
        long convertedStitchCount = stitchConverter.convert();

        // then:
        Assert.assertNotNull(convertedStitchCount);
        Assert.assertEquals(49.0, convertedStitchCount, 0.01);
    }
}
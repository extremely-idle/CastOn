package com.rossmoug.caston.core.convert.converter.row;

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
 * Test cases for the {@link RowConverter} class. This test class will ensure that row conversion works as expected.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see RowConverter
 */
public class RowConverterTest {

    @BeforeClass
    public static void setupTest(){
        Logger.getRootLogger().setLevel(Level.TRACE);
    }

    @Test
    public void rowsPerUnitTest() {
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 40);
        when(patternGauge.getStitchCount()).thenReturn((long) 20);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 15);
        when(gauge.getStitchCount()).thenReturn((long) 15);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(6.0);

        final RowConverter rowConverter = new RowConverter();
        rowConverter.setBasePattern(pattern);
        rowConverter.setGauge(gauge);

        // when:
        double numberOfRowsPerUnit = rowConverter.calculateElementPerUnit(gauge, pattern.getDimension());

        // then:
        Assert.assertNotNull(numberOfRowsPerUnit);
        Assert.assertEquals(2.5, numberOfRowsPerUnit, 0.01);
    }

    @Test
    public void rowConversionFactorCalculationTest() {
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 50);
        when(patternGauge.getStitchCount()).thenReturn((long) 15);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 20);
        when(gauge.getStitchCount()).thenReturn((long) 20);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(5.0);

        final RowConverter rowConverter = new RowConverter();
        rowConverter.setBasePattern(pattern);
        rowConverter.setGauge(gauge);

        // when:
        double rowConversionFactor = rowConverter.calculateElementConversionFactor(pattern, gauge);

        // then:
        Assert.assertNotNull(rowConversionFactor);
        Assert.assertEquals(0.4, rowConversionFactor, 0.01);
    }

    @Test
    public void rowConversionTest() {
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 100);
        when(patternGauge.getStitchCount()).thenReturn((long) 35);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 40);
        when(gauge.getStitchCount()).thenReturn((long) 35);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(7.0);

        final RowConverter rowConverter = new RowConverter();
        rowConverter.setBasePattern(pattern);
        rowConverter.setGauge(gauge);

        // when:
        long convertedRowCount = rowConverter.convert();

        // then:
        Assert.assertNotNull(convertedRowCount);
        Assert.assertEquals(16.0, convertedRowCount, 0.01);
    }
}

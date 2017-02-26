package com.rossmoug.cast_on_core.convert.row.factory;

import com.rossmoug.cast_on_core.convert.row.RowConverter;
import com.rossmoug.cast_on_core.state.Unit;
import com.rossmoug.cast_on_core.state.gauge.Gauge;
import com.rossmoug.cast_on_core.state.pattern.Pattern;
import com.rossmoug.cast_on_core.util.Converter;
import com.rossmoug.cast_on_core.util.ConverterFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test cases for the {@link RowConverterFactory} class.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see RowConverterFactory
 */
public class RowConverterFactoryTest {

    @Test
    public void createValidRowConverterTest(){
        // given:
        final Gauge patternGauge = mock(Gauge.class);
        when(patternGauge.getRowCount()).thenReturn((long) 30);
        when(patternGauge.getStitchCount()).thenReturn((long) 20);
        when(patternGauge.getUnit()).thenReturn(Unit.INCHES);

        final Gauge gauge = mock(Gauge.class);
        when(gauge.getRowCount()).thenReturn((long) 50);
        when(gauge.getStitchCount()).thenReturn((long) 30);
        when(gauge.getUnit()).thenReturn(Unit.INCHES);

        final Pattern pattern = mock(Pattern.class);
        when(pattern.getGauge()).thenReturn(patternGauge);
        when(pattern.getDimension()).thenReturn(4.0);

        // when:
        final ConverterFactory<RowConverter> rowConverterFactory = new RowConverterFactory();
        final Converter rowConverter = rowConverterFactory.create(pattern, gauge);

        // then:
        Assert.assertNotNull(rowConverter);
        Assert.assertTrue(rowConverter instanceof RowConverter);
    }
}

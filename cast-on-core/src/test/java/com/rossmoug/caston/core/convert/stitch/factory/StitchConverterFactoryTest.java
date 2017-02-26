package com.rossmoug.caston.core.convert.stitch.factory;

import com.rossmoug.caston.core.convert.stitch.StitchConverter;
import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.pattern.Pattern;
import com.rossmoug.caston.core.util.Converter;
import com.rossmoug.caston.core.util.ConverterFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test cases for the {@link StitchConverterFactory} class.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see StitchConverterFactory
 */
public class StitchConverterFactoryTest {

    @Test
    public void createValidRowConverterTest() {
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
        final ConverterFactory<StitchConverter> stitchConverterFactory = new StitchConverterFactory();
        final Converter stitchConverter = stitchConverterFactory.create(pattern, gauge);

        // then:
        Assert.assertNotNull(stitchConverter);
        Assert.assertTrue(stitchConverter instanceof StitchConverter);
    }
}

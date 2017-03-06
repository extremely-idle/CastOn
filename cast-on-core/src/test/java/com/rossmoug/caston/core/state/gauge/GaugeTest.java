package com.rossmoug.caston.core.state.gauge;

import com.rossmoug.caston.core.convert.exception.InvalidConversionArgumentException;
import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.gauge.builder.GaugeBuilder;
import com.rossmoug.caston.util.ThrowableAssertion;
import junitx.extensions.EqualsHashCodeTestCase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests to ensure that the generation of {@link Gauge} objects is consistent.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.3
 * @see Gauge
 */
public class GaugeTest extends EqualsHashCodeTestCase {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    public GaugeTest(String name) {
        super(name);
    }

    @BeforeClass
    public static void setupTest() {
        Logger.getRootLogger()
              .setLevel(Level.TRACE);
    }

    @Test
    public void validGaugeTest() {
        Gauge knittingGauge;
        try {
            final GaugeBuilder gaugeBuilder = new GaugeBuilder();

            knittingGauge = gaugeBuilder.withRowCount(1)
                                        .withStitchCount(1)
                                        .withUnit(Unit.INCHES)
                                        .build();

            Assert.assertEquals(1, knittingGauge.getRowCount());
            Assert.assertEquals(1, knittingGauge.getStitchCount());
            Assert.assertEquals(Unit.INCHES, knittingGauge.getUnit());
        } catch (InvalidConversionArgumentException e) {
            Assert.fail("Unexpected exception encountered.");
        }
    }

    public void invalidCountTest() {
        final GaugeBuilder gaugeBuilder = new GaugeBuilder().withRowCount(0)
                                                            .withStitchCount(0)
                                                            .withUnit(Unit.INCHES);

        ThrowableAssertion.assertThrown(gaugeBuilder::build)
                          .isInstanceOf(RuntimeException.class)
                          .hasMessage("Row count and stitch count can not be zero or negative.")
                          .hasNoCause();
    }

    public void invalidUnitTest() {
        final GaugeBuilder gaugeBuilder = new GaugeBuilder().withRowCount(0)
                                                            .withStitchCount(0)
                                                            .withUnit(null);

        ThrowableAssertion.assertThrown(gaugeBuilder::build)
                          .isInstanceOf(RuntimeException.class)
                          .hasMessage("Unit must be provided.")
                          .hasNoCause();
    }

    @Override
    protected Object createInstance() throws Exception {
        final GaugeBuilder gaugeBuilder = new GaugeBuilder();

        final Gauge gauge = gaugeBuilder.withRowCount(1)
                                        .withStitchCount(1)
                                        .withUnit(Unit.INCHES)
                                        .build();

        return gauge;
    }

    @Override
    protected Object createNotEqualInstance() throws Exception {
        final GaugeBuilder gaugeBuilder = new GaugeBuilder();

        final Gauge gauge = gaugeBuilder.withRowCount(2)
                                        .withStitchCount(2)
                                        .withUnit(Unit.CM)
                                        .build();

        return gauge;
    }
}
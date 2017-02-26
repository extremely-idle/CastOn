package com.rossmoug.cast_on_core;

import com.rossmoug.cast_on_core.command.ConvertPatternCommandTest;
import com.rossmoug.cast_on_core.convert.pattern.PatternConverterTest;
import com.rossmoug.cast_on_core.convert.row.RowConverterTest;
import com.rossmoug.cast_on_core.convert.row.factory.RowConverterFactoryTest;
import com.rossmoug.cast_on_core.convert.stitch.StitchConverterTest;
import com.rossmoug.cast_on_core.convert.stitch.factory.StitchConverterFactoryTest;
import com.rossmoug.cast_on_core.state.gauge.GaugeTest;
import com.rossmoug.cast_on_core.state.pattern.PatternTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite to execute all project tests.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        GaugeTest.class,
        PatternTest.class,
        PatternConverterTest.class,
        ConvertPatternCommandTest.class,
        RowConverterFactoryTest.class,
        StitchConverterFactoryTest.class,
        RowConverterTest.class,
        StitchConverterTest.class
})
public class TestSuite {
}

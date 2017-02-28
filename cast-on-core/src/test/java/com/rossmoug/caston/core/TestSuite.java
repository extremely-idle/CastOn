package com.rossmoug.caston.core;

import com.rossmoug.caston.core.command.ConvertPatternCommandTest;
import com.rossmoug.caston.core.convert.pattern.PatternConverterTest;
import com.rossmoug.caston.core.convert.converter.row.RowConverterTest;
import com.rossmoug.caston.core.convert.converter.row.factory.RowConverterFactoryTest;
import com.rossmoug.caston.core.convert.converter.stitch.StitchConverterTest;
import com.rossmoug.caston.core.convert.converter.stitch.factory.StitchConverterFactoryTest;
import com.rossmoug.caston.core.state.gauge.GaugeTest;
import com.rossmoug.caston.core.state.pattern.PatternTest;
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

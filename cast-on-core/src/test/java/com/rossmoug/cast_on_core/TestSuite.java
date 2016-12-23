package com.rossmoug.cast_on_core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rossmoug.cast_on_core.command.ConvertPatternCommandTest;
import com.rossmoug.cast_on_core.convert.PatternConverterTest;
import com.rossmoug.cast_on_core.state.GaugeTest;
import com.rossmoug.cast_on_core.state.PatternTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GaugeTest.class,
   PatternTest.class,
   PatternConverterTest.class,
   ConvertPatternCommandTest.class
})
/**
 * Test suite to execute all project tests.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 */
public class TestSuite {}

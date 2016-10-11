package com.rossmoug.cast_on;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rossmoug.cast_on.convert.PatternConverterTest;
import com.rossmoug.cast_on.state.GaugeTest;
import com.rossmoug.cast_on.state.PatternTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GaugeTest.class,
   PatternTest.class,
   PatternConverterTest.class
})
/**
 * Test suite to execute all project tests.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class TestSuite {}

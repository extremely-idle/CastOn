package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.convert.PatternConverterTest;
import test.state.GaugeTest;
import test.state.PatternTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GaugeTest.class,
   PatternTest.class,
   PatternConverterTest.class
})
/**
 * Test suite to execute all project tests.
 * 
 * @author Ross
 */
public class TestSuite {}

package net.rossmoug.cast_on.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import net.rossmoug.cast_on.test.convert.PatternConverterTest;
import net.rossmoug.cast_on.test.state.GaugeTest;
import net.rossmoug.cast_on.test.state.PatternTest;
import net.rossmoug.cast_on.test.web.oauth.RavelryOAuthServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GaugeTest.class,
   PatternTest.class,
   PatternConverterTest.class,
   RavelryOAuthServiceTest.class
})
/**
 * Test suite to execute all project tests.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class TestSuite {}

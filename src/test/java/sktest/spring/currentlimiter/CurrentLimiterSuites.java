package sktest.spring.currentlimiter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sktest.spring.currentlimiter.aspectj.CurrentLimiterAspectTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CurrentLimiterAspectTest.class})
public class CurrentLimiterSuites {
}

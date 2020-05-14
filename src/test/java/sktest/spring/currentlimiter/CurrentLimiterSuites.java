package sktest.spring.currentlimiter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sktest.spring.currentlimiter.aspectj.CurrentLimiterAspectTest;
import sktest.spring.currentlimiter.props.CurrentLimiterPropsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CurrentLimiterAspectTest.class, CurrentLimiterPropsTest.class})
public class CurrentLimiterSuites {
}

package sktest.spring.currentlimiter.props;

import org.junit.Assert;
import org.junit.Test;
import org.shaneking.spring.currentlimiter.props.CurrentLimiterProps;
import org.shaneking.spring.test.SKSpringUnit;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrentLimiterPropsTest extends SKSpringUnit {
  @Autowired
  private CurrentLimiterProps currentLimiterProps;

  @Test
  public void concurrent() {
    Assert.assertEquals(new Integer(23), currentLimiterProps.getConcurrent());
  }
}

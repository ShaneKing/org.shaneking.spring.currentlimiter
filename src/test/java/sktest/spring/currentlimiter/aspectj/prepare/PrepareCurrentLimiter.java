package sktest.spring.currentlimiter.aspectj.prepare;

import org.shaneking.skava.util.Date0;
import org.shaneking.spring.currentlimiter.annotation.CurrentLimiter;
import org.springframework.stereotype.Component;

@Component
public class PrepareCurrentLimiter {
  @CurrentLimiter(3)
  public void currentLimiter() {
    System.out.println(Date0.on().dateTime());
  }
}

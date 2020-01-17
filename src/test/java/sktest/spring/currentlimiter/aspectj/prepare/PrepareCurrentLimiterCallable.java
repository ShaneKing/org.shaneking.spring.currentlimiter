package sktest.spring.currentlimiter.aspectj.prepare;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@Slf4j
public class PrepareCurrentLimiterCallable implements Callable<Boolean> {
  @Autowired
  private PrepareCurrentLimiter prepareCurrentLimiter;

  @Override
  public Boolean call() {
    try {
      prepareCurrentLimiter.currentLimiter();
      return true;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return false;
    }
  }
}

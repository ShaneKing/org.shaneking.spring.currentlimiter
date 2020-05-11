package sktest.spring.currentlimiter.aspectj;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.shaneking.skava.util.List0;
import org.springframework.beans.factory.annotation.Autowired;
import sktest.spring.currentlimiter.SpringUnit;
import sktest.spring.currentlimiter.aspectj.prepare.PrepareCurrentLimiterCallable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class CurrentLimiterAspectTest extends SpringUnit {
  @Autowired
  private PrepareCurrentLimiterCallable prepareCurrentLimiterCallable;

  @Test
  public void around() throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    List<Future<Boolean>> rstList = executorService.invokeAll(List0.fillList(Lists.newArrayList(), 2 * Runtime.getRuntime().availableProcessors() + 1, () -> prepareCurrentLimiterCallable));
    Assert.assertEquals(3, rstList.parallelStream().filter(future -> {
      try {
        return future.get();
      } catch (Exception e) {
        log.error(e.getMessage(), e);
        return false;
      }
    }).count());
  }
}

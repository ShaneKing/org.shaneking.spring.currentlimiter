package org.shaneking.spring.currentlimiter.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.shaneking.skava.util.concurrent.atomic.AtomicLong0;
import org.shaneking.spring.currentlimiter.annotation.CurrentLimiter;
import org.shaneking.spring.currentlimiter.exception.CurrentLimiterException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Aspect
@Component
@ConditionalOnProperty(prefix = "org.shaneking.spring.currentlimiter", name = "enabled", havingValue = "true", matchIfMissing = true)
public class CurrentLimiterAspect {
  @Pointcut("execution(@org.shaneking.spring.currentlimiter.annotation.CurrentLimiter * *..*.*(..))")
  private void pointcut() {
  }

  @Around("pointcut() && @annotation(currentLimiter)")
  public Object aroundCurrentLimiter(ProceedingJoinPoint joinPoint, CurrentLimiter currentLimiter) throws Throwable {
    String key = joinPoint.getSignature().toLongString();
    if (AtomicLong0.tryDecreaseFailed(initAtomicLong(key, currentLimiter), 0, 1)) {
      try {
        return joinPoint.proceed();
      } finally {
        AtomicLong0.tryIncreaseFailed(CurrentLimiterConstant.BUCKET_MAP.get(key), currentLimiter.value(), 1);
      }
    } else {
      throw new CurrentLimiterException(String.valueOf(CurrentLimiterConstant.BUCKET_MAP.get(key).longValue()));
    }
  }

  private AtomicLong initAtomicLong(String key, CurrentLimiter currentLimiter) {
    if (!CurrentLimiterConstant.BUCKET_MAP.containsKey(key)) {
      synchronized (this) {
        if (!CurrentLimiterConstant.BUCKET_MAP.containsKey(key)) {
          CurrentLimiterConstant.BUCKET_MAP.put(key, new AtomicLong(currentLimiter.value()));
        }
      }
    }
    return CurrentLimiterConstant.BUCKET_MAP.get(key);
  }
}

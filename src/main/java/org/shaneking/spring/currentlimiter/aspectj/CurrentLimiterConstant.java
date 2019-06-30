package org.shaneking.spring.currentlimiter.aspectj;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CurrentLimiterConstant {
  public static final Map<String, AtomicLong> BUCKET_MAP = Maps.newConcurrentMap();
}

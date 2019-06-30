package org.shaneking.spring.currentlimiter.exception;

public class CurrentLimiterException extends RuntimeException {
  public CurrentLimiterException(String message) {
    super(message);
  }
}

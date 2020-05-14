package org.shaneking.spring.currentlimiter.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = CurrentLimiterProps.PREFIX, ignoreInvalidFields = true)
public class CurrentLimiterProps {
  public static final String PREFIX = "org.shaneking.spring.currentlimiter";
  @Getter
  @Setter
  private boolean enabled = true;
  @Getter
  @Setter
  private Integer concurrent = 32;
}

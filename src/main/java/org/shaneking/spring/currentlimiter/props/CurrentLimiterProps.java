package org.shaneking.spring.currentlimiter.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "org.shaneking.spring.currentlimiter")
public class CurrentLimiterProps {

  @Getter
  @Setter
  private boolean enabled = true;
}

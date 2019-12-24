package sktest.spring.currentlimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@SpringBootApplication
public class CurrentLimiterApplication {

  public static void main(String[] args) {
    SpringApplication.run(CurrentLimiterApplication.class, args);
  }

}

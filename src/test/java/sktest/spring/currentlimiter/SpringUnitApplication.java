//!important:the Application just parent of test case if AutoConfiguration in src and test case not sub of src package
package sktest.spring.currentlimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableConfigurationProperties
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringUnitApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringUnitApplication.class, args);
  }
}

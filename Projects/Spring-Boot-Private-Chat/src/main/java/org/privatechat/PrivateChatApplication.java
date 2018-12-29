package org.privatechat;

import org.privatechat.shared.security.ApplicationSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class PrivateChatApplication {
  @Bean
  public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
    return new ApplicationSecurity();
  }

  public static void main(String[] args) {
    // mvn spring-boot:run -Drun.jvmArguments='-Dserver.port={PORT}'
    SpringApplication.run(PrivateChatApplication.class, args);
  }
}
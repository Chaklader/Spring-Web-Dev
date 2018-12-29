package org.privatechat.shared.security;

import org.privatechat.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticationEntryPointHandler authenticationEntryPointHandler;

  @Autowired
  private AuthenticationSuccessHandler authenticationSuccessHandler;

  @Autowired
  private AuthenticationFailureHandler authenticationFailureHandler;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean()
      throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
      .userDetailsService(this.userService)
      .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http)
      throws Exception {
    http
      .csrf()
      .disable(); // TODO: enable CSRF

    http
      .exceptionHandling()
      .authenticationEntryPoint(this.authenticationEntryPointHandler);

    http
      .formLogin()
      .successHandler(this.authenticationSuccessHandler)
      .failureHandler(this.authenticationFailureHandler);

    http
      .logout()
      .logoutSuccessUrl("/");
    
    http
      .authorizeRequests()
      .antMatchers(
        "/index.html",
        "/login",
        "/api/user/register",
        "/",
        "/app.min.js",
        "/app.min.css",
        "/vendors.min.js",
        "/vendors.min.css",
        "/login/LoginView.html",
        "/registration/RegistrationView.html"
      )
      .permitAll()
      .anyRequest()
      .authenticated();
  }
}

@Component
class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, 
      AuthenticationException authException) throws IOException, ServletException {

    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
  }
}

@Component
class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {

    super.onAuthenticationFailure(request, response, exception);
  }
}

@Component
class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    clearAuthenticationAttributes(request);
  }
}
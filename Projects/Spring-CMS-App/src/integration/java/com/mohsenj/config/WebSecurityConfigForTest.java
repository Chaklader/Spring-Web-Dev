package com.mohsenj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Profile("test")
public class WebSecurityConfigForTest extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
      // .antMatchers("/admin/**").access("hasRole('ADMIN')")
      //  .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                    .antMatchers("/**",  "/resources/**", "/registration", "/welcome").permitAll()
                 //   .anyRequest().authenticated()
                    .and()
                    
                    
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
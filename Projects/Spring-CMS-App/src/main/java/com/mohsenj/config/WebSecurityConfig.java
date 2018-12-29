package com.mohsenj.config;

import javax.sql.DataSource;

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

import com.mohsenj.module.user.service.MUserDetailsService;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Profile(value = {"dev", "prod"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
    private MUserDetailsService userDetailsService1;

/*	@Autowired
    private UserDetailsService userDetailsService;
	*/
 /*   @Bean
    public UserDetailsService userDetailsService() {
       // return super.userDetailsService();
    	return userDetailsService;
    }
    */
    
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
       .antMatchers("/admin/**").access("hasRole('super_admin')")
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
        auth.userDetailsService(userDetailsService1).passwordEncoder(bCryptPasswordEncoder());
    }
    
    /*
    @Autowired
	DataSource dataSource;
    
    @Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	}
    */
}
package com.mohsenj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringCms1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCms1Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringCms1Application.class);
    }
	
	/*
	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
      return (container -> {
   	   //route all errors towards /error .
   	   final ErrorPage errorPage=new ErrorPage("/errors");
   	   container.addErrorPages(errorPage);
      });s
   }
	*/
}

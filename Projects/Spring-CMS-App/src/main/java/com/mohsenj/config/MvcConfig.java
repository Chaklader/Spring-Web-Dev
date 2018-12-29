package com.mohsenj.config;

import java.nio.file.Paths;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.mohsenj.module.menu.interceptor.MenuGenerationInterceptor;
import com.mohsenj.module.page.controller.service.BlockService;
import com.mohsenj.module.page.controller.service.BlockServiceImp;
import com.mohsenj.module.user.formatter.PermissionFormatter;
import com.mohsenj.module.user.formatter.RoleFormatter;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
/*@Profile("dev")*/
@PropertySource({ "classpath:config/persistence_${spring.profiles.active}.properties", "classpath:config/mvcconfig_${spring.profiles.active}.properties" })
public class MvcConfig extends WebMvcConfigurerAdapter {
   /*
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/file/**")
          .addResourceLocations("/"+Paths.get("file").toString()+"/");    
    }
	*/
	
	@Value("${mvcconfig.cookieName}")
	private String mvcconfig_cookieName;
	
	@Value("${mvcconfig.cookieMaxAge}")
	private String mvcconfig_cookieMaxAge;
	
	@Value("${mvcconfig.fileDirectoryResourceLocations}")
	private String mvcconfig_fileDirectoryResourceLocations;
	

	@Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new PermissionFormatter());
        formatterRegistry.addFormatter(new RoleFormatter());
    }
	
	@Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName(mvcconfig_cookieName);
        localeResolver.setCookieMaxAge(Integer.parseInt(mvcconfig_cookieMaxAge));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }
    
    @Bean
    public MenuGenerationInterceptor menuGenerationInterceptor(){
    	MenuGenerationInterceptor interceptor = new MenuGenerationInterceptor();
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
        registry.addInterceptor(menuGenerationInterceptor());
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**")
                .addResourceLocations(mvcconfig_fileDirectoryResourceLocations);
    }
   
    /*
    @Bean
    PropertyPlaceholderConfigurer propConfig() {
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        return placeholderConfigurer;
    }*/
    
    @Bean(name = "blockService")
    public BlockService blockService() {
        return new BlockServiceImp();
    }
}

package com.mohsenj.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile("test")
public class PersistenceJPAConfigForTest{

	   
	   @Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		   
		   final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		    em.setDataSource( dataSource() );
		    em.setPackagesToScan( "com.mohsenj" );
		    em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
		    em.setJpaProperties( additionalProperties() );
		    em.setPersistenceUnitName( "cmsdomaintest" );
		    em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		    em.afterPropertiesSet();

		    return em;
	   }
	 
	   @Bean
	   public DataSource dataSource(){
		   DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	       driverManagerDataSource.setDriverClassName("org.h2.Driver");
	       driverManagerDataSource.setUrl("jdbc:h2:mem:mylivedata;IGNORECASE=TRUE;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;MODE=MYSQL");
	       return driverManagerDataSource;
	   }
	   

	 
	   Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	   //   properties.setProperty("hibernate.hbm2ddl.auto", "update");
	    //  properties.setProperty("spring.datasource.data", "data-test.sql");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	      return properties;
	   }
}
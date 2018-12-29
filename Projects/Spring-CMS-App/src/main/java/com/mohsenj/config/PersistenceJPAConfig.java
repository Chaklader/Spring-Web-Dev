package com.mohsenj.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile({"dev", "prod"})
public class PersistenceJPAConfig{
 
   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
     /* LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] { "com.example" });
      
      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());
 
      em.setPersistenceUnitName( "mytestdomain" );
      em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      em.afterPropertiesSet();
      return em;
      */
	   
	   final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource( dataSource() );
	    em.setPackagesToScan( "com.mohsenj" );
	    em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
	    em.setJpaProperties( additionalProperties() );
	    em.setPersistenceUnitName( "cmsdomain" );
	    em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	    em.afterPropertiesSet();

	    return em;
   }
 
   @Value("${database.driverClassName}")
   private String database_driverClassName;
   
   @Value("${database.url}")
   private String database_url;
   
   @Value("${database.username}")
   private String database_username;
   
   @Value("${database.password}")
   private String database_password;
   
   @Value("${database.hibernate.hbm2ddl.auto}")
   private String database_database_hibernate_hbm2ddl_auto;
   
   @Bean
   public DataSource dataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(database_driverClassName);
      dataSource.setUrl(database_url);
      dataSource.setUsername( database_username );
      dataSource.setPassword( database_password );
      return dataSource;
   }
 
   @Bean
   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
 
      return transactionManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties additionalProperties() {
      Properties properties = new Properties();
   //   properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
      properties.setProperty("hibernate.hbm2ddl.auto", database_database_hibernate_hbm2ddl_auto);
    //  properties.setProperty("hibernate.hbm2ddl.auto", "none");
      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
      return properties;
   }
}
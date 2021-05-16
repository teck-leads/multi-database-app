package com.techleads.app.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "h2LocalContainerEntityManagerFactoryBean",
		transactionManagerRef = "h2PlatformTransactionManager",
				basePackages = {"com.techleads.app.repository.h2"})
public class H2Configuration {
	
	// dataSource
		@Bean
		@ConfigurationProperties(prefix = "h2.datasourse")
		public DataSource h2DataSource() {
			return DataSourceBuilder.create().build();
		}

		// EntityManagerFactory
		@Bean
		public LocalContainerEntityManagerFactoryBean h2LocalContainerEntityManagerFactoryBean(
				EntityManagerFactoryBuilder emfb) {

			Map<String, Object> properties = new HashMap<>();
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			return emfb.dataSource(h2DataSource()).packages("com.techleads.app.model").properties(properties).build();

		}

		// TxManager
		@Bean
		public PlatformTransactionManager h2PlatformTransactionManager(
				@Qualifier("h2LocalContainerEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
			return new JpaTransactionManager(entityManagerFactory);
		}

}

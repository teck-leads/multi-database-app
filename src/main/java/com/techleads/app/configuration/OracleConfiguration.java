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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "oracleLocalContainerEntityManagerFactoryBean",
		transactionManagerRef = "oraclePlatformTransactionManager",
		basePackages = {"com.techleads.app.repository.ora"})
public class OracleConfiguration {
	// dataSource
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "ora.datasourse")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}

	// EntityManagerFactory
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean oracleLocalContainerEntityManagerFactoryBean(
			EntityManagerFactoryBuilder emfb) {

		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
//		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		return emfb.dataSource(oracleDataSource()).packages("com.techleads.app.model").properties(properties).build();

	}

	// TxManager
	@Primary
	@Bean
	public PlatformTransactionManager oraclePlatformTransactionManager(
			@Qualifier("oracleLocalContainerEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}

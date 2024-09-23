package edu.deakin.sit218.vulnweb.config;

import javax.persistence.EntityManagerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.deakin.sit218.vulnweb")
public class WebMvcConfig {
	// Define a bean for the View Resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	// UNCOMMENT THIS SECTION FOR SECURE SQL QUERY
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/forum_db");
	    dataSource.setUsername("coachdbadmin");
	    dataSource.setPassword("coachdbadmin");
		return dataSource;
	}
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactory.setDataSource(dataSource);
	        entityManagerFactory.setPackagesToScan("edu.deakin.sit218.vulnweb.entity"); // specify the package containing your entities
	        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactory.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class); // Set Hibernate as the persistence provider
	        
	        Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	        entityManagerFactory.setJpaProperties(jpaProperties);
	        
	        return entityManagerFactory;
		}
		@Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    }
}

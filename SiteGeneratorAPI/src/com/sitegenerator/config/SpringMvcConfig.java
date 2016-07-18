package com.sitegenerator.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sitegenerator.dao.ProductDAO;
import com.sitegenerator.dao.impl.ProductDAOImpl;
import com.sitegenerator.pojo.Product;
import com.sitegenerator.pojo.ProductAttributes;
import com.sitegenerator.pojo.ProductReviews;
import com.sitegenerator.pojo.RelatedProduct;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.sitegenerator")
@PropertySource("classpath:dbSettings.properties")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean(name = "dataSource")

	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.user"));
		dataSource.setPassword(environment.getProperty("db.password"));

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(ProductAttributes.class);
		sessionBuilder.addAnnotatedClasses(ProductReviews.class);
		sessionBuilder.addAnnotatedClasses(RelatedProduct.class);
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDetailsDao(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
}

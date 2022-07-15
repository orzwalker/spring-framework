package com.transaction.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author walker
 * @since 2022/1/27 12:23
 */
@ComponentScan("com.transaction")
@EnableAspectJAutoProxy
@EnableTransactionManagement // 开启事务
@Configuration // 开启事务必须配合Configuration注解使用，否则会生成多个不同的dataSource对象
public class AppConfig {

	// 第一个是beanName 后边两个是别名
	@Bean({"jdbcTemplate", "jdbcTemplateAlias1", "jdbcTemplateAlias2"})
	public JdbcTemplate jdbcTemplate() {
		DataSource dataSource = dataSource();
		System.out.println(dataSource);
		return new JdbcTemplate(dataSource);
	}

	/**
	 * 编程式事务
	 */
	@Bean
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager());
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		DataSource dataSource = dataSource();
		System.out.println(dataSource);
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	/**
	 * 数据库连接
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://82.156.26.80:3306/leo?characterEncoding=utf-8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("leo_mysql_123456");
		return dataSource;
	}
}

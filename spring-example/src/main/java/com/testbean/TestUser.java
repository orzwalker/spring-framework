package com.testbean;

import com.testbean.config.AppConfig;
import com.testbean.domain.BaseEntity;
import com.testbean.domain.User;
import com.testbean.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

/**
 * @author walker
 * @since 2022/1/27 12:28
 */
public class TestUser {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// ApplicationContext如何获取到BeanFactory，需要向下转型
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
		int beanDefinitionCount = defaultListableBeanFactory.getBeanDefinitionCount();
		System.out.println("beanDefinitionCount: " + beanDefinitionCount);

		// 根据beanName获取Bean
		UserService service = context.getBean("userService", UserService.class);
		System.out.println(service);

		// 通过alias获取Bean
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplateAlias1", JdbcTemplate.class);
		System.out.println(jdbcTemplate);

		// 根据beanName获取alias数组
		String[] jdbcTemplates = context.getAliases("jdbcTemplate");
		System.out.println(Arrays.toString(jdbcTemplates));

		service.test();

		// service.insertData();

		User user = context.getBean("user", User.class);
		System.out.println(user.getUk());
		System.out.println(user.getName());

		BaseEntity baseEntity = context.getBean("user", User.class); // user对象
		System.out.println(baseEntity.getUk());
		System.out.println(baseEntity.getName()); // 拿到子类的name
	}
}

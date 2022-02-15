package com.testbean;

import com.testbean.config.AppConfig;
import com.testbean.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

		UserService service = (UserService) context.getBean("userService");
		System.out.println(service);

		service.test();

		service.insertData();
	}
}

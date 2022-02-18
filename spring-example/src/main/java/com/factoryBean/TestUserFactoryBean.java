package com.factoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/2/18 15:24
 */
public class TestUserFactoryBean {
	public static void main(String[] args) {
		// 添加扫描package路径
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Object user = context.getBean("userFactoryBean");
		System.out.println(user); // com.factoryBean.User@13eb8acf

		Object userFactoryBean = context.getBean("&userFactoryBean");
		System.out.println(userFactoryBean); // com.factoryBean.UserFactoryBean@51c8530f
	}
}

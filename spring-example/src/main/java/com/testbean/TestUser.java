package com.testbean;

import com.testbean.config.AppConfig;
import com.testbean.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/1/27 12:28
 */
public class TestUser {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = context.getBean(User.class);
		System.out.println(user);
		System.out.println(user.getId());
		System.out.println(user.getName());
	}
}

package com.thread.pool;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/6/14 10:32
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
		UserService userService = context.getBean(UserService.class);
		userService.test();
	}
}

package com.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/3/10 22:24
 */
public class TestAware {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CustomizeAware bean = context.getBean(CustomizeAware.class);
		System.out.println(bean);

		MyUtils.methodA();
	}
}

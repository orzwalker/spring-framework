package com.bean_post_processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBeanPostProcessor {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		int beanDefinitionCount = context.getBeanDefinitionCount();
		System.out.println(beanDefinitionCount);
	}

}

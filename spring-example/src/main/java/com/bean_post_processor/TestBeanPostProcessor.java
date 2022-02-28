package com.bean_post_processor;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class TestBeanPostProcessor {

	public static void main(String[] args) {
		System.out.println("\n\n=========================");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Map<String, HelloService> beansOfType = context.getBeansOfType(HelloService.class);
		beansOfType.entrySet().forEach(System.out::println);

		int beanDefinitionCount = context.getBeanDefinitionCount();
		System.out.println(beanDefinitionCount);

		LogicService logicService = context.getBean("logic", LogicService.class);
		logicService.testSayHello();

		System.out.println("=========================\n\n");
	}

}

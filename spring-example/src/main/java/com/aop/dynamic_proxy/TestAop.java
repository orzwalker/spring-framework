package com.aop.dynamic_proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AopService aopService = context.getBean(AopService.class);
		aopService.testAop();
		System.out.println("\n\n\n");
		aopService.testLogAspect();
	}
}

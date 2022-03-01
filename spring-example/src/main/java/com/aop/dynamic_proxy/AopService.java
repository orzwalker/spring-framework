package com.aop.dynamic_proxy;

import org.springframework.stereotype.Component;

@Component
public class AopService {

	public void testAop() {
		System.out.println("aop ...");
	}

	@LogAspect
	public void testLogAspect() {
		System.out.println("logAspect ...");
	}
}

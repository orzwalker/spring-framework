package com.aop.dynamic_proxy;

import org.springframework.stereotype.Component;

@Component
public class AopService {

	private Integer id;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public void testAop() {
		System.out.println("aop ...");
	}

	@LogAspect
	public void testLogAspect() {
		System.out.println("logAspect ...");
	}
}

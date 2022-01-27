package com.testbean.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/1/27 14:42
 */
@Component
@Aspect
public class UserAspect {

	@Before("execution(public void com.testbean.service.UserService.test())")
	public void process(JoinPoint joinPoint) {
		System.out.println("target : " + joinPoint.getTarget());
		System.out.println("aop before userService test ...");
	}
}

package com.aop.dynamic_proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspect {

	/**
	 * 切点
	 * 切点的写法----https://www.cnblogs.com/liaojie970/p/7883687.html
	 */
	@Pointcut("execution(* com.aop.dynamic_proxy.AopService.testAop())")
	public void pointcut(){
	}

	@Pointcut("@annotation(com.aop.dynamic_proxy.LogAspect)")
	public void logAspect(){
	}

	/**
	 * 前置通知
	 */
	@Before("pointcut() || logAspect()")
	public void before() {
		System.out.println("before test aop ...");
	}

	@Before("logAspect()")
	public void beforeLogAspect() {
		System.out.println("before log aspect  ...");
	}

	/**
	 * 后置通知
	 */
	@After("pointcut()")
	public void after() {
		System.out.println("after test aop ...");
	}

	/**
	 * 环绕通知
	 */
	@Around("pointcut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before...");
		pjp.proceed();
		System.out.println("around after...");
	}
}


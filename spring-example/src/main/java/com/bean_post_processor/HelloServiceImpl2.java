package com.bean_post_processor;

import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/2/18 16:53
 */
@Component
public class HelloServiceImpl2 implements HelloService{
	@Override
	public void sayHello() {
		System.out.println("hello service 2 ...");
	}
}

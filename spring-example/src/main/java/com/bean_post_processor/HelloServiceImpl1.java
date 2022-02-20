package com.bean_post_processor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author walker
 * @since 2022/2/18 16:53
 */
@Component
public class HelloServiceImpl1 implements HelloService{
	@Override
	public void sayHello() {
		System.out.println("hello service 1 ...");
	}
}

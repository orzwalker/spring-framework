package com.bean_post_processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/2/28 16:39
 */
@Component("logic")
public class LogicService {

	// 通过注解设置，本次需要哪个实现类
	@RoutingInjected("helloServiceImpl2")
	private HelloService helloService;

	public void testSayHello() {
		this.helloService.sayHello();
	}

}

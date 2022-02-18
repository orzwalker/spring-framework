package com.testbean.config;

import com.testbean.service.UserService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/2/18 16:21
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		if (bean instanceof UserService) {
			UserService userService = (UserService)bean;
			System.out.println(bean);
			System.out.println("before: " + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		if (bean instanceof UserService) {
			System.out.println(bean);
			System.out.println("after: " + beanName);
		}
		return bean;
	}

	/**
	 * 如果有多个BeanPostProcessor的实现类，执行顺序如何确定？
	 * 实现Ordered接口，设置返回值，执行时按从小到大顺序执行
	 * @return
	 */
	@Override
	public int getOrder() {
		return 0;
	}
}

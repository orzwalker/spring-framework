package com.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/3/10 23:43
 */
@Component
public class MyUtils implements ApplicationContextAware {

	/**
	 * 工具类中需要IOC容器中某个Bean，同时常规方法使用该工具类（不用注入）
	 */
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static void methodA() {
		CustomizeAware bean = context.getBean(CustomizeAware.class);
		System.out.println("工具类中，不用@AutoWired，就可以使用IOC容器中指定bean， " + bean);
	}
}

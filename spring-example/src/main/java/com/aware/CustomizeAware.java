package com.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/3/10 22:23
 */
@Component
public class CustomizeAware implements BeanNameAware,
		BeanFactoryAware,
		ApplicationContextAware,
		ResourceLoaderAware,
		BeanClassLoaderAware {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
// =====================================

	@Override
	public void setBeanName(String name) {
		setName(name);
		System.out.println("实现了BeanNameAware接口， beanName:" + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("实现了BeanFactoryAware接口，beanFactory:" + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("实现了ApplicationContextAware接口，applicationContext:" + applicationContext);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("实现了BeanClassLoaderAware接口，classLoader:" + classLoader);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("实现了ResourceLoaderAware接口，resourceLoader:" + resourceLoader);
	}
}

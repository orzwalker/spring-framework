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

	// 拿到这些容器的相关信息，进行特殊操作
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;
	private ClassLoader classLoader;
	private ResourceLoader resourceLoader;

	@Override
	public void setBeanName(String name) {
		System.out.println("实现了BeanNameAware接口， beanName:" + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("实现了BeanFactoryAware接口，beanFactory:" + this.beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("实现了ApplicationContextAware接口，applicationContext:" + this.applicationContext);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
		System.out.println("实现了BeanClassLoaderAware接口，classLoader:" + this.classLoader);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		System.out.println("实现了ResourceLoaderAware接口，resourceLoader:" + this.resourceLoader);
	}
}

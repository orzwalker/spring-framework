package com.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.NonNull;
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
		BeanClassLoaderAware,
		EnvironmentAware {

	// 拿到这些容器的相关信息，进行特殊操作
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;
	private ClassLoader classLoader;
	private ResourceLoader resourceLoader;
	private Environment environment;

	@Override
	public void setBeanName(@NonNull String name) {
		System.out.println("实现了BeanNameAware接口， beanName:" + name);
	}

	@Override
	public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("实现了BeanFactoryAware接口，beanFactory:" + this.beanFactory);
	}

	@Override
	public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("实现了ApplicationContextAware接口，applicationContext:" + this.applicationContext);
	}

	@Override
	public void setBeanClassLoader(@NonNull ClassLoader classLoader) {
		this.classLoader = classLoader;
		System.out.println("实现了BeanClassLoaderAware接口，classLoader:" + this.classLoader);
	}

	@Override
	public void setResourceLoader(@NonNull ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		System.out.println("实现了ResourceLoaderAware接口，resourceLoader:" + this.resourceLoader);
	}

	@Override
	public void setEnvironment(@NonNull Environment environment) {
		this.environment = environment;
		String[] activeProfiles = this.environment.getActiveProfiles();
		String[] defaultProfiles = this.environment.getDefaultProfiles();
		for (String activeProfile : activeProfiles) {
			System.out.println("activeProfile: " + activeProfile);
		}
		for (String defaultProfile : defaultProfiles) {
			System.out.println("defaultProfile: " + defaultProfile);
		}
		System.out.println("实现了EnvironmentAware接口，enviroment:" + this.environment);
	}
}

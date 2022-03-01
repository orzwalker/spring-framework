package com.aop.dynamic_proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 通过实现BeanFactoryPostProcessor接口，可以在Bean加载、注册完成后，做一些其他事情
 * customize 自定义的
 */
@Component
public class CustomizeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("aopService");
		MutablePropertyValues pv = abstractBeanDefinition.getPropertyValues();
		// 初始化前赋值
		pv.add("id", 1);
	}
}

package com.bean_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * https://cloud.tencent.com/developer/article/1376584
 *
 * @author walker
 * @since 2022/2/18 16:54
 */
public class HelloServiceInjectProcessor implements BeanPostProcessor {

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException, IllegalAccessException {
		Class<?> clazz = bean.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(RoutingInjected.class)) {
				// 字段的声明类型
				if (!field.getType().isInterface()) {
					// 如果不是接口，抛出异常
					throw new BeanCreationException("RoutingInjected 注解只支持接口");
				}
				handlerRoutingInjected(field, bean, field.getType());
			}
		}
		return bean;
	}

	private void handlerRoutingInjected(Field field, Object bean, Class<?> type) throws IllegalAccessException {
		// <beanName, instance>
		Map<String, ?> beansOfType = applicationContext.getBeansOfType(type);
		field.setAccessible(true);
		if (beansOfType.size() == 1) {
			// 设置bean这个对象的filed的value
			field.set(bean, beansOfType.values().iterator().next());
		} else if (beansOfType.size() == 2) {
			// 获取这个field注解上配置的value值
			String value = field.getAnnotation(RoutingInjected.class).value();
			// 重点----代理类
			// 如何拿到这个value对应的Object
			// 给新创建一个代理类，set到field的value上，执行时就会使用代理类
		} else {
			throw new IllegalAccessException(type + " 对应的bean超过2");
		}
	}
}

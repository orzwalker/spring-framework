package com.event.observer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author walker
 * @since 2022/12/30 16:52
 */
@Component
public class CustomContext implements ApplicationContextAware {

	ApplicationContext context;

	ExecutorService threadPool = Executors.newFixedThreadPool(2);

	@Override
	public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public ApplicationContext getContext() {
		/**
		 * 如果要保证观察值执行顺序，则不能使用线程池
		 * 使用@Order注解，样当第一个执行结束后，才会开始执行第2个
		 */
		// SimpleApplicationEventMulticaster eventMulticaster = context.getBean(SimpleApplicationEventMulticaster.class);
		// eventMulticaster.setTaskExecutor(threadPool);
		return this.context;
	}

	public ExecutorService getThreadPool() {
		return this.threadPool;
	}
}

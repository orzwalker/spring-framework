package com.thread.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author walker
 * @since 2022/6/14 10:21
 */
@Configuration
public class ThreadPoolConfig {

	private ThreadPoolTaskExecutor executor;

	/**
	 * 拒绝策略
	 * {@link java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy}
	 * {@link java.util.concurrent.ThreadPoolExecutor.AbortPolicy} Always throws RejectedExecutionException.
	 * {@link java.util.concurrent.ThreadPoolExecutor.DiscardPolicy}
	 * {@link java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy}
	 *
	 */
	@Bean
	public Executor executor() {
		int cpuNum = Runtime.getRuntime().availableProcessors();
		System.out.println("available processor num: " + cpuNum);
		executor = new ThreadPoolTaskExecutor();
		// 核心线程数
		executor.setCorePoolSize(cpuNum);
		executor.setMaxPoolSize(cpuNum * 2);
		// 几个不同拒绝策略的区别

		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 队列的作用，容量评估
		executor.setQueueCapacity(500);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		return executor;
	}
}

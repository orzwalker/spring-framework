package com.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author walker
 * @since 2022/5/20 11:38
 */
public class TestEvent {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		EventData eventData = new EventData();
		eventData.setId("aaaaaaaaaaaaaaa");
		eventData.setAction("update");
		eventData.setClazz(TestEvent.class);

		/**
		 * 使用线程池，event listener会使用子线程处理消费者逻辑，否则使用当前线程
		 */
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		SimpleApplicationEventMulticaster eventMulticaster = context.getBean(SimpleApplicationEventMulticaster.class);
		eventMulticaster.setTaskExecutor(threadPool);
		// ---------------------------------------------------------------


		context.publishEvent(new CustomizeApplicationEvent(Collections.singletonList(eventData)));

		context.publishEvent(new CustomizeApplicationEvent("bbbbbbbbbbbbbb", TestEvent.class, "delete"));

		threadPool.shutdown();
	}
}

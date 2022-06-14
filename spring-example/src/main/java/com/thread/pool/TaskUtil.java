package com.thread.pool;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author walker
 * @since 2022/6/14 10:28
 */
@Component
public class TaskUtil {

	@Resource
	private Executor taskExecutor;

	public void execute(Task task, CountDownLatch countDownLatch) {
		taskExecutor.execute(() -> {
			try {
				task.invoke();
			} finally {
				countDownLatch.countDown();
			}
		});
	}

}

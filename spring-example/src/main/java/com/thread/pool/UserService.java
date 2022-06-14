package com.thread.pool;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author walker
 * @since 2022/6/14 11:33
 */
@Service
public class UserService {

	@Resource
	private TaskUtil taskUtil;

	public void test() {
		int n = 20;
		CountDownLatch countDownLatch = new CountDownLatch(n);
		for (int i = 0; i < n; i++) {
			taskUtil.execute(() -> System.out.println(Thread.currentThread().getName()), countDownLatch);
		}
		boolean dealSuccess;
		try {
			dealSuccess = countDownLatch.await(3 * 1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			dealSuccess = false;
			Thread.currentThread().interrupt();
		}
		System.out.println("deal success : " + dealSuccess);
	}
}

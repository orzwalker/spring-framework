package com.event.observer;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/12/30 16:50
 */
@Component
public class FacultyDocRankObserver implements RankObserver {

	// 第1个执行结束后，才会开始执行第2个
	@Order(2)
	@EventListener
	@Override
	public void calcRank(RankEvent event) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " calc faculty doc rank, event:" + event);
		Thread.sleep(2*1000);
		System.out.println("calc faculty doc rank end");
	}
}

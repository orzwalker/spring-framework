package com.event.observer;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/12/30 16:50
 */
@Component
public class DiseaseDocRankObserver implements RankObserver{

	@Order(1)
	@EventListener
	@Override
	public void calcRank(RankEvent event) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " calc disease doc rank, event:" + event);
		Thread.sleep(2*1000);
		System.out.println("calc disease doc rank end");
	}
}

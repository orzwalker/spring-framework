package com.event.observer;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author walker
 * @since 2022/12/30 16:50
 */
@Component
public class DiseaseHospitalRankObserver implements RankObserver{

	@Order(3)
	@EventListener
	@Override
	public void calcRank(RankEvent event) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " calc disease hospital rank, event:" + event);
		Thread.sleep(2*1000);
		System.out.println("calc disease hospital rank end");
	}
}

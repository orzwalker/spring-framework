package com.event.observer;

/**
 * @author walker
 * @since 2022/12/30 16:49
 */
public interface RankObserver {
	void calcRank(RankEvent event) throws InterruptedException;
}

package com.thread.pool;

/**
 * @author walker
 * @since 2022/6/14 10:29
 */
@FunctionalInterface
public interface Task {

	void invoke();
}

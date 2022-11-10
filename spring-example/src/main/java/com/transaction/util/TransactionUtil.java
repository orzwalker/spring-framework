package com.transaction.util;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 事务相关工具方法
 *
 * @author walker
 * @since 2022/11/10 13:48
 */
public class TransactionUtil {

	/**
	 * 事务执行结束后，执行回调方法
	 */
	public static void doAfterTransaction(Runnable runnable) {
		if (TransactionSynchronizationManager.isActualTransactionActive()) {
			String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
			System.out.println("currentTransactionName:" + currentTransactionName + ", thread:" + Thread.currentThread().getName());
			TransactionSynchronizationManager.registerSynchronization(new DoTransactionCompletion(runnable));
		}
	}

}

class DoTransactionCompletion implements TransactionSynchronization {

	private final Runnable runnable;

	public DoTransactionCompletion(Runnable runnable) {
		this.runnable = runnable;
	}

	/**
	 * 事务执行完成，包含commit/rollback
	 */
	@Override
	public void afterCompletion(int status) {
		if (status == TransactionSynchronization.STATUS_COMMITTED) {
			// 事务已提交，执行回调方法
			System.out.println("事务commit，开始执行回调方法, thread:" + Thread.currentThread().getName());
			runnable.run();
		} else if (status == TransactionSynchronization.STATUS_ROLLED_BACK) {
			System.out.println("事务rollback，开始执行回调方法, thread:" + Thread.currentThread().getName());
		}
	}
}
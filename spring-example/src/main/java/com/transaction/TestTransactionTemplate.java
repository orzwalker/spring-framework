package com.transaction;

import com.transaction.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试编程式事务
 *
 * @author walker
 * @since 2022/7/15 11:30
 */
public class TestTransactionTemplate {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService bean = context.getBean(UserService.class);
		bean.test();
		bean.incrFiledD();
	}

}

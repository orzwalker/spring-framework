package com.transaction;

import com.transaction.util.TransactionUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author walker
 * @since 2022/7/15 13:27
 */
@Service
public class UserService {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private TransactionTemplate transactionTemplate;

	public void test() {
		String sql = "update a set c = c + 1 where id = 1";
		transactionTemplate.execute(status -> {
			jdbcTemplate.execute(sql);
			update();
			return null;
//			throw new RuntimeException("update 1 编程式事务异常...");
		});
	}

	public void update() {
		String sql = "update a set d = d + 1 where id = 1";
		transactionTemplate.execute(status -> {
			jdbcTemplate.execute(sql);
			return null;
			// 嵌套事务，有异常时，直接回滚所有事务
//			throw new RuntimeException("update 2 编程式事务异常...");
		});
	}

	@Transactional
	public void incrFiledD() {
		String sql = "update a set d = d + 1 where id = 1";
		jdbcTemplate.execute(sql);

		// 回调方法
		TransactionUtil.doAfterTransaction(() -> System.out.println("incrFiledD事务已提交，开始执行回调方法，thread:" + Thread.currentThread().getName()));
	}
}

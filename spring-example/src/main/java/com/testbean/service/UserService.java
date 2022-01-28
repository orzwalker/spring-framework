package com.testbean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author walker
 * @since 2022/1/27 15:10
 */
@Component
public class UserService {

	@Autowired
	private OrderService orderService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void test() {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(orderService);
	}

	/**
	 * 添加该注解后，会生成代理对象(AOP)，主要处理两件事：
	 * 1）通过事务管理器，创建数据库连接
	 * 2）修改autoCommit(false)，否则多个数据库操作自动提交，无法回滚
	 */
	@Transactional
	public void insertData() {
		String sql = "insert into a values(30, 30, 30)";
		jdbcTemplate.execute(sql);
		// 测试回滚
		// throw new RuntimeException("mysql");
	}
}

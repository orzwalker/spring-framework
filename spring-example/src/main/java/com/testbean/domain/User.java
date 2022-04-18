package com.testbean.domain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/1/27 12:26
 */
@Component
public class User extends BaseEntity implements InitializingBean {

	@Value("111")
	private Long id;
	@Value("xxx")
	private String name;


	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void test() {
		System.out.println("invoke test method ...");
	}

	// 初始化bean的回调
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化Bean-user结束，执行回调方法");
	}
}

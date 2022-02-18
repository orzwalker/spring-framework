package com.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 适用于Bean的创建过程比较复杂的过程，比如数据库连接池的创建
 *
 * @author walker
 * @since 2022/2/18 15:04
 */
@Component
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		// 假设User的实例化过程非常复杂
		User user = new User();
		user.setId(33L);
		user.setName("33");
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}

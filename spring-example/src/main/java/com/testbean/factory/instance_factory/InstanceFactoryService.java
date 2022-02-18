package com.testbean.factory.instance_factory;

import com.testbean.factory.User;
import org.springframework.stereotype.Component;

/**
 * 实例工厂模式，在初始化工厂容器时，才实例化工厂中的对象
 *
 * @author walker
 * @since 2022/2/18 15:00
 */
@Component
public class InstanceFactoryService {

	private User user;

	public InstanceFactoryService() {
		user = new User();
		user.setId(2L);
		user.setName("22");
	}

	public User getUserInstance() {
		return user;
	}
}

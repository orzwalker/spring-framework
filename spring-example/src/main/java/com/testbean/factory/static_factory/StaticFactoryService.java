package com.testbean.factory.static_factory;

import com.testbean.factory.User;
import org.springframework.stereotype.Component;

/**
 * 在初始化静态工厂类前，工厂中的对象已经实例化了
 *
 * @author walker
 * @since 2022/2/18 11:18
 */
@Component
public class StaticFactoryService {
	private static User user;

	static {
		user = new User();
		user.setId(1L);
		user.setName("11");
	}

	public static User getUserInstance() {
		return user;
	}
}

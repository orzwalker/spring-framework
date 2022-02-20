package com.bean_post_processor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.util.Map;

/**
 * @author walker
 * @since 2022/2/18 17:33
 */
public class RoutingBeanProxyFactory {
	private final static String DEFAULT_BEAN_NAME = "helloServiceImpl1";

	/**
	 * 创建代理类
	 *
	 * @param beanName   注解上设置的value值，也是HelloService接口实现类的beanName
	 * @param type       HelloService接口对象
	 * @param beansOfType 容器中type类型的bean  <beanName,instance>
	 * @return 代理类
	 */
	public static Object createProxy(String beanName, Class<?> type, Map<String, Object> beansOfType) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(type);
		Object instance = beansOfType.getOrDefault(beanName, null);
		proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(instance));

		return proxyFactory.getProxy();
	}

	static class VersionRoutingMethodInterceptor implements MethodInterceptor {
		private Object target;

		public VersionRoutingMethodInterceptor(Object instance) {
			this.target = instance;
			if (this.target == null) {
				this.target = DEFAULT_BEAN_NAME;
			}
		}

		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			return invocation.getMethod().invoke(target, invocation.getArguments());
		}
	}
}

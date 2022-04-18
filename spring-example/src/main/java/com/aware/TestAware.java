package com.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/3/10 22:24
 */
public class TestAware {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CustomizeAware bean = context.getBean(CustomizeAware.class);
		String[] aliases = context.getAliases("customizeAware");
		for (String alias : aliases) {
			System.out.println("alias: " + alias);
		}
		System.out.println(bean);

		MyUtils.methodA();

		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for (String profile : activeProfiles) {
			System.out.println("active profile: " + profile);
		}
	}
}

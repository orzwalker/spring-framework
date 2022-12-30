package com.event.observer;

import com.event.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/12/30 16:57
 */
public class TestObserver {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		DoctorBaseService doctorBaseService = context.getBean(DoctorBaseService.class);
		doctorBaseService.handlerDoctorBaseInfo();

		CustomContext customContext = context.getBean(CustomContext.class);
		customContext.getThreadPool().shutdown();
	}
}

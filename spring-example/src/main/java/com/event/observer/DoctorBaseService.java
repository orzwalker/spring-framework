package com.event.observer;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author walker
 * @since 2022/12/30 16:48
 */
@Service
public class DoctorBaseService {

	@Resource
	private CustomContext context;

	public void handlerDoctorBaseInfo() {
		System.out.println("calc rank...");
		RankEvent event = new RankEvent(10101L, "BaseData");
		ApplicationContext context = this.context.getContext();
		if (null != context) {
			context.publishEvent(event);
		}
	}
}

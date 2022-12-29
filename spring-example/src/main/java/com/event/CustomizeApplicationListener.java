package com.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/5/20 10:33
 */
@Component
public class CustomizeApplicationListener implements ApplicationListener<CustomizeApplicationEvent> {

	@Override
	public void onApplicationEvent(@NonNull CustomizeApplicationEvent event) {
		System.out.println(Thread.currentThread().getName() + "-interface ApplicationListener: " + JSON.toJSON(event).toString());
	}
}

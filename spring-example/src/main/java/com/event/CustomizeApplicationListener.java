package com.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/5/20 10:33
 */
@Component
public class CustomizeApplicationListener implements ApplicationListener<CustomizeApplicationEvent> {

	@Override
	public void onApplicationEvent(CustomizeApplicationEvent event) {
		String res = JSON.toJSON(event).toString();
		System.out.println(res);
	}
}

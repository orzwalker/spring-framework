package com.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/12/29 16:47
 */
@Component
public class AnnotationListener {

	@EventListener
	@Async
	public void eventListener(@NonNull CustomizeApplicationEvent event) {
		System.out.println(Thread.currentThread().getName() + "-annotation @EventListener: " + JSON.toJSON(event).toString());
	}
}

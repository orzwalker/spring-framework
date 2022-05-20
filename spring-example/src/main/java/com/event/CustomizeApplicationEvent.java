package com.event;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author walker
 * @since 2022/5/20 10:30
 */
@SuppressWarnings("serial")
public class CustomizeApplicationEvent extends ApplicationEvent {

	public CustomizeApplicationEvent(List<EventData> source) {
		super(source);
	}

	public CustomizeApplicationEvent(Serializable id, Class<?> clazz, String action) {
		super(Collections.singletonList(new EventData(id, clazz, action)));
	}
}

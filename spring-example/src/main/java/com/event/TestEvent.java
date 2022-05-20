package com.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;

/**
 * @author walker
 * @since 2022/5/20 11:38
 */
public class TestEvent {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		EventData eventData = new EventData();
		eventData.setId("aaaaaaaaaaaaaaa");
		eventData.setAction("update");
		eventData.setClazz(TestEvent.class);

		context.publishEvent(new CustomizeApplicationEvent(Collections.singletonList(eventData)));

		context.publishEvent(new CustomizeApplicationEvent("bbbbbbbbbbbbbb", TestEvent.class, "delete"));
	}
}

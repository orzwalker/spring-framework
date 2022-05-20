package com.event;

import java.io.Serializable;

/**
 * @author walker
 * @since 2022/5/20 11:17
 */
@SuppressWarnings("serial")
public class EventData implements Serializable {

	private Serializable id;
	private Class<?> clazz;
	private String action;

	public EventData() {

	}

	public EventData(Serializable id, Class<?> clazz, String action) {
		this.id = id;
		this.clazz = clazz;
		this.action = action;
	}

	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}

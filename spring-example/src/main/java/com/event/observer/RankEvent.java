package com.event.observer;

/**
 * @author walker
 * @since 2022/12/30 16:47
 */
public class RankEvent {

	private Long id;
	private Object other;

	public RankEvent() {
	}

	public RankEvent(Long id, Object other) {
		this.id = id;
		this.other = other;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "RankEvent{" +
				"id=" + id +
				", other=" + other +
				'}';
	}
}

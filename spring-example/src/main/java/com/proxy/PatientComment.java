package com.proxy;

/**
 * @author walker
 * @since 2024/4/5 11:46
 */
public class PatientComment implements Comment {
	@Override
	public void comment() {
		System.out.println("患者看完病后点评医生服务");
	}

	public String getContent() {
		return "patient content ...";
	}
}

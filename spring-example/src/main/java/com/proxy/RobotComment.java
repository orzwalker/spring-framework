package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author walker
 * @since 2024/4/5 11:47
 */
public class RobotComment implements InvocationHandler {

	private PatientComment patientComment;

	public RobotComment(PatientComment patientComment) {
		this.patientComment = patientComment;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("机器人代替患者点评 开始");
		method.invoke(patientComment, args);
		System.out.println("机器人代替患者点评 结束");
		return null;
	}
}

package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author walker
 * @since 2024/4/5 11:49
 */
public class CommentTest {
	public static void main(String[] args) {
		PatientComment patientComment = new PatientComment();

		InvocationHandler robotComment = new RobotComment(patientComment);
		Comment robotProxy = (Comment)Proxy.newProxyInstance(PatientComment.class.getClassLoader(), PatientComment.class.getInterfaces(), robotComment);
		robotProxy.comment();
		System.out.println(robotProxy.getClass().getName());

		InvocationHandler facultyComment = new FacultyComment(patientComment);
		Comment facultyProxy = (Comment)Proxy.newProxyInstance(PatientComment.class.getClassLoader(), PatientComment.class.getInterfaces(), facultyComment);
		facultyProxy.comment();
		System.out.println(facultyProxy.getClass().getName());
	}
}

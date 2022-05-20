package com.java_agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 自己实现的字节码转换器
 * @author walker
 * @since 2022/5/18 21:22
 */
public class CustomClassFileTransformer implements ClassFileTransformer {
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		System.out.println("普通的字节码转换器方法实现: ClassLoader" + loader.toString());
		return new byte[0];
	}

	public static void main(String[] args) {
		System.out.println("测试普通字节码转换器");
	}
}

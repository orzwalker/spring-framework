package com.bean_post_processor;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author walker
 * @since 2022/2/18 16:51
 */
@Target(ElementType.FIELD) // 只适用字段
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected {

	String value() default "helloServiceImpl1";
}

package com.aop.dynamic_proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author walker
 * @since 2022/2/18 15:39
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.aop.dynamic_proxy")
public class Config {
}

package ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author walker
 * @since 2022/3/24 15:46
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAutowired {

	/**
	 * @return 要注入的类的类型
	 */
	Class<?> value() default Class.class;

	/**
	 * @return bean名称
	 */
	String name() default "";
}

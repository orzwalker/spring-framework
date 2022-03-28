package ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 反射工具类
 *
 * @author walker
 * @since 2022/3/25 17:57
 */
public class ReflectUtil {

	private static final Log logger = LogFactory.getLog(ReflectUtil.class);

	/**
	 * 根据beanName创建对象实例
	 *
	 * @param beanName
	 * @return
	 */
	public static Object newInstance(String beanName) {
		Object ins = null;
		try {
			Class<?> clazz = Class.forName(beanName);
			ins = clazz.newInstance();
			throw new RuntimeException("运行时exception");
		} catch (Exception | Error e) {
			logger.error("reflect new instance exception, ex:" + e);
		}
		return ins;
	}
}

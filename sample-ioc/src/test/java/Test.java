import ioc.ReflectUtil;

/**
 * @author walker
 * @since 2022/3/23 16:30
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("sample ioc test");
		Object test = ReflectUtil.newInstance("Test");
		System.out.println(test);
	}
}

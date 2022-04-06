package com.testbean.config;

/**
 * @author walker
 * @since 2022/4/4 17:53
 */
public class DataSourceHolder {

	private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

	public void setDataSource(String key) {
		dataSourceKey.set(key);
	}

	public static String getDataSource()  {
		return dataSourceKey.get();
	}
}

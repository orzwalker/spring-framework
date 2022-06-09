package com.testbean.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author walker
 * @since 2022/4/4 17:46
 */
public class DynamicDataSourceConfig extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}
}

package com.testbean.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 动态数据源
 *
 * @author walker
 * @since 2022/4/4 17:46
 */
@Component
public class DynamicDataSourceConfig extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		if ()
		return null;
	}
}

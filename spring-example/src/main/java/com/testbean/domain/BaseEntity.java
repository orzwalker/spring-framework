package com.testbean.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author walker
 * @since 2022/3/28 15:07
 */
public class BaseEntity {

	@Value("xx_xx-xxxx")
	private String uk;
	@Value("name")
	private String name;

	public String getUk() {
		return uk;
	}

	public String getName() {
		return name;
	}
}

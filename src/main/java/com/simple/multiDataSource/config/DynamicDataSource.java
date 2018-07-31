package com.simple.multiDataSource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		DatabaseType databaseType = DataSourceContextHolder.getDatabaseType();
//		System.out.println("当前使用的数据库为："+databaseType);
		return databaseType;
	}

}

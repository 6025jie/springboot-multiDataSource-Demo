package com.simple.multiDataSource.config;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 数据源配置
 * 
 * @description
 * @author jiangwj
 * @date 2018年7月27日
 *
 */
@Configuration
@MapperScan(basePackages = "com.simple.multiDataSource.mapper")
public class DataSourceConfig {

	/**
	 * mysql
	 * @return
	 */
	@Bean(name = "mysqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * sqlserver
	 * @return
	 */
	@Bean(name = "sqlserverDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.sqlserver")
	public DataSource sqlServerDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public DynamicDataSource dataSource(@Qualifier("mysqlDataSource") DataSource mysqlDataSource,
			@Qualifier("sqlserverDataSource") DataSource sqlserverDataSource) {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DatabaseType.mysqlDb, mysqlDataSource);
		targetDataSources.put(DatabaseType.sqlserverDb, sqlserverDataSource);

		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
		dataSource.setDefaultTargetDataSource(mysqlDataSource);// 默认的datasource设置为mysqlDataSource

		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource,
			@Qualifier("sqlserverDataSource") DataSource sqlserverDataSource) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(this.dataSource(mysqlDataSource, sqlserverDataSource));
		fb.setTypeAliasesPackage("com.simple.multiDataSource.model");
		// 添加XML目录
		fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
		return fb.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * 配置事务管理器
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}

}

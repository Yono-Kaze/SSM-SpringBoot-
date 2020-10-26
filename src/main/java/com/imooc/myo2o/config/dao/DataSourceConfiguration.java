package com.imooc.myo2o.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imooc.myo2o.util.DESUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 *<p>Description:配置datasource到ioc容器中<p>	
 * @author Administrator
 * @version 2020-10-26
 *
 */
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.imooc.myo2o.dao")
public class DataSourceConfiguration {

	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUsername;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	/**
	 * 生成相应Spring-dao.xm的bean dataSource
	 * @throws PropertyVetoException 
	 */
	@Bean(name = "dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		//生成datasource实例
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		//配置连接池信息
		datasource.setDriverClass(jdbcDriver);
		datasource.setJdbcUrl(jdbcUrl);
		datasource.setUser(DESUtils.getDecryptString(jdbcUsername));
		datasource.setPassword(DESUtils.getDecryptString(jdbcPassword));
		//c3p0连接池的私有属性
		datasource.setMaxPoolSize(30);
		datasource.setMinPoolSize(10);
		//关闭连接后不自动commit
		datasource.setAutoCommitOnClose(false);
		//获取连接超时时间 -->
		datasource.setCheckoutTimeout(100000);
		//当获取连接失败重试次数 -->
		datasource.setAcquireRetryAttempts(2);
		return datasource;
	}

}

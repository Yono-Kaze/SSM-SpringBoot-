package com.imooc.myo2o.config.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 
 *<p>Description:对标spring-service中的transactionManager，继承TransactionManagementConfigurer是为了开启annotation-driven<p>	
 * @author Administrator
 * @version 2020-10-26
 *
 */
@Configuration
//使用该逐渐可以开启事务支持之后再service方法上添加@Transactional即可
@EnableTransactionManagement
public class TransactionManagerConfiguration implements TransactionManagementConfigurer{

	@Autowired
	private DataSource dataSource;
	/**
	 * 关于事务管理，需要返回PlatformTransactionManager的实现
	 */
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}

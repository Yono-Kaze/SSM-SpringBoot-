package com.imooc.myo2o.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 *<p>Description:配置SqlSessionFactory对象<p>	
 * @author Administrator
 * @version 2020-10-26
 *
 */
@Configuration
public class SessionFactoryConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	
	private static String mybatisConfigFile ;
	@Value("${mybatis_config_file}")
	public void setMybatisConfigFile(String mybatisConfigFile) {
		SessionFactoryConfiguration.mybatisConfigFile = mybatisConfigFile;
	}
	
	private static String mapperPath ;
	@Value("${mapper_path}")
	public void setMapperPath(String mapperPath) {
		SessionFactoryConfiguration.mapperPath = mapperPath;
	}

	//实体类所在包
	@Value("${type_ailas_package}")
	private String typeAilasPackage;
	
	/**
	 * 创建sqlSessionFactory实例，并且设置configtion设置和mapper映射路径
	 * 设置data数据源
	 * @throws IOException 
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//设置mybatis configuration扫描路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFile));
		//添加mapper扫描路径
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = 
				new PathMatchingResourcePatternResolver();
		String packageSearchpath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchpath));
		//设置dataSource
		sqlSessionFactoryBean.setDataSource(dataSource);
		//设置实体类包扫描路径
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAilasPackage);
		return sqlSessionFactoryBean;
	}

}

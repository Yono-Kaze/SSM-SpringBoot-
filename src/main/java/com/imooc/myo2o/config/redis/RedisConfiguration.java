package com.imooc.myo2o.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imooc.myo2o.cache.JedisPoolWriper;
import com.imooc.myo2o.cache.JedisUtil;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 *<p>Description:对标spring-redis.xml的配置<p>	
 * @author Administrator
 * @version 2020-10-26
 *
 */
@Configuration
public class RedisConfiguration {
	@Value("${redis.hostname}")
	private String hostname;
	@Value("${redis.port}")
	private int	port;
	@Value("${redis.database}")
	private int	database;
	@Value("${redis.pool.maxTotal}")
	private int	maxTotal;
	@Value("${redis.pool.maxIdle}")
	private int	maxIdle;
	@Value("${redis.pool.maxWaitMillis}")
	private long maxWaitMillis;
	@Value("${redis.pool.testOnBorrow}")
	private boolean	testOnBorrow;

	//Redis连接池配置
	@Autowired
	private JedisPoolConfig jedisPoolConfig;
	//创建Redis连接池，并且做相关配置
	@Autowired
	private JedisPoolWriper jedisWritePool;
	//创建Redis工具类
	@Autowired
	private JedisUtil jedisUtil;

	/**
	 * 初始化redis连接池的设置
	 * @return
	 */
	@Bean(name = "jedisPoolConfig")
	public JedisPoolConfig createJedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		return jedisPoolConfig;
	}

	/**
	 * 创建Redis连接池，并做相关配置
	 * 
	 * @return
	 */
	@Bean(name = "jedisWritePool")
	public JedisPoolWriper createJedisPoolWriper() {
		JedisPoolWriper jedisPoolWriper = new JedisPoolWriper(jedisPoolConfig, hostname, port);
		return jedisPoolWriper;
	}

	/**
	 * 创建Redis工具类
	 * @return
	 */
	@Bean(name = "jedisUtil")
	public JedisUtil createJedisUtil() {
		JedisUtil jedisUtil = new JedisUtil();
		jedisUtil.setJedisPool(jedisWritePool);
		return jedisUtil;
	}

	@Bean(name = "jedisKeys")
	public JedisUtil.Keys createJedisUtilKeys(){
		JedisUtil.Keys jedisKeys = jedisUtil.new Keys();
		return jedisKeys;
	}

	@Bean(name = "jedisStrings")
	public JedisUtil.Strings createJedisUtilStrings(){
		JedisUtil.Strings jedisStrings = jedisUtil.new Strings();
		return jedisStrings;
	}

}

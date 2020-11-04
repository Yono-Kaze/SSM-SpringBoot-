package com.imooc.myo2o.service;

/**
 * 
 *<p>Description:Redis的CacheService接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface CacheService {
	
	/**
	 * 依据key前缀删除匹配该模式下的所有key-value
	 * @param keyPrefix
	 */
	void removeFromCache(String keyPrefix);

}

package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.ShopAuthMapExecution;
import com.imooc.myo2o.entity.ShopAuthMap;

/**
 * 
 *<p>Description:ShopAuthMapService接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface ShopAuthMapService {
	/**
	 * 返回授权信息列表
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopAuthMapExecution listShopAuthMapByShopId(Long shopId,
			Integer pageIndex, Integer pageSize);

	/**
	 * 添加授权信息
	 * @param shopAuthMap
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap)
			throws RuntimeException;

	/**
	 * 更新授权信息，包括职位等
	 * 
	 * @param shopAuthId
	 * @param title
	 * @param titleFlag
	 * @param enableStatus
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws RuntimeException;

	/**
	 * 删除授权信息
	 * @param shopAuthMapId
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution removeShopAuthMap(Long shopAuthMapId)
			throws RuntimeException;

	/**
	 * 根据id返回授权信息
	 * @param shopAuthId
	 * @return
	 */
	ShopAuthMap getShopAuthMapById(Long shopAuthId);

}

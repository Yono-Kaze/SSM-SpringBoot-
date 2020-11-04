package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.UserProductMapExecution;
import com.imooc.myo2o.entity.UserProductMap;

/**
 * 
 *<p>Description:UserProductMapService的接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface UserProductMapService {
	/**
	 * 根据shopId返回相应用户消费记录列表数据
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserProductMapExecution listUserProductMap(
			UserProductMap userProductCondition, Integer pageIndex,
			Integer pageSize);

	/**
	 * 根据条件插入相应用户消费记录列表数据
	 * @param userProductMap
	 * @return
	 * @throws RuntimeException
	 */
	UserProductMapExecution addUserProductMap(UserProductMap userProductMap)
			throws RuntimeException;

}

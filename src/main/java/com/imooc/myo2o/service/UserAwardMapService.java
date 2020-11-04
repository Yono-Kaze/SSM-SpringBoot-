package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.UserAwardMapExecution;
import com.imooc.myo2o.entity.UserAwardMap;

/**
 * 
 *<p>Description:UserAwardMapService的接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface UserAwardMapService {

	/**
	 * 根据userAwardCondition返回相应用户奖品兑换记录列表数据
	 * @param userAwardCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserAwardMapExecution listUserAwardMap(UserAwardMap userAwardCondition,
			Integer pageIndex, Integer pageSize);

	/**
	 * 根据userAwardMapId返回相应用户奖品兑换记录列表数据
	 * @param userAwardMapId
	 * @return
	 */
	UserAwardMap getUserAwardMapById(long userAwardMapId);

	/**
	 * 根据条件插入相应用户奖品兑换记录列表数据
	 * @param userAwardMap
	 * @return
	 * @throws RuntimeException
	 */
	UserAwardMapExecution addUserAwardMap(UserAwardMap userAwardMap)
			throws RuntimeException;

	/**
	 * 根据条件更新相应用户奖品兑换记录列表数据
	 * @param userAwardMap
	 * @return
	 * @throws RuntimeException
	 */
	UserAwardMapExecution modifyUserAwardMap(UserAwardMap userAwardMap)
			throws RuntimeException;

}

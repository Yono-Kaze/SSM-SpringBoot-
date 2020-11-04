package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.UserShopMapExecution;
import com.imooc.myo2o.entity.UserShopMap;

/**
 * 
 *<p>Description:UserShopMapService接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface UserShopMapService {

	/**
	 * 根据userShopMapCondition返回用户商店积分列表
	 * @param userShopMapCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	UserShopMapExecution listUserShopMap(UserShopMap userShopMapCondition,
			int pageIndex, int pageSize);

}

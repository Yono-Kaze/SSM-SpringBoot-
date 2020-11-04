package com.imooc.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.UserShopMap;

/**
 * 
 *<p>Description:用户店铺积分Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface UserShopMapDao {
	/**
	 * 根据传入进来的查询条件分页返回用户店铺积分的列表
	 * @param userShopCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<UserShopMap> queryUserShopMapList(
			@Param("userShopCondition") UserShopMap userShopCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	UserShopMap queryUserShopMap(@Param("userId") long userId,
			@Param("shopId") long shopId);

	/**
	 * 根据传入进来的查询条件分页返回用户店铺积分的列表数量
	 * @param userShopCondition
	 * @return
	 */
	int queryUserShopMapCount(
			@Param("userShopCondition") UserShopMap userShopCondition);

	/**
	 * 根据传入进来的查询条件分页插入用户店铺积分的列表
	 * @param userShopMap
	 * @return
	 */
	int insertUserShopMap(UserShopMap userShopMap);

	/**
	 * 根据传入进来的查询条件分页更新用户店铺积分的列表
	 * @param userShopMap
	 * @return
	 */
	int updateUserShopMapPoint(UserShopMap userShopMap);

}

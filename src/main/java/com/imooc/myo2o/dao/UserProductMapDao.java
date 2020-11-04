package com.imooc.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.UserProductMap;

/**
 * 
 *<p>Description:用户消费记录Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface UserProductMapDao {
	/**
	 * 根据传入进来的查询条件分页返回用户消费记录的列表
	 * @param userProductCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<UserProductMap> queryUserProductMapList(
			@Param("userProductCondition") UserProductMap userProductCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	/**
	 * 根据传入进来的查询条件分页返回用户消费记录的列表数量
	 * @param userProductCondition
	 * @return
	 */
	int queryUserProductMapCount(
			@Param("userProductCondition") UserProductMap userProductCondition);

	/**
	 * 根据传入进来的查询条件分页插入用户消费记录的列表
	 * @param userProductMap
	 * @return
	 */
	int insertUserProductMap(UserProductMap userProductMap);
}

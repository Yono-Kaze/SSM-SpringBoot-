package com.imooc.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.PersonInfo;

/**
 * 
 *<p>Description:用户信息Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface PersonInfoDao {

	/**
	 * 根据条件返回用户信息列表
	 * @param personInfoCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<PersonInfo> queryPersonInfoList(
			@Param("personInfoCondition") PersonInfo personInfoCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	/**
	 * 根据条件返回用户信息列表数量
	 * @param personInfoCondition
	 * @return
	 */
	int queryPersonInfoCount(
			@Param("personInfoCondition") PersonInfo personInfoCondition);

	/**
	 * 根据条件返回用户信息列表
	 * @param userId
	 * @return
	 */
	PersonInfo queryPersonInfoById(long userId);

	/**
	 * 根据条件返回用户信息列表数量
	 * @param wechatAuth
	 * @return
	 */
	int insertPersonInfo(PersonInfo personInfo);

	/**
	 * 更新信息
	 * @param wechatAuth
	 * @return
	 */
	int updatePersonInfo(PersonInfo personInfo);

	/**
	 * 删除信息
	 * @param wechatAuth
	 * @return
	 */
	int deletePersonInfo(long userId);
}

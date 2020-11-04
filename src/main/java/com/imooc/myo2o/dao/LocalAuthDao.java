package com.imooc.myo2o.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.LocalAuth;

/**
 * 
 *<p>Description:本地用户类Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface LocalAuthDao {

	/**
	 * 根据条件返回用户列表
	 * @param userName
	 * @param password
	 * @return
	 */
	LocalAuth queryLocalByUserNameAndPwd(@Param("userName") String userName,
			@Param("password") String password);

	/**
	 * 根据条件返回用户列表
	 * @param userId
	 * @return
	 */
	LocalAuth queryLocalByUserId(@Param("userId") long userId);

	/**
	 * 根据条件返回用户列表数量
	 * @param localAuth
	 * @return
	 */
	int insertLocalAuth(LocalAuth localAuth);

	/**
	 * 更新
	 * @param localAuth
	 * @return
	 */
	int updateLocalAuth(@Param("userId") Long userId,
			@Param("userName") String userName,
			@Param("password") String password,
			@Param("newPassword") String newPassword,
			@Param("lastEditTime") Date lastEditTime);
}

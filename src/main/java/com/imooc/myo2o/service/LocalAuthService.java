package com.imooc.myo2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.LocalAuthExecution;
import com.imooc.myo2o.entity.LocalAuth;
import com.imooc.myo2o.exception.LocalAuthOperationExecution;

/**
 * 
 *<p>Description:LocalAuthService的接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface LocalAuthService {
	/**
	 * 根据传入条件返回列表
	 * @param userName
	 * @return
	 */
	LocalAuth getLocalAuthByUserNameAndPwd(String userName, String password);

	/**
	 * 根据传入id条件返回列表
	 * @param userId
	 * @return
	 */
	LocalAuth getLocalAuthByUserId(long userId);

	/**
	 * 根据传入条件插入
	 * @param localAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution register(LocalAuth localAuth,
			CommonsMultipartFile profileImg) throws LocalAuthOperationExecution;

	/**
	 * 根据传入条件绑定用户
	 * @param localAuth
	 * @return
	 * @throws RuntimeException
	 */
	LocalAuthExecution bindLocalAuth(LocalAuth localAuth)
			throws LocalAuthOperationExecution;

	/**
	 * 根据传入条件更新
	 * @param localAuthId
	 * @param userName
	 * @param password
	 * @param newPassword
	 * @param lastEditTime
	 * @return
	 */
	LocalAuthExecution modifyLocalAuth(Long userId, String userName,
			String password, String newPassword);
}

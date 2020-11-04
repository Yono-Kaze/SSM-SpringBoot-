package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.PersonInfoExecution;
import com.imooc.myo2o.entity.PersonInfo;

/**
 * 
 *<p>Description:PersonInfoService的接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface PersonInfoService {

	/**
	 * 根据传入id条件返回列表
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonInfoById(Long userId);

	/**
	 * 根据传入条件返回列表
	 * @param personInfoCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition,
			int pageIndex, int pageSize);

	/**
	 * 根据传入条件添加
	 * @param personInfo
	 * @return
	 */
	PersonInfoExecution addPersonInfo(PersonInfo personInfo);

	/**
	 * 根据传入条件更新
	 * @param personInfo
	 * @return
	 */
	PersonInfoExecution modifyPersonInfo(PersonInfo personInfo);

}

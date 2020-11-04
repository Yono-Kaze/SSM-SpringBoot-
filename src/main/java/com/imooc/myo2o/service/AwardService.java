package com.imooc.myo2o.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.AwardExecution;
import com.imooc.myo2o.entity.Award;

/**
 * 
 *<p>Description:AwardService接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface AwardService {

	/**
	 * 根据条件返回奖品列表
	 * @param awardCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	AwardExecution getAwardList(Award awardCondition, int pageIndex,
			int pageSize);

	/**
	 * 根据id条件返回奖品列表
	 * @param awardId
	 * @return
	 */
	Award getAwardById(long awardId);

	/**
	 * 根据条件添加奖品
	 * @param award
	 * @param thumbnail
	 * @return
	 */
	AwardExecution addAward(Award award, CommonsMultipartFile thumbnail);

	/**
	 * 根据条件更新奖品
	 * @param award
	 * @param thumbnail
	 * @param awardImgs
	 * @return
	 */
	AwardExecution modifyAward(Award award, CommonsMultipartFile thumbnail);

}

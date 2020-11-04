package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.WechatAuth;

/**
 * 
 *<p>Description:微信用户Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface WechatAuthDao {
	/**
	 * 
	 * @param openId
	 * @return
	 */
	WechatAuth queryWechatInfoByOpenId(String openId);

	/**
	 * 
	 * @param wechatAuth
	 * @return
	 */
	int insertWechatAuth(WechatAuth wechatAuth);

	/**
	 * 
	 * @param wechatAuthId
	 * @return
	 */
	int deleteWechatAuth(Long wechatAuthId);
}

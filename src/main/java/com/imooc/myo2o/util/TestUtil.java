package com.imooc.myo2o.util;

import javax.servlet.http.HttpServletRequest;

import com.imooc.myo2o.entity.Shop;

/**
 * 
 *<p>Description:测试时候常用的方法<p>	
 * @author Administrator
 * @version 2020-10-28
 *
 */
public class TestUtil {
	
	/**
	 *  向session中注入shop类
	 * @param request
	 */
	public static void setShopSession(HttpServletRequest request,Shop shop) {
		request.getSession().setAttribute("currentShop", shop);
	}

}

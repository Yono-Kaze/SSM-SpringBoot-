package com.imooc.myo2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 *<p>Description:验证码处理工具<p>	
 * @author Administrator
 * @version 2020-10-19
 *
 */
public class CodeUtil {
	
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//实际验证码
		String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//输入验证码
		String verifyCodeActual = HttpServletRequestUtil.getString(request,
				"verifyCodeActual");
		if (verifyCodeActual == null
				|| !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
			return false;
		}
		return true;
	}

}

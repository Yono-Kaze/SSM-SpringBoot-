package com.imooc.myo2o.web.frontend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 *<p>前端页面跳转路由<p>	
 * @author Administrator
 * @version 2020-11-2
 *
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	private String showMainPage() {
		return "frontend/mainpage";
	}

	@RequestMapping(value = "/productdetail", method = RequestMethod.GET)
	private String showProductDetail() {
		return "frontend/productdetail";
	}

	@RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
	private String showShopDetail() {
		return "frontend/shopdetail";
	}

	@RequestMapping(value = "/shoplist", method = RequestMethod.GET)
	private String showShopList() {
		return "frontend/shoplist";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String index() {
		return "frontend/index";
	}

	@RequestMapping(value = "/mypoint", method = RequestMethod.GET)
	private String myPoint() {
		return "frontend/mypoint";
	}

	@RequestMapping(value = "/myrecord", method = RequestMethod.GET)
	private String myRecord() {
		return "frontend/myrecord";
	}

	@RequestMapping(value = "/pointrecord", method = RequestMethod.GET)
	private String pointRecord() {
		return "frontend/pointrecord";
	}

	@RequestMapping(value = "/awarddetail", method = RequestMethod.GET)
	private String awardDetail() {
		return "frontend/awarddetail";
	}

	@RequestMapping(value = "/customerbind", method = RequestMethod.GET)
	private String customerBind() {
		return "frontend/customerbind";
	}
	
	@RequestMapping(value = "/ownerlogin")
	public String ownerLogin(HttpServletRequest request) {
		return "frontend/ownerlogin";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	private String register() {
		return "frontend/register";
	}
}

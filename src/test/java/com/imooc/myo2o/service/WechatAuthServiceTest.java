package com.imooc.myo2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.myo2o.dto.WechatAuthExecution;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.entity.WechatAuth;
import com.imooc.myo2o.enums.WechatAuthStateEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatAuthServiceTest {
	//13.6-13.11
	
	@Autowired
	private WechatAuthService wechatAuthService;
	
	@Test
	public void testRegister() {
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		String openId = "dafasagg";
		personInfo.setCreateTime(new Date());
		personInfo.setName("测试名字");
		personInfo.setUserType(1);
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId(openId);
		wechatAuth.setCreateTime(new Date());
		WechatAuthExecution wae = wechatAuthService.register(wechatAuth, null);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());
		wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
		System.out.println(wechatAuth.getPersonInfo().getName());
	}

}

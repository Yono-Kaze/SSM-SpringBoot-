package com.imooc.myo2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.imooc.myo2o.dto.LocalAuthExecution;
import com.imooc.myo2o.entity.LocalAuth;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.enums.WechatAuthStateEnum;
import com.imooc.myo2o.service.LocalAuthService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalAuthServiceTest {
	
	@Autowired
	private LocalAuthService localAuthService;
	
	@Test
	public void testABindLocalAuth() {
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String username = "testusername";
		String password = "testpassword";
		localAuth.setUserId(11L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUserName(username);
		localAuth.setPassword(password);
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		System.out.println(localAuth);
	}

}

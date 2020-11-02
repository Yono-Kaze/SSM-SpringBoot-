package com.imooc.myo2o.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopAuthMapDaoTest {
	
	@Autowired
	private ShopAuthMapDao shopAuthMapDao;
	
	@Test
	public void testDeleteShopAuthMap(){
		int se =shopAuthMapDao.deleteShopAuthMap(28L);
		System.out.println((se==1));
	}

}

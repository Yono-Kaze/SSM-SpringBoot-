package com.imooc.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.entity.ShopCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDaoTest {
	
	@Autowired
	private ShopDao shopDao;

	@Test
	public void testInsertShop(){
		Shop shop = new Shop();
		Area area = new Area();
		PersonInfo owner = new PersonInfo();
		ShopCategory sc = new ShopCategory();
		owner.setUserId(8L);
		area.setAreaId(3L);
		sc.setShopCategoryId(10L);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(sc);
		int effectedNum = shopDao.insertShop(shop);
		System.out.println(effectedNum);
	}
	
	@Test
	@Ignore
	public void testQueryByShopId() throws Exception {
		long shopId = 57;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println(shop);
	}

//	@Test
//	@Ignore
//	public void testBQueryByEmployeeId() throws Exception {
//		long employeeId = 1;
//		List<Shop> shopList = shopDao.queryByEmployeeId(employeeId);
//		for (Shop shop : shopList) {
//			System.out.println(shop);
//		}
//	}

	@Test
	@Ignore
	public void testQueryShopListAndCount(){
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(8L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("总数:" + count);
		System.out.println("大小:" + shopList.size());
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(10L);
		shopList = shopDao.queryShopList(shopCondition, 0, 2);
		count = shopDao.queryShopCount(shopCondition);
		System.out.println("总数:" + count);
		System.out.println("大小:" + shopList.size());
	}
	
	@Test
	public void testQueryShopListAndCount1(){
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(12L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("总数:" + count);
		System.out.println("大小:" + shopList.size());
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(10L);
		shopList = shopDao.queryShopList(shopCondition, 0, 2);
		count = shopDao.queryShopCount(shopCondition);
		System.out.println("总数:" + count);
		System.out.println("大小:" + shopList.size());
	}
	
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(35L);
		shop.setShopDesc("测试35");
		shop.setShopAddr("测试35");
		shop.setLastEditTime(new Date()); 
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}

//	@Test
//	@Ignore
//	public void testEDeleteShopByName() throws Exception {
//		String shopName = "mytest1";
//		int effectedNum = shopDao.deleteShopByName(shopName);
//		assertEquals(1, effectedNum);
//
//	}
}

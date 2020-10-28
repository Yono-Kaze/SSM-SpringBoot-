package com.imooc.myo2o.dao;

import static org.junit.Assert.assertEquals;


import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.myo2o.entity.Award;
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AwardDaoTest {

	@Autowired
	private AwardDao awardDao;

	@Test
	@Order(1)
	public void testAInsertAward() throws Exception {
		long shopId = 15;
		Award award = new Award();
		award.setAwardName("测试一");
		award.setAwardImg("test1");
		award.setPoint(5);
		award.setPriority(1);
		award.setEnableStatus(1);
		award.setCreateTime(new Date());
		award.setLastEditTime(new Date());
		award.setExpireTime(new Date());
		award.setShopId(shopId);
		int effectedNum = awardDao.insertAward(award);
		assertEquals(1, effectedNum);
	}

	@Test
	@Order(2)
	public void testBQueryAwardList() throws Exception {
		Award award = new Award();
		List<Award> awardList = awardDao.queryAwardList(award, 0, 3);
		assertEquals(1, awardList.size());
		int count = awardDao.queryAwardCount(award);
		assertEquals(1, count);
		award.setAwardName("测试");
		awardList = awardDao.queryAwardList(award, 0, 3);
		assertEquals(1, awardList.size());
		count = awardDao.queryAwardCount(award);
		assertEquals(1, count);
	}

	@Test
	@Order(3)
	public void testCQueryAwardByAwardId() throws Exception {
		Award awardCondition = new Award();
		awardCondition.setAwardName("测试");
		List<Award> awardList = awardDao.queryAwardList(awardCondition, 0, 1);
		assertEquals(1, awardList.size());
		Award award = awardDao.queryAwardByAwardId(awardList.get(0)
				.getAwardId());
		assertEquals("测试一", award.getAwardName());
	}
	
	@Test
	@Order(4)
	public void testDUpdateAward() throws Exception {
		Award award = new Award();
		award.setAwardId(4L);
		award.setShopId(15L);
		award.setAwardName("第一个奖品");
		int effectedNum = awardDao.updateAward(award);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Order(5)
	public void testEDeleteAward() throws Exception {
		Award awardCondition = new Award();
		awardCondition.setAwardName("测试");
		List<Award> awardList = awardDao.queryAwardList(awardCondition, 0, 1);
		assertEquals(1, awardList.size());
		int effectedNum = awardDao.deleteAward(awardList.get(0).getAwardId()
				,awardList.get(0).getShopId());
		assertEquals(1, effectedNum);
	}
}

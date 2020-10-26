package com.imooc.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.imooc.myo2o.entity.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//能让Junit按照顺序执行
public class ProductCategoryDaoTest {
	
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Test
	public void testAInsertProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setProductCategoryDesc("测试商品类别");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setLastEditTime(new Date());
		productCategory.setShopId(20L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setProductCategoryDesc("测试商品类别2");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setLastEditTime(new Date());
		productCategory2.setShopId(20L);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao
				.batchInsertProductCategory(productCategoryList);
		System.out.println(effectedNum);
	}

	@Test
	public void testBQueryByShopId() throws Exception {
		long shopId = 15;
		List<ProductCategory> productCategoryList = productCategoryDao
				.queryByShopId(shopId);
		System.out.println(productCategoryList);

	}

	@Test
	public void testCDeleteProductCategory() throws Exception {
		long shopId = 20;
		List<ProductCategory> productCategoryList = productCategoryDao
				.queryByShopId(shopId);
		int effectedNum = productCategoryDao.deleteProductCategory(
				productCategoryList.get(0).getProductCategoryId(), shopId);
		assertEquals(1, effectedNum);
		effectedNum = productCategoryDao.deleteProductCategory(
				productCategoryList.get(1).getProductCategoryId(), shopId);
		assertEquals(1, effectedNum);
	}
}

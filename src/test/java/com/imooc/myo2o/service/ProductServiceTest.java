package com.imooc.myo2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.enums.ProductStateEnum;
import com.imooc.myo2o.exception.ShopOperationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testModifyProduct() throws ShopOperationException, FileNotFoundException{
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(15L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(19L);
		product.setShop(shop);
		product.setProductId(26L);
		product.setProductCategory(pc);
		product.setProductName("正式商品1");
		product.setProductDesc("正式商品1");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		//创建缩略图文件流
		File thumbnailFile = new File("G:\\workspace\\zd\\item\\headtitle\\1.jpg");
		CommonsMultipartFile thumbnail = new CommonsMultipartFile((FileItem) thumbnailFile);
		//创建两个商品详情图文件并将它们添加到详情图列表中
		File productImg1 =new File("G:\\workspace\\zd\\item\\headtitle\\1.jpg");
		File productImg2 =new File("G:\\workspace\\zd\\item\\headtitle\\2.jpg");
		List<CommonsMultipartFile> productImgList = new ArrayList<CommonsMultipartFile>();
		productImgList.add(new CommonsMultipartFile((FileItem) productImg1));
		productImgList.add(new CommonsMultipartFile((FileItem) productImg2));
		//添加商品并且验证
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	
	@Test
	public void testAddProduct() throws ShopOperationException, FileNotFoundException{
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(15L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(10L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		//创建缩略图文件流
		File thumbnailFile = new File("G:\\\\workspace\\\\zd\\\\item\\\\headtitle\\\\2017061320371786788.jpg");
		CommonsMultipartFile thumbnail = new CommonsMultipartFile((FileItem) thumbnailFile);
		//创建两个商品详情图文件并将它们添加到详情图列表中
		File productImg1 =new File("G:\\workspace\\zd\\item\\headtitle\\2017061320371786788.jpg");
		File productImg2 =new File("G:\\workspace\\zd\\item\\headtitle\\2017061320315746624.jpg");
		List<CommonsMultipartFile> productImgList = new ArrayList<CommonsMultipartFile>();
		productImgList.add(new CommonsMultipartFile((FileItem) productImg1));
		productImgList.add(new CommonsMultipartFile((FileItem) productImg2));
		//添加商品并且验证
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	

	

	
}

package com.imooc.myo2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.ImageHolder;
import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.enums.ProductStateEnum;
import com.imooc.myo2o.enums.ShopStateEnum;
import com.imooc.myo2o.exception.ShopOperationException;
import com.imooc.myo2o.util.FileDeal;
import com.mysql.cj.protocol.FullReadInputStream;

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
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
		//创建两个商品详情图文件并将它们添加到详情图列表中
		File productImg1 =new File("G:\\workspace\\zd\\item\\headtitle\\1.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 =new File("G:\\workspace\\zd\\item\\headtitle\\2.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
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
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
		//创建两个商品详情图文件并将它们添加到详情图列表中
		File productImg1 =new File("G:\\workspace\\zd\\item\\headtitle\\2017061320371786788.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 =new File("G:\\workspace\\zd\\item\\headtitle\\2017061320315746624.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		//添加商品并且验证
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	

	

	
}

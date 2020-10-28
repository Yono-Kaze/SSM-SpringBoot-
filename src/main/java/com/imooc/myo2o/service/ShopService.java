package com.imooc.myo2o.service;

import java.io.InputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.exception.ShopOperationException;

public interface ShopService {
	
	/**
	 * 根据shopCondition返回相应店铺列表数据
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
	/**
	 * 更新店铺信息 包括对图片的处理
	 * 
	 * @param Shop
	 * @param ShopImg   
	 * @return 
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException;
	
	/**
	 * 查询指定店铺信息
	 * 
	 * @param long
	 *            shopId
	 * @return Shop shop
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 创建商铺
	 * 
	 * @param Shop
	 *            shop
	 * @return ShopExecution shopExecution
	 * @throws Exception
	 */
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImgFile) throws ShopOperationException;

}

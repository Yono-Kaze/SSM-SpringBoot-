package com.imooc.myo2o.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.ShopCategoryExecution;
import com.imooc.myo2o.entity.ShopCategory;

/**
 * 
 *<p>Description:ShopCategoryService的接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface ShopCategoryService {
	
	public static final String SCLISTKEY = "shopcategorylist";
	
	/**
	 * 
	 * @param shopCategoryCondition
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);

	/**
	 * 获取一级商铺目录
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;
	

	/**
	 * 获取一级商铺目录
	 * @param parentId
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryListById(Long parentId) throws IOException;

	/**
	 * 获取所有商铺目录
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getAllSecondLevelShopCategory() throws IOException;

	/**
	 * 获取id商铺目录
	 * @param shopCategory
	 * @return
	 */
	ShopCategory getShopCategoryById(Long shopCategoryId);

	/**
	 * 添加商铺目录
	 * @param shopCategory
	 * @param thumbnail
	 * @return
	 */
	ShopCategoryExecution addShopCategory(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail);

	/**
	 * 更新商铺目录
	 * @param shopCategory
	 * @param thumbnail
	 * @param thumbnailChange
	 * @return
	 */
	ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail, boolean thumbnailChange);

	/**
	 * 用过id移除商铺目录
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategoryExecution removeShopCategory(long shopCategoryId);

	/**
	 * 批量移除商铺目录
	 * @param shopCategoryIdList
	 * @return
	 */
	ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList);


}

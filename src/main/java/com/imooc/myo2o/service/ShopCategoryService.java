package com.imooc.myo2o.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.ShopCategoryExecution;
import com.imooc.myo2o.entity.ShopCategory;

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
	 * 
	 * @param parentId
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getShopCategoryListById(Long parentId) throws IOException;

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	List<ShopCategory> getAllSecondLevelShopCategory() throws IOException;

	/**
	 * 
	 * @param shopCategory
	 * @return
	 */
	ShopCategory getShopCategoryById(Long shopCategoryId);

	/**
	 * 
	 * @param shopCategory
	 * @param thumbnail
	 * @return
	 */
	ShopCategoryExecution addShopCategory(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail);

	/**
	 * 
	 * @param shopCategory
	 * @param thumbnail
	 * @param thumbnailChange
	 * @return
	 */
	ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory,
			CommonsMultipartFile thumbnail, boolean thumbnailChange);

	/**
	 * 
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategoryExecution removeShopCategory(long shopCategoryId);

	/**
	 * 
	 * @param shopCategoryIdList
	 * @return
	 */
	ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList);


}

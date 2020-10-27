package com.imooc.myo2o.service;

import java.io.IOException;
import java.util.List;

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

}

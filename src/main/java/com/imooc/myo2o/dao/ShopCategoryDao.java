package com.imooc.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.ShopCategory;

/**
 * 
 *<p>Description:店铺类别Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public  interface ShopCategoryDao {

	/**
	 * 根据条件返回店铺分类列表
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(
			@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);

	/**
	 * 根据id条件返回店铺分类
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategory queryShopCategoryById(long shopCategoryId);

	/**
	 * 根据id条件返回店铺分类列表
	 * @param shopCategoryIdList
	 * @return
	 */
	List<ShopCategory> queryShopCategoryByIds(List<Long> shopCategoryIdList);

	/**
	 * 根据条件返回店铺分类列表数量
	 * @param shopCategory
	 * @return
	 */
	int insertShopCategory(ShopCategory shopCategory);

	/**
	 * 更新分类
	 * @param shopCategory
	 * @return
	 */
	int updateShopCategory(ShopCategory shopCategory);

	/**
	 * 删除分类
	 * @param shopCategoryId
	 * @return
	 */
	int deleteShopCategory(long shopCategoryId);

	/**
	 * 批量添加
	 * @param shopCategoryIdList
	 * @return
	 */
	int batchDeleteShopCategory(List<Long> shopCategoryIdList);

}

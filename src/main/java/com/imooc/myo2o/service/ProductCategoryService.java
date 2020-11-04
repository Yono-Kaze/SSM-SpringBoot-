package com.imooc.myo2o.service;

import java.util.List;

import com.imooc.myo2o.dto.ProductCategoryExecution;
import com.imooc.myo2o.entity.ProductCategory;

/**
 * 
 *<p>Description:ProductCategoryService的接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface ProductCategoryService {
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * 
	 * @param long shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getByShopId(long shopId);

	/**
	 * 查询指定某个店铺下的所有商品类别信息列表
	 * @param productCategory
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution batchAddProductCategory(
			List<ProductCategory> productCategoryList) throws RuntimeException;

	/**
	 * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId,
			long shopId) throws RuntimeException;
}

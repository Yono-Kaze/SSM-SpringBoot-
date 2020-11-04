package com.imooc.myo2o.dao;

import java.util.List;

import com.imooc.myo2o.entity.ProductImg;

/**
 * 
 *<p>Description:图片类Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface ProductImgDao {

	/**
	 * 根据条件返回图片列表
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);

	/**
	 * 批量添加商品详情图片
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);

	/**
	 * 删除图片
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
}

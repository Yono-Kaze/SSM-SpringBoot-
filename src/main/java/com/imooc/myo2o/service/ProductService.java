package com.imooc.myo2o.service;


import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.ImageHolder;
import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.exception.ProductOperationExecution;

public interface ProductService {
	/**
	 * 商品列表的分页查询,商品名为模糊查询
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	/**
	 * 按照id获得商品信息
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * 添加商品信息以及图片处理
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationExecution
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, 
			List<ImageHolder> productImgs)
			throws ProductOperationExecution;

	/**
	 * 更新商品信息
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationExecution
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
			List<ImageHolder> productImgsHolderList) throws ProductOperationExecution;
}

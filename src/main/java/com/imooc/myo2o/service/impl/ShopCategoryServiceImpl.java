package com.imooc.myo2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.cache.JedisUtil;
import com.imooc.myo2o.dao.ShopCategoryDao;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.exception.AreaOperationException;
import com.imooc.myo2o.exception.ShopCategoryOperationException;
import com.imooc.myo2o.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl  implements ShopCategoryService{
	@Autowired
	private JedisUtil.Strings jedisStrings;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	private static Logger logger = LoggerFactory.getLogger(ShopCategoryServiceImpl.class);
	
	/**
	 *根据查询条件获取shopCategoryCondition
	 */
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
		String key = SCLISTKEY + "_" + shopCategory.getParentId();
		List<ShopCategory> shopCategoryList = null;
		ObjectMapper mapper = new ObjectMapper();
		if (!jedisKeys.exists(key)) {
			ShopCategory shopCategoryCondition = new ShopCategory();
			shopCategoryCondition.setParentId(shopCategory.getParentId());
			shopCategoryList = shopCategoryDao
					.queryShopCategory(shopCategoryCondition);
			String jsonString;
			try {
				jsonString = mapper.writeValueAsString(shopCategoryList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new ShopCategoryOperationException(e.getMessage());
			}
			jedisStrings.set(key, jsonString);
		} else {
			String jsonString = jedisStrings.get(key);
			JavaType javaType = mapper.getTypeFactory()
					.constructParametricType(ArrayList.class,
							ShopCategory.class);
			try {
				shopCategoryList = mapper.readValue(jsonString, javaType);
			} catch (JsonParseException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new ShopCategoryOperationException(e.getMessage());
			} catch (JsonMappingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new ShopCategoryOperationException(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				throw new ShopCategoryOperationException(e.getMessage());
			}
		}
		return shopCategoryList;
	}

}

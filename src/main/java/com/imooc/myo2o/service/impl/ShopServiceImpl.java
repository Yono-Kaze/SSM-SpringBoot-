package com.imooc.myo2o.service.impl;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.imooc.myo2o.dao.ShopDao;
import com.imooc.myo2o.dto.ImageHolder;
import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.enums.ShopStateEnum;
import com.imooc.myo2o.exception.ShopOperationException;
import com.imooc.myo2o.service.ShopService;
import com.imooc.myo2o.util.FileUtil;
import com.imooc.myo2o.util.ImageUtil;
import com.imooc.myo2o.util.PageCalculator;


@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;
	

	/**
	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 */
	@Transactional
	@Override
	public ShopExecution addShop(Shop shop, ImageHolder shopImgFile) {
		//空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		}
		try {
			//给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				try {
					if (shopImgFile.getImage() != null) {
						//存储图片
						addShopImg(shop, shopImgFile);
					}
				} catch (Exception e) {
					throw new ShopOperationException("addShopImg error: "
							+ e.getMessage());
				}
				//更新店铺图片地址
				effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					throw new ShopOperationException("创建图片地址失败");
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("insertShop error: " + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}

	private void addShopImg(Shop shop, ImageHolder shopImgInputStream) {
		//获取shop图片目录的相对值路径
		String dest = FileUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Override
	public ShopExecution modifyShop(Shop shop, ImageHolder shopImg)
			throws ShopOperationException {
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOPID);
		} else {
			try {
				//判断是否需要处理图片
				if (shopImg != null && shopImg.getImage() != null && shopImg.getImageName() != null && !"".equals(shopImg.getImageName())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						FileUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop, shopImg);
				}
				//更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {// 创建成功
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (ShopOperationException e) {
				throw new ShopOperationException("modifyShop error: "
						+ e.getMessage());
			}
		}
	}

	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex,
				pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution se = new ShopExecution();
		if (shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		} else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}



}

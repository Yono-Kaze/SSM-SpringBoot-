package com.imooc.myo2o.dao;

import java.util.List;

import com.imooc.myo2o.entity.Area;

/**
 * 
 *<p>Description:区域类Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface AreaDao {
	/**
	 * 列出地域列表
	 * 
	 * @param areaCondition
	 * @return
	 */
	List<Area> queryArea();

	/**
	 * 列出地域总数
	 * @param area
	 * @return
	 */
	int insertArea(Area area);

	/**
	 * 更新地域
	 * @param area
	 * @return
	 */
	int updateArea(Area area);

	/**
	 * 删除地域
	 * @param areaId
	 * @return
	 */
	int deleteArea(long areaId);

	/**
	 * 批量添加地域
	 * @param areaIdList
	 * @return
	 */
	int batchDeleteArea(List<Long> areaIdList);
}

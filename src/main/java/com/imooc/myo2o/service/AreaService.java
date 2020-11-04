package com.imooc.myo2o.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.myo2o.dto.AreaExecution;
import com.imooc.myo2o.entity.Area;

/**
 * 
 *<p>Description:AreaService接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface AreaService {
	
	public static final String AREALISTKEY = "arealist";
	
	/**
	 * 获取全部区域列表
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	List<Area> getAreaList() throws JsonParseException, JsonMappingException,
			IOException;

	/**
	 * 添加区域
	 * @param area
	 * @return
	 */
	AreaExecution addArea(Area area);

	/**
	 * 更新区域信息
	 * @param area
	 * @return
	 */
	AreaExecution modifyArea(Area area);

	/**
	 * 删除区域
	 * @param areaId
	 * @return
	 */
	AreaExecution removeArea(long areaId);

	/**
	 * 批量删除区域
	 * @param areaIdList
	 * @return
	 */
	AreaExecution removeAreaList(List<Long> areaIdList);
	



}

package com.imooc.myo2o.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.myo2o.dto.HeadLineExecution;
import com.imooc.myo2o.entity.HeadLine;

/**
 * 
 *<p>Description:HeadLineService接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface HeadLineService {
	
	public static final String HLLISTKEY = "headlinelist";

	/**
	 * 根据传入条件返回列表
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition)
			throws IOException;

	/**
	 * 根据传入条件插入头条
	 * @param headLine
	 * @param thumbnail
	 * @return
	 */
	HeadLineExecution addHeadLine(HeadLine headLine,
			CommonsMultipartFile thumbnail);

	/**
	 * 根据传入条件更新头条
	 * @param headLine
	 * @param thumbnail
	 * @param thumbnailChange
	 * @return
	 */
	HeadLineExecution modifyHeadLine(HeadLine headLine,
			CommonsMultipartFile thumbnail);

	/**
	 * 根据传入条件删除头条
	 * @param headLineId
	 * @return
	 */
	HeadLineExecution removeHeadLine(long headLineId);

	/**
	 * 根据传入条件批量删除头条
	 * @param headLineIdList
	 * @return
	 */
	HeadLineExecution removeHeadLineList(List<Long> headLineIdList);

}

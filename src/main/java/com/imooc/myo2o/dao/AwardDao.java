package com.imooc.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.myo2o.entity.Award;

/**
 * 
 *<p>Description:奖品类Dao接口<p>	
 * @author Administrator
 * @version 2020-11-4
 *
 */
public interface AwardDao {
	
	/**
	 * 依据传进来的查询条件分页显示奖品信息列表
	 * @param awardCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Award> queryAwardList(@Param("awardCondition") Award awardCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

	/**
	 * 配合queryAwardCount返回相同查询条件下的奖品数
	 * @param awardCondition
	 * @return
	 */
	int queryAwardCount(@Param("awardCondition") Award awardCondition);

	/**
	 * 通过awardId查询奖品
	 * @param awardId
	 * @return
	 */
	Award queryAwardByAwardId(long awardId);

	/**
	 * 添加奖品信息
	 * @param award
	 * @return
	 */
	int insertAward(Award award);

	/**
	 * 更新奖品信息
	 * @param award
	 * @return
	 */
	int updateAward(Award award);

	/**
	 * 删除奖品信息
	 * @param awardId
	 * @param shopId
	 * @return
	 */
	int deleteAward(@Param("awardId") long awardId,@Param("shopId") long shopId);
}

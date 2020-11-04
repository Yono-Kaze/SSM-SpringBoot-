package com.imooc.myo2o.web.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.myo2o.dto.AwardExecution;
import com.imooc.myo2o.entity.Award;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.service.AwardService;
import com.imooc.myo2o.util.HttpServletRequestUtil;

/**
 * 
 *前端部分奖品的处理
 * @author Administrator
 * @version 2020-11-2
 *
 */
@Controller
@RequestMapping("/frontend")
public class AwardController {
	
	@Autowired
	private AwardService awardService;

	/**
	 * 按照商店id店铺下的所有奖品
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/listawardsbyshop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listAwardsByShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		Shop currentShop = (Shop) request.getSession().getAttribute(
				"currentShop");
		if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null)
				&& (currentShop.getShopId() != null)) {
			String awardName = HttpServletRequestUtil.getString(request,
					"awardName");
			Award awardCondition = compactAwardCondition4Search(
					currentShop.getShopId(), awardName);
			int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
			if(enableStatus != -1) {
				awardCondition.setEnableStatus(1);
			}
			AwardExecution ae = awardService.getAwardList(awardCondition,
					pageIndex, pageSize);
			modelMap.put("awardList", ae.getAwardList());
			modelMap.put("count", ae.getCount());
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
		}
		return modelMap;
	}

	/**
	 * 通过ID查找奖品
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getawardbyid", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getAwardbyId(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		long awardId = HttpServletRequestUtil.getLong(request, "awardId");
		if (awardId > -1) {
			Award award = awardService.getAwardById(awardId);
			modelMap.put("award", award);
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty awardId");
		}
		return modelMap;
	}

	private Award compactAwardCondition4Search(long shopId, String awardName) {
		Award awardCondition = new Award();
		awardCondition.setShopId(shopId);
		if (awardName != null) {
			awardCondition.setAwardName(awardName);
		}
		return awardCondition;
	}
	

}

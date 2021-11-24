/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.campaign.Campaign;
import ltd.newbee.mall.service.CategoryOrGoodsService;
import ltd.newbee.mall.util.BeanUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CampaignController {

	@Resource
	private CategoryOrGoodsService categoryOrGoodsService;

	@GetMapping("/campaign")
	public String detailPage(HttpServletRequest request) {
		// 1.campaignList
		List<Campaign> campaignList = categoryOrGoodsService.dropDownList();
		List<Campaign> campaignVOList = BeanUtil.copyList(campaignList, Campaign.class);
		request.setAttribute("campaign", campaignVOList);

		// 2.apply campaign
		long parentId = 0;
		ArrayList<ApplyGoodsCampaign> goodsList = categoryOrGoodsService.getApplyGoods(parentId);
		ArrayList<ApplyCategoryCampaign> categoryList = categoryOrGoodsService.getApplyCategory(parentId);
		if (categoryList != null && !categoryList.isEmpty()) {
			List<ApplyCategoryCampaign> gOrcList = BeanUtil.copyList(categoryList, ApplyCategoryCampaign.class);
			request.setAttribute("gOrcList", gOrcList);
		} else {
			List<ApplyGoodsCampaign> gOrcList = BeanUtil.copyList(goodsList, ApplyGoodsCampaign.class);
			request.setAttribute("gOrcList", gOrcList);
		}
		
	    // 3.show more
		// 4.modal  


		return "mall/campaign";
	}

}

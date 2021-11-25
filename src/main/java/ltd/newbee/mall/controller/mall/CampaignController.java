/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.service.CampaignService;
import ltd.newbee.mall.util.BeanUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CampaignController {

    @Resource
    private CampaignService campaignService;

    @GetMapping("/campaigns/dropDownList/campaignList")
    public String detailPage(HttpServletRequest request) throws ParseException {
        // categoryList
    	long parentId = 0;
        ArrayList<CampaignCategory> categoryEntityList = campaignService.getCampaignCategory(parentId);
        ArrayList<CampaignCategory> categoryList = (ArrayList<CampaignCategory>) BeanUtil.copyList(categoryEntityList, CampaignCategory.class);
        
        // campaignList
        //List<CampaignCategory> categoryDropDownList = campaignService.getCategoryDropDownList(campaignName);
        List<CampaignCategory> categoryDropDownList = campaignService.dropDownList();
        List<CampaignCategory> campaignList = (List<CampaignCategory>) BeanUtil.copyList(categoryDropDownList, CampaignCategory.class);
        
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("campaignList", campaignList);
        return "mall/campaigns";
    }

}
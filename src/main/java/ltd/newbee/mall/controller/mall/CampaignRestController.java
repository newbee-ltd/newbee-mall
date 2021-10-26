/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.CampaignCategory;
import ltd.newbee.mall.entity.CampaignGoods;
import ltd.newbee.mall.service.CampaignService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Controller
public class CampaignRestController {

    @Resource
    private CampaignService campaignService;
    
    // campaign查询
    @RequestMapping(value = "/campaigns", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam long parentId) {
    	
    	ArrayList<CampaignGoods> goodsList = campaignService.getCampaignGoods(parentId);
    	if (goodsList != null && goodsList.size() > 0) {
    		return ResultGenerator.genSuccessResult(goodsList);
    	} else {
    		ArrayList<CampaignCategory> categoryList = campaignService.getCampaignCategory(parentId);
    		return ResultGenerator.genSuccessResult(categoryList);
    	}
    }
    
    // キャンペーン適用(商品)
    @RequestMapping(value = "/campaigns/goods", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaignGoods(@RequestBody CampaignGoods campaignGoods) {
    	
    	long count = campaignService.insertCampaignGoods(campaignGoods);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGNGOODS_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNINSERT_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
    // キャンペーン適用(カテゴリー)
    @RequestMapping(value = "/campaigns/category", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaignCategory(@RequestBody CampaignCategory campaignCategory) {
    	
    	long count = campaignService.insertCampaignCategory(campaignCategory);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGNCATEGORY_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNINSERT_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
    // キャンペーン削除(商品)
    @PutMapping(value = "/campaigns/goods")
    @ResponseBody
    public Result updateCampaignGoods(@RequestBody CampaignGoods campaignGoods) {
    	
    	long countUpdateCampaignGoods = campaignService.updateCampaignGoods(campaignGoods);
    	if (countUpdateCampaignGoods <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGN_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNDELETE_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
 	// キャンペーン削除(カテゴリー)
    @PutMapping(value = "/campaigns/category")
    @ResponseBody
    public Result updateCampaignCategory(@RequestBody CampaignCategory campaignCategory) {
    	
    	long countUpdateCampaignCategory = campaignService.updateCampaignCategory(campaignCategory);
    	if (countUpdateCampaignCategory <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.CAMPAIGN_FETCH_ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(Constants.CAMPAIGNDELETE_FETCH_SUCCESS_MESSAGE);
    	}
    }
    
    // キャンペーン情報のdropDownListのAPI
    @RequestMapping(value = "/campaigns/dropDownList", method = RequestMethod.GET)
    @ResponseBody
    public Result dropDownList(@RequestParam String campaignName) {
    	
    	List<CampaignGoods> goodsDropDownList = campaignService.getGoodsDropDownList(campaignName);
    	List<CampaignCategory> categoryDropDownList = campaignService.getCategoryDropDownList(campaignName);
    	if (CollectionUtils.isEmpty(goodsDropDownList) && CollectionUtils.isEmpty(categoryDropDownList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(goodsDropDownList.addAll(goodsDropDownList));
    	}
    }
}

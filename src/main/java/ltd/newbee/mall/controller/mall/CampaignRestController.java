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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import javax.annotation.Resource;

@Controller
public class CampaignRestController {

    @Resource
    private CampaignService campaignService;
    
    // campaign查询
    @RequestMapping(value = "/campaign", method = RequestMethod.GET)
    @ResponseBody
    public Result list(CampaignGoods campaignGoods, CampaignCategory campaignCategory) {
    	
    	ArrayList<CampaignGoods> goodsList = campaignService.getCampaignGoods(campaignGoods);
    	ArrayList<CampaignCategory> categoryList = campaignService.getCampaignCategory(campaignCategory);
    	if (goodsList.size() == 0 && categoryList.size() == 0) {
    		return ResultGenerator.genErrorResult(300, "Error!");
    	} else if (goodsList.size() > 0) {
    		return ResultGenerator.genSuccessResult(goodsList);
    	} else if (categoryList.size() > 0) {
    		return ResultGenerator.genSuccessResult(categoryList);
    	}
		return ResultGenerator.genSuccessResult("Success!");
    	
    }
    
    // キャンペーン適用(商品)
    @RequestMapping(value = "/campaign/insertCampaignGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaignGoods(@RequestBody CampaignGoods campaignGoods) {
    	
    	long count = campaignService.insertCampaignGoods(campaignGoods);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "該当商品がありません");
    	} else {
    		return ResultGenerator.genSuccessResult("キャンペーン応用情報の取得に成功しました。");
    	}
    }
    
    // キャンペーン適用(カテゴリー)
    @RequestMapping(value = "/campaign/insertCampaignCategory", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCampaignCategory(@RequestBody CampaignCategory campaignCategory) {
    	
    	long count = campaignService.insertCampaignCategory(campaignCategory);
    	if (count <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "該当カテゴリーがありません");
    	} else {
    		return ResultGenerator.genSuccessResult("キャンペーン応用情報の取得に成功しました。");
    	}
    }
    
    // キャンペーン削除(商品)
    @PutMapping(value = "/campaign/updateCampaignGoods")
    @ResponseBody
    public Result updateCampaignGoods(@RequestBody CampaignGoods campaignGoods) {
    	
    	long countUpdateCampaignGoods = campaignService.updateCampaignGoods(campaignGoods);
    	if (countUpdateCampaignGoods <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "キャンペーン期間外");
    	} else {
    		return ResultGenerator.genSuccessResult("キャンペーンの削除に成功しました");
    	}
    }
    
 	// キャンペーン削除(カテゴリー)
    @PutMapping(value = "/campaign/updateCampaignCategory/{deleteFlg}")
    @ResponseBody
    public Result updateCampaignCategory(@PathVariable("deleteFlg") CampaignCategory campaignCategory) {
    	
    	long countUpdateCampaignCategory = campaignService.updateCampaignCategory(campaignCategory);
    	if (countUpdateCampaignCategory <= 0) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "キャンペーン期間外");
    	} else {
    		return ResultGenerator.genSuccessResult("キャンペーンの削除に成功しました");
    	}
    }
}

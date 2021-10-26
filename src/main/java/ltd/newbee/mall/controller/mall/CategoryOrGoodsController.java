package ltd.newbee.mall.controller.mall;


import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.campaign.Campaign;
import ltd.newbee.mall.service.CategoryOrGoodsService;

import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class CategoryOrGoodsController {

	@Resource
	private CategoryOrGoodsService categoryOrGoodsService;

	@RequestMapping(value = "/applyCampaign", method = RequestMethod.GET)
	@ResponseBody
	public Result applyCampaign(long parentId) {
		
		ArrayList<ApplyGoodsCampaign> goodsList = categoryOrGoodsService.getApplyGoods(parentId);
		
		if (goodsList != null && goodsList.size() == 0) {
			
			ArrayList<ApplyCategoryCampaign> categoryList = categoryOrGoodsService.getApplyCategory(parentId);
			if (categoryList != null && categoryList.size() == 0) {
				return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "該当カテゴリリストもしくはグッズリストがない！");
			} else {
				return ResultGenerator.genSuccessResult(categoryList);
			}
			
		} else {
			return ResultGenerator.genSuccessResult(goodsList);
		}
	}


	@RequestMapping(value = "/applyCategoryCampaign", method = RequestMethod.POST)
	@ResponseBody
	public Result insertCategoryCampaign(@RequestBody ApplyCategoryCampaign applyCategoryCampaign) {

		Date validDateFrom = applyCategoryCampaign.getValidDateFrom();
		Date validDateTo = applyCategoryCampaign.getValidDateTo();
		int compareTo = validDateFrom.compareTo(validDateTo);
		if (compareTo < 0) {
			long count = categoryOrGoodsService.insertCategoryCampaign(applyCategoryCampaign);
			if (count > 0) {
				return ResultGenerator.genSuccessResult("キャンペーン応用情報の挿入に成功しました。");
			} else {
				return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
			}
		} else {
			return ResultGenerator.genFailResult("時間は間違えた！");
		}
	}
	
	@RequestMapping(value = "/GoodsCampaignFlag", method = RequestMethod.POST)
	@ResponseBody
	public Result insertGoodsCampaign(@RequestBody ApplyGoodsCampaign applyGoodsCampaign) {

		Date validDateFrom = applyGoodsCampaign.getValidDateFrom();
		Date validDateTo = applyGoodsCampaign.getValidDateTo();
		int compareTo = validDateFrom.compareTo(validDateTo);
		if (compareTo < 0) {
			long count = categoryOrGoodsService.insertGoodsCampaign(applyGoodsCampaign);
			if (count > 0) {
				return ResultGenerator.genSuccessResult("キャンペーン応用情報の挿入に成功しました。");
			} else {
				return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
			}
		} else {
			return ResultGenerator.genFailResult("時間は間違えた！");
		}
	}
	

	@PutMapping(value = "/categoryDeleteFlag")
	@ResponseBody
	public Result updateCategoryDelete(@RequestBody ApplyCategoryCampaign applyCategoryCampaign) {
		int updateCategoryDelete = categoryOrGoodsService.updateCategoryDelete(applyCategoryCampaign);
		if (ServiceResultEnum.SUCCESS.getResult().equals(updateCategoryDelete)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("更新した");
		}
	}
	

	@PutMapping(value = "/goodsDeleteFlag")
	@ResponseBody
	public Result updateGoodsDelete(@RequestBody ApplyGoodsCampaign applyGoodsCampaign) {
		int updateGoodsDelete = categoryOrGoodsService.updateGoodsDelete(applyGoodsCampaign);
		if (ServiceResultEnum.SUCCESS.getResult().equals(updateGoodsDelete)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("更新した");
		}
	}
	

	@RequestMapping(value = "/dropDownList", method = RequestMethod.GET)
	@ResponseBody
	public Result addDropDownList() {
        List<Campaign> list = categoryOrGoodsService.dropDownList();
        if(CollectionUtils.isEmpty(list)) {
        	return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "キャンペーンリストの取得は失敗した！");
        }else {
        	return ResultGenerator.genSuccessResult(list);
        }
        
    }

	
	

}

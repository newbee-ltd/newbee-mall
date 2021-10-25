package ltd.newbee.mall.controller.mall;


import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.service.CategoryOrGoodsService;

import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class CategoryOrGoodsController {

	@Resource
	private CategoryOrGoodsService categoryOrGoodsService;

	@RequestMapping(value = "/applyCampaign", method = RequestMethod.GET)
	@ResponseBody
	public Result applyCampaign(ApplyGoodsCampaign applyGoodsCampaign, ApplyCategoryCampaign applyCategoryCampaign) {
		ArrayList<ApplyCategoryCampaign> categoryList = categoryOrGoodsService.getApplyCategory(applyCategoryCampaign);
		ArrayList<ApplyGoodsCampaign> goodsList = categoryOrGoodsService.getApplyGoods(applyGoodsCampaign);
		if (categoryList.size() == 0 && goodsList.size() == 0) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "該当カテゴリもしくはグッズがない");
		} else if (goodsList.size() > 0) {
			return ResultGenerator.genSuccessResult(goodsList);
		} else {
			return ResultGenerator.genSuccessResult(categoryList);
		}
	}

	@RequestMapping(value = "/insertCategoryCampaign", method = RequestMethod.POST)
	@ResponseBody
	public Result insertCategoryCampaign(@RequestBody ApplyCategoryCampaign applyCategoryCampaign) {

		Date validDateFrom = applyCategoryCampaign.getValidDateFrom();
		Date validDateTo = applyCategoryCampaign.getValidDateTo();
		int compareTo = validDateFrom.compareTo(validDateTo);
		if (compareTo < 0) {
			long count = categoryOrGoodsService.insertCategoryCampaign(applyCategoryCampaign);
			Long categoryId = categoryOrGoodsService.getMaxCategoryId(applyCategoryCampaign.getCampaignId());
			applyCategoryCampaign.setCampaignId(categoryId);
			if (count > 0) {
				return ResultGenerator.genSuccessResult("キャンペーン応用情報の挿入に成功しました。");
			} else {
				return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
			}
		} else {
			return ResultGenerator.genFailResult("時間は間違えた！");
		}
	}
	
	@RequestMapping(value = "/insertGoodsCampaign", method = RequestMethod.POST)
	@ResponseBody
	public Result insertGoodsCampaign(@RequestBody ApplyGoodsCampaign applyGoodsCampaign) {

		Date validDateFrom = applyGoodsCampaign.getValidDateFrom();
		Date validDateTo = applyGoodsCampaign.getValidDateTo();
		int compareTo = validDateFrom.compareTo(validDateTo);
		if (compareTo < 0) {
			long count = categoryOrGoodsService.insertGoodsCampaign(applyGoodsCampaign);
			Long goodsId = categoryOrGoodsService.getMaxGoodsId(applyGoodsCampaign.getGoodsId());
			applyGoodsCampaign.setGoodsId(goodsId);
			if (count > 0) {
				return ResultGenerator.genSuccessResult("キャンペーン応用情報の挿入に成功しました。");
			} else {
				return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
			}
		} else {
			return ResultGenerator.genFailResult("時間は間違えた！");
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@PutMapping(value = "/updateCategoryDelete")
	@ResponseBody
	public Result updateCategoryDelete(@RequestBody ApplyCategoryCampaign applyCategoryCampaign) {
		int updateCategoryDelete = categoryOrGoodsService.updateCategoryDelete(applyCategoryCampaign);
		if (ServiceResultEnum.SUCCESS.getResult().equals(updateCategoryDelete)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("更新した");
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@PutMapping(value = "/updateGoodsDelete")
	@ResponseBody
	public Result updateGoodsDelete(@RequestBody ApplyGoodsCampaign applyGoodsCampaign) {
		int updateGoodsDelete = categoryOrGoodsService.updateGoodsDelete(applyGoodsCampaign);
		if (ServiceResultEnum.SUCCESS.getResult().equals(updateGoodsDelete)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("更新した");
		}
	}

}

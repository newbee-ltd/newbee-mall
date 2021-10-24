package ltd.newbee.mall.controller.mall;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
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
	public Result applyCampaign(ApplyGoodsCampaign applyGoodsCampaign,ApplyCategoryCampaign applyCategoryCampaign) {
		ArrayList<ApplyCategoryCampaign> categoryList = categoryOrGoodsService.getApplyCategory(applyCategoryCampaign);
		ArrayList<ApplyGoodsCampaign> goodsList = categoryOrGoodsService.getApplyGoods(applyGoodsCampaign);
		if (categoryList.size()==0 && goodsList.size()==0) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "該当カテゴリもしくはグッズがない");
		} else if(categoryList.size()>0) {
			return ResultGenerator.genSuccessResult(categoryList);
		}else if(goodsList.size()>0) {
			return ResultGenerator.genSuccessResult(goodsList);
		}
		return ResultGenerator.genSuccessResult("データの敵用に成功する");
	}

	

}

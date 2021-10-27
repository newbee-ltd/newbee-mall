package ltd.newbee.mall.controller.mall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.entity.ApplyCategoryCampaign;
import ltd.newbee.mall.entity.ApplyGoodsCampaign;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.Student;
import ltd.newbee.mall.entity.campaign.ApplyGoodsCampaign2;
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
		if (CollectionUtils.isEmpty(list)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "キャンペーンリストの取得は失敗した！");
		} else {
			return ResultGenerator.genSuccessResult(list);
		}

	}

	@RequestMapping(value = "/readCSV", method = RequestMethod.POST)
	@ResponseBody
	public Result readCSV(@RequestParam String filePath, ApplyGoodsCampaign2 agc) {

		BufferedReader br = null;
		filePath = "/Users/chenghongzhen/Desktop/SpringBoot/newbeemall/AGCdemo.csv"; // 入力ファイル
		try {
			File file = new File(filePath);
			br = new BufferedReader(new FileReader(file));
			// readLineで一行ずつ読み込む
			String line; // 読み込み行
			String[] data; // 分割後のデータを保持する配列
			while ((line = br.readLine()) != null) {
				// lineをカンマで分割し、配列dataに設定
				data = line.split(",");

				// ApplyGoodsCampaign2 agc = new ApplyGoodsCampaign2();
				agc.setGoodsId(Integer.parseInt(data[0]));
				agc.setCampaignId(Integer.parseInt(data[1]));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				agc.setInsertDate(simpleDateFormat.parse(data[2]));
				agc.setInsertUser(data[3]);
				agc.setUpdateDate(simpleDateFormat.parse(data[4]));
				agc.setUpdateUser(data[5]);
				agc.setValidDateFrom(simpleDateFormat.parse(data[6]));
				agc.setValidDateTo(simpleDateFormat.parse(data[7]));
				agc.setDeleteFlag(Boolean.parseBoolean(data[8]));

				List<NewBeeMallGoods> List1 = categoryOrGoodsService.getGoodsIdList();
				List<Campaign> List2 = categoryOrGoodsService.getCampaignIdList();
				List<Long> goodsIdList = List1.stream().map(e -> e.getGoodsId()).collect(Collectors.toList());
				List<Long> campaignIdList = List2.stream().map(e -> e.getCampaignId()).collect(Collectors.toList());

				long newGoodsId = agc.getGoodsId();
				long newCampaignId = agc.getCampaignId();

				Date start = agc.getValidDateFrom();
				Date end = agc.getValidDateTo();
				int compareTo = start.compareTo(end);

				if (compareTo < 0 && goodsIdList.contains(newGoodsId) && campaignIdList.contains(newCampaignId)) {

					long count = categoryOrGoodsService.insertGoodsCampaign2(agc);
					if (count <= 0) {
						return ResultGenerator.genErrorResult(Constants.FETCH_ERROR,
								Constants.STUDENT_INSERT_ERROR_MESSAGE);
					}

				} else {
					continue;
				}

//				if (compareTo < 0) {
//					if (goodsIdList.contains(newGoodsId)) {
//						if (campaignIdList.contains(newCampaignId)) {
//							long count = categoryOrGoodsService.insertGoodsCampaign2(agc);
//							if (count <= 0) {
//								return ResultGenerator.genErrorResult(Constants.FETCH_ERROR,
//										Constants.STUDENT_INSERT_ERROR_MESSAGE);
//							}
//						} else {
//							return ResultGenerator.genFailResult("the campaignId is not exist!");
//						}
//					} else {
//						return ResultGenerator.genFailResult("the goodsId is not exist!");
//					}
//				} else {
//					return ResultGenerator.genFailResult("time error!");
//				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return ResultGenerator.genSuccessResult("挿入した");
	}
}

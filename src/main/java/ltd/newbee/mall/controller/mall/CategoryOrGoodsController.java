package ltd.newbee.mall.controller.mall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import ltd.newbee.mall.entity.campaign.BuyGoodsSet;
import ltd.newbee.mall.entity.campaign.Campaign;
import ltd.newbee.mall.service.CategoryOrGoodsService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import ltd.newbee.mall.util.TimeUtil;

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
			if (categoryList != null && !categoryList.isEmpty()) {
				return ResultGenerator.genSuccessResult(categoryList);
			} else {
				return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, "該当カテゴリリストもしくはグッズリストがない！");
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
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.DROPDOWNLIST_GET_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult(list);
		}

	}

	@RequestMapping(value = "/readCSV", method = RequestMethod.POST)
	@ResponseBody
	public Result readCSV(@RequestParam String filePath) {

		BufferedReader br = null;
		// filePath = "/Users/chenghongzhen/Desktop/SpringBoot/newbeemall/AGCdemo.csv";

		// error log
		ArrayList<String> msgList = new ArrayList<>();

		// 入力ファイル
		try {
			File file = new File(filePath);
			br = new BufferedReader(new FileReader(file));
			// readLineで一行ずつ読み込む
			String line; // 読み込み行
			String[] data; // 分割後のデータを保持する配列

			int row = 0; // 行数
			int temp = 0; // エラーログのサイズ

			while ((line = br.readLine()) != null) {
				// lineをカンマで分割し、配列dataに設定
				data = line.split(",");

				ApplyGoodsCampaign2 agc = new ApplyGoodsCampaign2();

				// 商品idとキャンペーンidが存在するかどうかを確認します
				List<NewBeeMallGoods> list1 = categoryOrGoodsService.getGoodsIdList(Long.parseLong(data[0]));
				List<Campaign> list2 = categoryOrGoodsService.getCampaignIdList(Long.parseLong(data[1]));

				row++;
				if (list1 == null || list1.isEmpty()) {
					msgList.add(line + ": " + row + "行目の" + "商品id\"" + data[0] + "\"は商品マスタ一に存在しない。");
				}
				if (list2 == null || list2.isEmpty()) {
					msgList.add(line + ": " + row + "行目の" + "キャンペーンid\"" + data[1] + "\"はキャンペーマスタ一に存在しない。");
				}
				// 時間の形式が正しいかどうかを判断します
				if (!TimeUtil.isValidDate2(data[6]) || !TimeUtil.isValidDate2(data[7])) {
					msgList.add(
							line + ": " + row + "行目の" + "キャンペーンの開始時刻" + data[6] + "もしくは終了時刻" + data[7] + "の形式が正しくない。");
					temp = msgList.size();
				} else {

					try {
						// 開始時刻が終了時刻よりも早いかどうかを確認します
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						if (!TimeUtil.TimeCompare(simpleDateFormat.parse(data[6]), simpleDateFormat.parse(data[7]))) {
							msgList.add(
									line + ": " + row + "行目の" + "キャンペーンの開始時刻" + data[6] + "が終了時刻" + data[7] + "より遅い。");
						}

						agc.setGoodsId(Integer.parseInt(data[0]));
						agc.setCampaignId(Integer.parseInt(data[1]));
						agc.setInsertDate(simpleDateFormat.parse(data[2]));
						agc.setInsertUser(data[3]);
						agc.setUpdateDate(simpleDateFormat.parse(data[4]));
						agc.setUpdateUser(data[5]);
						agc.setValidDateFrom(simpleDateFormat.parse(data[6]));
						agc.setValidDateTo(simpleDateFormat.parse(data[7]));
						agc.setDeleteFlag(Boolean.parseBoolean(data[8]));

//				long newGoodsId = agc.getGoodsId();
//				long newCampaignId = agc.getCampaignId();
//				List<NewBeeMallGoods> list1 = categoryOrGoodsService.getGoodsIdList(newGoodsId);
//				List<Campaign> list2 = categoryOrGoodsService.getCampaignIdList(newCampaignId);
////				List<Long> goodsIdList = List1.stream().map(e -> e.getGoodsId()).collect(Collectors.toList());
////				List<Long> campaignIdList = List2.stream().map(e -> e.getCampaignId()).collect(Collectors.toList());
//
//				Date start = agc.getValidDateFrom();
//				Date end = agc.getValidDateTo();
////				int compareTo = start.compareTo(end);

//				if (TimeUtil.TimeCompare(start, end)
//						&& (list1 != null && !list1.isEmpty()) && (list2 != null && !list2.isEmpty())) {

						if (msgList.size() == temp) {
							long count = categoryOrGoodsService.insertGoodsCampaign2(agc);
							if (count <= 0) {
								return ResultGenerator.genErrorResult(Constants.FETCH_ERROR,
										Constants.STUDENT_INSERT_ERROR_MESSAGE);
							}
						} else {
							temp = msgList.size();
							// continue;
						}

					} catch (ParseException e) {
						e.printStackTrace();
					}

				}

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

//		System.out.println(msgList); // 输出在控制台
//		
//		PrintWriter pw = new PrintWriter("msgList.txt");  // 输出在project下
//		for (String i : msgList) {
//			pw.println(i);  //已换行
//		}
//		pw.close();

		// 存放路径不可以写filePath,否则会重写插入的文件
		File file = new File("/Users/chenghongzhen/Desktop/SpringBoot/newbeemall/msgList1.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			// FileWriter fw = new FileWriter("file");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (String i : msgList) {
				bw.write(i);
				bw.newLine(); // 换行
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResultGenerator.genSuccessResult(Constants.CSV_INSERT_SUCCESS_MESSAGE);
	}

	// modal get goodsInfo list
	@PutMapping(value = "/updateBGS")
	@ResponseBody
	public Result updateStudent(@RequestBody BuyGoodsSet buyGoodsSet) {
		long updatResult= categoryOrGoodsService.updateBuyGoodsSet(buyGoodsSet);
		if (ServiceResultEnum.SUCCESS.getResult().equals(updatResult)) {
			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_INSERT_ERROR_MESSAGE);
		} else {
			return ResultGenerator.genSuccessResult("更新した");
		}
	}
}

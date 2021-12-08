/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.ResDetailCourse;
import ltd.newbee.mall.entity.ResDetailFeature;
import ltd.newbee.mall.entity.ResDetailPhoto;
import ltd.newbee.mall.entity.ResDetailReserve;
import ltd.newbee.mall.entity.ResDetailReview;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResDetailSeat;
import ltd.newbee.mall.service.ResDetailScreenService;
import ltd.newbee.mall.util.PageInquiryResult;
import ltd.newbee.mall.util.PageInquiryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class RestaurantDetailController {

	@Resource
	ResDetailScreenService resDetailScreenService;

	@GetMapping({ "/restaurant/detail/{restaurantId}", "/restaurant/detail/{restaurantId}/{flag}",
			"/restaurant/detail/{restaurantId}/{flag}/{flag1}" })
	public String restaurantPage(@PathVariable("restaurantId") Long restaurantId, HttpServletRequest request,
			@PathVariable(name = "flag", required = false) String flag,
			@PathVariable(name = "flag1", required = false) String flag1) {
		long followResId = restaurantId;
		long followTotal = resDetailScreenService.getFollowTotal(followResId);
		List<ResDetailScreen> resDetailList = resDetailScreenService.getResDetail(restaurantId);
		request.setAttribute("followTotal", followTotal);
		request.setAttribute("resDetai", resDetailList);

		long photoCode = Constants.MAIN_PHOTO_CODE;
		List<ResDetailPhoto> mainPhotoList = resDetailScreenService.getMainphoto(restaurantId, photoCode);
		List<ResDetailPhoto> commitPhotoList = resDetailScreenService.getCommitphoto(restaurantId);
		List<ResDetailCourse> courseList = resDetailScreenService.getCourse(restaurantId);
		List<ResDetailScreen> basicInfoList = resDetailScreenService.getBacicInfo(restaurantId);
		List<ResDetailSeat> seatList = resDetailScreenService.getSeatInfo(restaurantId);
		List<ResDetailFeature> featureList = resDetailScreenService.getFeaturInfo(restaurantId);
		List<ResDetailReview> reviewList = resDetailScreenService.getReviewList(restaurantId);
		List<ResDetailReview> visitNum = resDetailScreenService.getVisitNum(restaurantId);

		request.setAttribute("mainPhoto", mainPhotoList);
		request.setAttribute("commitPhoto", commitPhotoList);
		request.setAttribute("course", courseList);
		request.setAttribute("basicInfo", basicInfoList);
		request.setAttribute("seat", seatList);
		request.setAttribute("feature", featureList);
		request.setAttribute("review", reviewList);
		request.setAttribute("visit", visitNum);

		photoCode = Constants.MEAL_USER_PHOTO_CODE;
		List<ResDetailPhoto> mealUserPhotoList = resDetailScreenService.getMainphoto(restaurantId, photoCode);
		List<ResDetailPhoto> mealUserPhotoList1 = mealUserPhotoList.subList(0, 10);
		List<ResDetailPhoto> mealUserPhotoList2 = mealUserPhotoList.subList(10, 20);
		request.setAttribute("mealUserPhoto1", mealUserPhotoList1);
		request.setAttribute("mealUserPhoto2", mealUserPhotoList2);

		List<ResDetailReserve> reserveList = resDetailScreenService.getReserveInfo(restaurantId);
		request.setAttribute("reverse", reserveList);

		Map<String, Object> params = new HashMap<>();
		int limit = 6;
		int currentPage = 1;
		params.put("limit", limit);
		params.put("currentPage", currentPage);
		params.put("restaurantId", restaurantId);
		PageInquiryUtil pageUtil = new PageInquiryUtil(params);
		PageInquiryResult pageResult = resDetailScreenService.getMenuPhoto(pageUtil);
		request.setAttribute("MPpage", pageResult);

		request.setAttribute("flag", flag);
		request.setAttribute("flag1", flag1);
		request.setAttribute("resId", restaurantId);

		return "mall/resDetailScreen";
	}

	@RequestMapping(value = "/menuPhotoList", method = RequestMethod.GET)
	@ResponseBody
	public Result list(@RequestParam Map<String, Object> params) {
		if (StringUtils.isEmpty(params.get("currentPage").toString())
				|| StringUtils.isEmpty(params.get("limit").toString())
				|| StringUtils.isEmpty(params.get("restaurantId").toString())) {
			return ResultGenerator.genFailResult("参数异常！");
		}
		PageInquiryUtil pageUtil = new PageInquiryUtil(params);
		return ResultGenerator.genSuccessResult(resDetailScreenService.getMenuPhoto(pageUtil));
	}

}
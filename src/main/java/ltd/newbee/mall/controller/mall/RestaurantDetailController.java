/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ltd.newbee.mall.entity.ResDetailCourse;
import ltd.newbee.mall.entity.ResDetailFeature;
import ltd.newbee.mall.entity.ResDetailPhoto;
import ltd.newbee.mall.entity.ResDetailScreen;
import ltd.newbee.mall.entity.ResDetailSeat;
import ltd.newbee.mall.service.ResDetailScreenService;
import ltd.newbee.mall.service.ResInfoSearchService;

@Controller
public class RestaurantDetailController {

	@Resource
	ResDetailScreenService resDetailScreenService;

	@GetMapping("/restaurant/detail/{restaurantId}")
	public String restaurantPage(@PathVariable("restaurantId") Long restaurantId, HttpServletRequest request) {
		long followResId = restaurantId;
		long followTotal = resDetailScreenService.getFollowTotal(followResId);
		List<ResDetailScreen> resDetailList = resDetailScreenService.getResDetail(restaurantId);
		request.setAttribute("followTotal", followTotal);
		request.setAttribute("resDetai", resDetailList);

		long photoCode = 1;
		List<ResDetailPhoto> mainPhotoList = resDetailScreenService.getMainphoto(restaurantId, photoCode);
		List<ResDetailPhoto> commitPhotoList = resDetailScreenService.getCommitphoto(restaurantId);
		List<ResDetailCourse> courseList = resDetailScreenService.getCourse(restaurantId);
		List<ResDetailScreen> basicInfoList = resDetailScreenService.getBacicInfo(restaurantId);
		List<ResDetailSeat> seatList = resDetailScreenService.getSeatInfo(restaurantId);
		List<ResDetailFeature> featureList = resDetailScreenService.getFeaturInfo(restaurantId);

		request.setAttribute("mainPhoto", mainPhotoList);
		request.setAttribute("commitPhoto", commitPhotoList);
		request.setAttribute("course", courseList);
		request.setAttribute("basicInfo", basicInfoList);
		request.setAttribute("seat", seatList);
		request.setAttribute("feature", featureList);

		return "mall/resDetailScreen";
	}

}

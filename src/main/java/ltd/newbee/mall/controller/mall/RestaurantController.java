/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ltd.newbee.mall.entity.ResInfoSearch;
import ltd.newbee.mall.service.ResInfoSearchService;

@Controller
public class RestaurantController {

	@Resource
	private ResInfoSearchService resInfoSearchService;

	@GetMapping("/restaurant")
	public String restaurantPage(HttpServletRequest request) {
		String cityName = "東京";
		String townName = "東京";
		String stationName = "東京";
		String keywords = "焼";
		List<String> cityList = resInfoSearchService.getCityName(cityName);
		List<String> townList = resInfoSearchService.getTownName(townName);
		List<String> stationList = resInfoSearchService.getStationName(stationName);
		List<String> keywordList = resInfoSearchService.getKeywords(keywords);
		List<ResInfoSearch> reserveList = resInfoSearchService.getReserveInfo();

		List<String> areaList = new ArrayList<>();
		areaList.addAll(cityList);
		areaList.addAll(townList);
		areaList.addAll(stationList);

		return "mall/restaurant";
	}


}

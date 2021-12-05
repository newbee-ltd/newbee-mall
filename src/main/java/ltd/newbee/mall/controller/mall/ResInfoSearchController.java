
package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.ResInfoSearch;
import ltd.newbee.mall.service.ResInfoSearchService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class ResInfoSearchController {

	@Resource
	ResInfoSearchService resInfoSearchService;

//	@RequestMapping(value = "/cityName", method = RequestMethod.GET)
//	@ResponseBody
//	public Result cityName(String cityName) {
//		List<String> cityList = resInfoSearchService.getCityName(cityName);
//		if (CollectionUtils.isEmpty(cityList)) {
//			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
//		} else {
//			return ResultGenerator.genSuccessResult(cityList);
//		}
//	}
//
//	@RequestMapping(value = "/townName", method = RequestMethod.GET)
//	@ResponseBody
//	public Result townName(String townName) {
//		List<String> townList = resInfoSearchService.getTownName(townName);
//		if (CollectionUtils.isEmpty(townList)) {
//			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
//		} else {
//			return ResultGenerator.genSuccessResult(townList);
//		}
//	}
//
//	@RequestMapping(value = "/stationName", method = RequestMethod.GET)
//	@ResponseBody
//	public Result stationName(String stationName) {
//		List<String> stationList = resInfoSearchService.getStationName(stationName);
//		if (CollectionUtils.isEmpty(stationList)) {
//			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
//		} else {
//			return ResultGenerator.genSuccessResult(stationList);
//		}
//	}
//
//	@RequestMapping(value = "/keywords", method = RequestMethod.GET)
//	@ResponseBody
//	public Result keywords(String keywords) {
//		List<String> keywordList = resInfoSearchService.getKeywords(keywords);
//		if (CollectionUtils.isEmpty(keywordList)) {
//			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
//		} else {
//			return ResultGenerator.genSuccessResult(keywordList);
//		}
//	}
//	
//	@RequestMapping(value = "/reserveInfo", method = RequestMethod.GET)
//	@ResponseBody
//	public Result researveInfo(ResInfoSearch resInfoSearch) {
//		List<ResInfoSearch> reserveList= resInfoSearchService.getReserveInfo();
//		if (CollectionUtils.isEmpty(reserveList)) {
//			return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.STUDENT_FETCH_ERROR_MESSAGE);
//		} else {
//			return ResultGenerator.genSuccessResult(reserveList);
//		}
//	}

}

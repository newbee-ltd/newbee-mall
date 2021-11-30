package ltd.newbee.mall.controller.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.RestaurantJapanRegion;
import ltd.newbee.mall.entity.RestaurantJapanStation;
import ltd.newbee.mall.entity.RestaurantKeyword;
import ltd.newbee.mall.service.TabelogService;
import ltd.newbee.mall.util.ResultGenerator;
import ltd.newbee.mall.util.Result;


@Controller
public class TabelogRestController {

    @Resource
    private TabelogService tabelogService;
    
    // 曖昧検索(Keyword)
    @RequestMapping(value = "/keywordList", method = RequestMethod.GET)
    @ResponseBody
    public Result keywordList(@RequestParam String keyword) {
    	
    	List<RestaurantKeyword> keywordList = tabelogService.getKeywordList(keyword);
    	if (CollectionUtils.isEmpty(keywordList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(keywordList);
    	}
    }
    
    // 曖昧検索(Area)
    @RequestMapping(value = "/cityList", method = RequestMethod.GET)
    @ResponseBody
    public Result cityList(@RequestParam String cityName) {
    	
    	List<RestaurantJapanRegion> cityList = tabelogService.getCityList(cityName);
    	if (CollectionUtils.isEmpty(cityList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(cityList);
    	}
    }
    
    @RequestMapping(value = "/districtList", method = RequestMethod.GET)
    @ResponseBody
    public Result districtList(@RequestParam String districtName) {
    	
    	List<RestaurantJapanRegion> districtList = tabelogService.getDistrictList(districtName);
    	if (CollectionUtils.isEmpty(districtList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(districtList);
    	}
    }
    
    @RequestMapping(value = "/stationList", method = RequestMethod.GET)
    @ResponseBody
    public Result stationList(@RequestParam String stationName) {
    	
    	List<RestaurantJapanStation> stationList = tabelogService.getStationList(stationName);
    	
//    	List<Object> areaList = new ArrayList<Object>(regionList);
//    	areaList.addAll(stationList);
    	if (CollectionUtils.isEmpty(stationList)) {
    		return ResultGenerator.genErrorResult(Constants.FETCH_ERROR, Constants.ERROR_MESSAGE);
    	} else {
    		return ResultGenerator.genSuccessResult(stationList);
    	}
    }
   
}
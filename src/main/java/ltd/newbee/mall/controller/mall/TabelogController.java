/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.controller.vo.RestaurantAreaListVO;
import ltd.newbee.mall.entity.RestaurantBasicInfo;
import ltd.newbee.mall.entity.RestaurantJapanRegion;
import ltd.newbee.mall.entity.RestaurantJapanStation;
import ltd.newbee.mall.entity.RestaurantKeyword;
import ltd.newbee.mall.entity.RestaurantPhoto;
import ltd.newbee.mall.service.TabelogService;
import ltd.newbee.mall.util.BeanUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TabelogController {

    @Resource
    private TabelogService tabelogService;

    @GetMapping("/tabelog")
    public String Portal(String keyword, String cityName, String districtName, String stationName, HttpServletRequest request) throws ParseException {
        
        // 曖昧検索(Keyword)
        List<RestaurantKeyword> keywordEntityList = tabelogService.getKeywordList(keyword);
        // Copy keywordList
        List<RestaurantKeyword> keywordList = (List<RestaurantKeyword>) BeanUtil.copyList(keywordEntityList, RestaurantKeyword.class);
        
        // 曖昧検索(Area)
        List<RestaurantJapanRegion> cityList = tabelogService.getCityList(cityName);
        List<RestaurantJapanRegion> districtList = tabelogService.getDistrictList(districtName);
    	List<RestaurantJapanStation> stationList = tabelogService.getStationList(stationName);
    	
    	List<RestaurantAreaListVO> areaList = new ArrayList<RestaurantAreaListVO>();
    	areaList.add((RestaurantAreaListVO) cityList);
    	areaList.add((RestaurantAreaListVO) districtList);
    	areaList.add((RestaurantAreaListVO) stationList);
        
        // 曖昧検索
        request.setAttribute("keywordList", keywordList);
        request.setAttribute("areaList", areaList);
        
        return "mall/tabelog";
    }
    
    @GetMapping("/tabelog/detail/{restaurantId}")
    public String detailPage(@PathVariable("restaurantId") Long restaurantId, HttpServletRequest request) throws ParseException {
        
        // KeywordList(Header)
        List<RestaurantKeyword> keywordEntityList = tabelogService.getKeywordByRestaurantId(restaurantId);
        // Copy keywordList
        List<RestaurantKeyword> keywordList = (List<RestaurantKeyword>) BeanUtil.copyList(keywordEntityList, RestaurantKeyword.class);
        
        // RestaurantBasicInfo(Header)
        List<RestaurantBasicInfo> restaurantBasicInfoEntityList = tabelogService.getRestaurantBasicInfo(restaurantId);
        List<RestaurantBasicInfo> restaurantBasicInfoList = (List<RestaurantBasicInfo>) BeanUtil.copyList(restaurantBasicInfoEntityList, RestaurantBasicInfo.class);
        
        // restaurant_reviewの各点数の平均評価
        double averageScore = tabelogService.getAverageScoreByRestaurantId(restaurantId);
        double avgScore = Math.round(averageScore * 100) / 100.0;
        
        // Count Of Review
    	long countOfReview = tabelogService.getCountOfReview(restaurantId);
    	
    	// Count Of Followed
  	    long countOfFollowed = tabelogService.getCountOfFollowed(restaurantId);
    	
    	// Go To Eat
    	String goToEat = tabelogService.getGoToEat(restaurantId);
    	
    	// Top Slide Photo
    	List<RestaurantPhoto> photoEntityList = tabelogService.getSlidePhoto(countOfFollowed);
        // Copy PhotoList
        List<RestaurantPhoto> photoList = (List<RestaurantPhoto>) BeanUtil.copyList(photoEntityList, RestaurantPhoto.class);
        
        request.setAttribute("keywordList", keywordList);
        request.setAttribute("restaurantBasicInfoList", restaurantBasicInfoList);
        request.setAttribute("avgScore", avgScore);
        request.setAttribute("countOfReview", countOfReview);
        request.setAttribute("countOfFollowed", countOfFollowed);
        request.setAttribute("goToEat", goToEat);
        request.setAttribute("photoList", photoList);
        
        return "mall/tabelogDetail";
    }
    
}

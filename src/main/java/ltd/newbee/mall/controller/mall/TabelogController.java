/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.controller.vo.RestaurantFeaturesInfoVO;
import ltd.newbee.mall.controller.vo.RestaurantReviewVO;
import ltd.newbee.mall.entity.RestaurantBasicInfo;
import ltd.newbee.mall.entity.RestaurantDiseaseControl;
import ltd.newbee.mall.entity.RestaurantFeaturesInfo;
import ltd.newbee.mall.entity.RestaurantKeyword;
import ltd.newbee.mall.entity.RestaurantMenuCourse;
import ltd.newbee.mall.entity.RestaurantPhoto;
import ltd.newbee.mall.entity.RestaurantPhotoCommitment;
import ltd.newbee.mall.entity.RestaurantReview;
import ltd.newbee.mall.entity.RestaurantSeatsMenu;
import ltd.newbee.mall.entity.RestaurantTakeout;
import ltd.newbee.mall.service.TabelogService;
import ltd.newbee.mall.util.BeanUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TabelogController {

    @Resource
    private TabelogService tabelogService;

//    @GetMapping("/tabelog")
//    public String Portal(String keyword, String cityName, String districtName, String stationName, HttpServletRequest request) throws ParseException {
//        
//        // 曖昧検索(Keyword)
//        List<RestaurantKeyword> keywordEntityList = tabelogService.getKeywordList(keyword);
//        // Copy keywordList
//        List<RestaurantKeyword> keywordList = (List<RestaurantKeyword>) BeanUtil.copyList(keywordEntityList, RestaurantKeyword.class);
//        
//        // 曖昧検索(Area)
//        List<RestaurantJapanRegion> cityList = tabelogService.getCityList(cityName);
//        List<RestaurantJapanRegion> districtList = tabelogService.getDistrictList(districtName);
//    	List<RestaurantJapanStation> stationList = tabelogService.getStationList(stationName);
//    	
//    	List<RestaurantAreaListVO> areaList = new ArrayList<RestaurantAreaListVO>();
//    	areaList.add((RestaurantAreaListVO) cityList);
//    	areaList.add((RestaurantAreaListVO) districtList);
//    	areaList.add((RestaurantAreaListVO) stationList);
//        
//        // 曖昧検索
//        request.setAttribute("keywordList", keywordList);
//        request.setAttribute("areaList", areaList);
//        
//        return "mall/tabelog";
//    }
    
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
    	List<RestaurantPhoto> photoEntityList = tabelogService.getSlidePhoto(restaurantId);
        // Copy PhotoList
        List<RestaurantPhoto> photoList = (List<RestaurantPhoto>) BeanUtil.copyList(photoEntityList, RestaurantPhoto.class);
        
        // Top Kodawari
    	List<RestaurantPhotoCommitment> kodawariEntityList = tabelogService.getKodawari(restaurantId);
        // Copy KodawariList
        List<RestaurantPhotoCommitment> kodawariList = (List<RestaurantPhotoCommitment>) BeanUtil.copyList(kodawariEntityList, RestaurantPhotoCommitment.class);
        
        // Top Course
    	List<RestaurantMenuCourse> courseEntityList = tabelogService.getMenuCourse(restaurantId);
        // Copy courseList
        List<RestaurantMenuCourse> courseList = (List<RestaurantMenuCourse>) BeanUtil.copyList(courseEntityList, RestaurantMenuCourse.class);
        
        // Review
    	List<RestaurantReview> reviewEntityList = tabelogService.getReview(restaurantId);
        List<RestaurantReviewVO> reviewList = new ArrayList<RestaurantReviewVO>();
        // Set Goods Review Time Format
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < reviewEntityList.size(); i++) {
        	RestaurantReview rv = reviewEntityList.get(i);
        	RestaurantReviewVO r = new RestaurantReviewVO();
            
        	if (rv != null && rv.getVisitDate() != null) {
                String dateString = fm.format(rv.getVisitDate());
                Date date = fm.parse(dateString);
                r.setVisitDate(dateString);
        	}
        	
        	r.setRestaurantId(rv.getRestaurantId());
        	r.setRestaurantName(rv.getRestaurantName());
        	r.setReviewId(rv.getReviewId());
        	r.setReviewUserId(rv.getReviewUserId());
        	r.setReviewUserName(rv.getReviewUserName());
        	r.setReviewUserAge(rv.getReviewUserAge());
        	r.setReviewUserGender(rv.getReviewUserGender());
        	r.setReviewUserCity(rv.getReviewUserCity());
        	r.setReviewTitle(rv.getReviewTitle());
        	r.setReviewDetail(rv.getReviewDetail());
        	r.setReviewImg(rv.getReviewImg());
        	r.setScoreTotal(rv.getScoreTotal());
        	r.setScoreTaste(rv.getScoreTaste());
        	r.setScoreService(rv.getScoreService());
        	r.setScoreAtmosphere(rv.getScoreAtmosphere());
        	r.setScoreCost(rv.getScoreCost());
        	r.setScoreDrink(rv.getScoreDrink());
        	r.setBudget(rv.getBudget());
        	r.setNightOrDaytime(rv.getNightOrDaytime());
        	r.setReplyDetail(rv.getReplyDetail());
        	r.setReviewerPhoto(rv.getReviewerPhoto());
        	reviewList.add(r);
        }
        
        // Disease Control
        List<RestaurantDiseaseControl> diseaseControlEntityList = tabelogService.getDiseaseControlList(restaurantId);
        // Copy seatsMenuList
        List<RestaurantDiseaseControl> diseaseControlList = (List<RestaurantDiseaseControl>) BeanUtil.copyList(diseaseControlEntityList, RestaurantDiseaseControl.class);
        
        // Takeout
        List<RestaurantTakeout> takeoutEntityList = tabelogService.getTakeoutList(restaurantId);
        // Copy seatsMenuList
        List<RestaurantTakeout> takeoutList = (List<RestaurantTakeout>) BeanUtil.copyList(takeoutEntityList, RestaurantTakeout.class);
        
        // Seats Menu
    	List<RestaurantSeatsMenu> seatsMenuEntityList = tabelogService.getSeatsMenu(restaurantId);
        // Copy seatsMenuList
        List<RestaurantSeatsMenu> seatsMenuList = (List<RestaurantSeatsMenu>) BeanUtil.copyList(seatsMenuEntityList, RestaurantSeatsMenu.class);
        
        // Restaurant Features Info
        List<RestaurantFeaturesInfo> restaurantFeaturesInfoEntityList = tabelogService.getRestaurantFeaturesInfo(restaurantId);
        List<RestaurantFeaturesInfoVO> restaurantFeaturesInfoList = new ArrayList<RestaurantFeaturesInfoVO>();
        // Set Restaurant Features Info Time Format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < restaurantFeaturesInfoEntityList.size(); i++) {
        	RestaurantFeaturesInfo rf = restaurantFeaturesInfoEntityList.get(i);
        	RestaurantFeaturesInfoVO r = new RestaurantFeaturesInfoVO();
            
        	if (rf != null && rf.getOpenDate() != null) {
                String dateString = format.format(rf.getOpenDate());
                Date date = format.parse(dateString);
                r.setOpenDate(dateString);
        	}
        	
        	r.setRestaurantId(rf.getRestaurantId());
        	r.setRestaurantName(rf.getRestaurantName());
        	r.setGoToEat(rf.getGoToEat());
        	r.setSceneName1(rf.getSceneName1());
        	r.setSceneName2(rf.getSceneName2());
        	r.setSceneName3(rf.getSceneName3());
        	r.setLocation(rf.getLocation());
        	r.setService(rf.getService());
        	r.setWithChildren(rf.getWithChildren());
        	r.setHomePage(rf.getHomePage());
        	r.setAccountTwitter(rf.getAccountTwitter());
        	r.setAccountIns(rf.getAccountIns());
        	r.setTelephone(rf.getTelephone());
        	r.setRemark(rf.getRemark());
        	r.setFirstContributorId(rf.getFirstContributorId());
        	r.setFirstContributorName(rf.getFirstContributorName());
        	restaurantFeaturesInfoList.add(r);
        }
        
        request.setAttribute("keywordList", keywordList);
        request.setAttribute("restaurantBasicInfoList", restaurantBasicInfoList);
        request.setAttribute("avgScore", avgScore);
        request.setAttribute("countOfReview", countOfReview);
        request.setAttribute("countOfFollowed", countOfFollowed);
        request.setAttribute("goToEat", goToEat);
        request.setAttribute("photoList", photoList);
        request.setAttribute("KodawariList", kodawariList);
        request.setAttribute("courseList", courseList);
        request.setAttribute("reviewList", reviewList);
        request.setAttribute("diseaseControlList", diseaseControlList);
        request.setAttribute("takeoutList", takeoutList);
        request.setAttribute("seatsMenuList", seatsMenuList);
        request.setAttribute("rstFeaturesInfoList", restaurantFeaturesInfoList);
        
        return "mall/tabelogDetail";
    }
    
}

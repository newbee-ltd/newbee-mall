/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service;

import java.util.ArrayList;

import ltd.newbee.mall.entity.RestaurantBasicInfo;
import ltd.newbee.mall.entity.RestaurantDiseaseControl;
import ltd.newbee.mall.entity.RestaurantFeaturesInfo;
import ltd.newbee.mall.entity.RestaurantJapanRegion;
import ltd.newbee.mall.entity.RestaurantJapanStation;
import ltd.newbee.mall.entity.RestaurantKeyword;
import ltd.newbee.mall.entity.RestaurantMenuCourse;
import ltd.newbee.mall.entity.RestaurantMenuDrink;
import ltd.newbee.mall.entity.RestaurantMenuLunch;
import ltd.newbee.mall.entity.RestaurantMenuMeal;
import ltd.newbee.mall.entity.RestaurantMenuPhoto;
import ltd.newbee.mall.entity.RestaurantPhoto;
import ltd.newbee.mall.entity.RestaurantPhotoCommitment;
import ltd.newbee.mall.entity.RestaurantReview;
import ltd.newbee.mall.entity.RestaurantSeatsMenu;
import ltd.newbee.mall.entity.RestaurantSeatsPhoto;
import ltd.newbee.mall.entity.RestaurantTakeout;

public interface TabelogService {
	
	/* -------------------------------- Portal -------------------------------- */
	// 曖昧検索(Keyword)
	ArrayList<RestaurantKeyword> getKeywordList(String keyword);
	// 曖昧検索(Area)
	ArrayList<RestaurantJapanRegion> getCityList(String cityName);
	ArrayList<RestaurantJapanRegion> getDistrictList(String districtName);
	ArrayList<RestaurantJapanStation> getStationList(String stationName);
	
	/* -------------------------------- Detail Page (Header) -------------------------------- */
	// Keyword
	ArrayList<RestaurantKeyword> getKeywordByRestaurantId(long restaurantId);
	// RestaurantBasicInfo
	ArrayList<RestaurantBasicInfo> getRestaurantBasicInfo(long restaurantId);
	// restaurant_reviewの各点数の平均評価
	double getAverageScoreByRestaurantId(long restaurantId);
	// Count Of Review
	long getCountOfReview(long restaurantId);
	// Count Of Followed
	long getCountOfFollowed(long restaurantId);
	// Go To Eat
	String getGoToEat(long restaurantId);
	
	/* -------------------------------- Detail Page (Top) -------------------------------- */
	// Top Slide Photo
	ArrayList<RestaurantPhoto> getSlidePhoto(long restaurantId);
	// Top Kodawari
	ArrayList<RestaurantPhotoCommitment> getKodawari(long restaurantId);
	// Top Course
	ArrayList<RestaurantMenuCourse> getMenuCourse(long restaurantId);
	// Review
	ArrayList<RestaurantReview> getReview(long restaurantId);
	// Disease Control
	ArrayList<RestaurantDiseaseControl> getDiseaseControlList(long restaurantId);
	// Takeout
	ArrayList<RestaurantTakeout> getTakeoutList(long restaurantId);
	// Seats Menu
	ArrayList<RestaurantSeatsMenu> getSeatsMenu(long restaurantId);
	// Restaurant Features Info
	ArrayList<RestaurantFeaturesInfo> getRestaurantFeaturesInfo(long restaurantId);
	
	/* -------------------------------- Detail Page (Table) -------------------------------- */
	// Seats Photo
	ArrayList<RestaurantSeatsPhoto> getSeatsPhoto(long restaurantId);
	
	/* -------------------------------- Detail Page (Menu) -------------------------------- */
	// Menu Meal
    ArrayList<RestaurantMenuMeal> getMenuMeal(long restaurantId);
	// Menu Drink
	ArrayList<RestaurantMenuDrink> getMenuDrink(long restaurantId);
	// Menu Lunch
    ArrayList<RestaurantMenuLunch> getMenuLunch(long restaurantId);
    // Menu Photo
    ArrayList<RestaurantMenuPhoto> getMenuPhoto(long restaurantId);
    // Count Of Menu Course
 	long getCountOfMenuCourse(long restaurantId);
    // Count Of Menu Meal
 	long getCountOfMenuMeal(long restaurantId);
    // Count Of Menu Drink
 	long getCountOfMenuDrink(long restaurantId);
    // Count Of Menu Lunch
 	long getCountOfMenuLunch(long restaurantId);
    // Count Of Menu Photo
 	long getCountOfMenuPhoto(long restaurantId);
	
}

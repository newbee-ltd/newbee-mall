package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.TabelogMapper;
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
import ltd.newbee.mall.service.TabelogService;

@Service
public class TabelogServiceImpl implements TabelogService {
	
	@Autowired
	private TabelogMapper tabelogMapper;
	
	/* -------------------------------- Portal -------------------------------- */
	// 曖昧検索(Keyword)
	@Override
	public ArrayList<RestaurantKeyword> getKeywordList(String keyword) {
		return tabelogMapper.getKeywordList(keyword);
	}
	
	// 曖昧検索(Area)
	@Override
	public ArrayList<RestaurantJapanRegion> getCityList(String cityName) {
		return tabelogMapper.getCityList(cityName);
	}
	@Override
	public ArrayList<RestaurantJapanRegion> getDistrictList(String districtName) {
		return tabelogMapper.getDistrictList(districtName);
	}
	@Override
	public ArrayList<RestaurantJapanStation> getStationList(String stationName) {
		return tabelogMapper.getStationList(stationName);
	}
	
	/* -------------------------------- Detail Page (Header) -------------------------------- */
	// Keyword
	@Override
	public ArrayList<RestaurantKeyword> getKeywordByRestaurantId(long restaurantId) {
		return tabelogMapper.getKeywordByRestaurantId(restaurantId);
	}
	// RestaurantBasicInfo
	@Override
	public ArrayList<RestaurantBasicInfo> getRestaurantBasicInfo(long restaurantId) {
		return tabelogMapper.getRestaurantBasicInfo(restaurantId);
	}
	// restaurant_reviewの各点数の平均評価
	@Override
	public double getAverageScoreByRestaurantId(long restaurantId) {
		return tabelogMapper.getAverageScoreByRestaurantId(restaurantId);
	}
	// Count Of Review
	@Override
	public long getCountOfReview(long restaurantId) {
		return tabelogMapper.getCountOfReview(restaurantId);
	}
	// Count Of Followed
	@Override
    public long getCountOfFollowed(long restaurantId) {
		return tabelogMapper.getCountOfFollowed(restaurantId);
	}
	// Go To Eat
	@Override
	public String getGoToEat(long restaurantId) {
		return tabelogMapper.getGoToEat(restaurantId);
	}
	
	/* -------------------------------- Detail Page (Top) -------------------------------- */
	// Top Slide Photo
	@Override
	public ArrayList<RestaurantPhoto> getSlidePhoto(long restaurantId) {
		return tabelogMapper.getSlidePhoto(restaurantId);
	}
	// Top Kodawari
	@Override
	public ArrayList<RestaurantPhotoCommitment> getKodawari(long restaurantId) {
		return tabelogMapper.getKodawari(restaurantId);
	}
	// Top Course
	@Override
	public ArrayList<RestaurantMenuCourse> getMenuCourse(long restaurantId) {
		return tabelogMapper.getMenuCourse(restaurantId);
	}
	// Review
	@Override
	public ArrayList<RestaurantReview> getReview(long restaurantId) {
		return tabelogMapper.getReview(restaurantId);
	}
	// Disease Control
	@Override
	public ArrayList<RestaurantDiseaseControl> getDiseaseControlList(long restaurantId) {
		return tabelogMapper.getDiseaseControlList(restaurantId);
	}
	// Takeout
	@Override
	public ArrayList<RestaurantTakeout> getTakeoutList(long restaurantId) {
		return tabelogMapper.getTakeoutList(restaurantId);
	}
	// Seats Menu
	@Override
	public ArrayList<RestaurantSeatsMenu> getSeatsMenu(long restaurantId) {
		return tabelogMapper.getSeatsMenu(restaurantId);
	}
	// Restaurant Features Info
	@Override
	public ArrayList<RestaurantFeaturesInfo> getRestaurantFeaturesInfo(long restaurantId) {
		return tabelogMapper.getRestaurantFeaturesInfo(restaurantId);
	}
	
	/* -------------------------------- Detail Page (Table) -------------------------------- */
	// Seats Photo
	@Override
	public ArrayList<RestaurantSeatsPhoto> getSeatsPhoto(long restaurantId) {
		return tabelogMapper.getSeatsPhoto(restaurantId);
	}
	
	/* -------------------------------- Detail Page (Menu) -------------------------------- */
	// Menu Meal
	@Override
    public ArrayList<RestaurantMenuMeal> getMenuMeal(long restaurantId) {
		return tabelogMapper.getMenuMeal(restaurantId);
    }
	// Menu Drink
	@Override
	public ArrayList<RestaurantMenuDrink> getMenuDrink(long restaurantId) {
		return tabelogMapper.getMenuDrink(restaurantId);
	}
	// Menu Lunch
	@Override
    public ArrayList<RestaurantMenuLunch> getMenuLunch(long restaurantId) {
		return tabelogMapper.getMenuLunch(restaurantId);
	}
	// Menu Photo
	@Override
    public ArrayList<RestaurantMenuPhoto> getMenuPhoto(long restaurantId) {
		return tabelogMapper.getMenuPhoto(restaurantId);
    }
	// Count Of Menu Course
	@Override
 	public long getCountOfMenuCourse(long restaurantId) {
 		return tabelogMapper.getCountOfMenuCourse(restaurantId);
 	}
    // Count Of Menu Meal
 	@Override
 	public long getCountOfMenuMeal(long restaurantId) {
 		return tabelogMapper.getCountOfMenuMeal(restaurantId);
 	}
    // Count Of Menu Drink
 	@Override
 	public long getCountOfMenuDrink(long restaurantId) {
 		return tabelogMapper.getCountOfMenuDrink(restaurantId);
 	}
    // Count Of Menu Lunch
 	@Override
 	public long getCountOfMenuLunch(long restaurantId) {
 		return tabelogMapper.getCountOfMenuLunch(restaurantId);
 	}
    // Count Of Menu Photo
 	@Override
 	public long getCountOfMenuPhoto(long restaurantId) {
 		return tabelogMapper.getCountOfMenuPhoto(restaurantId);
 	}
    
}

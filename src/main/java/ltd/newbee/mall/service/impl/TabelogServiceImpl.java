package ltd.newbee.mall.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.dao.TabelogMapper;
import ltd.newbee.mall.entity.RestaurantBasicInfo;
import ltd.newbee.mall.entity.RestaurantJapanRegion;
import ltd.newbee.mall.entity.RestaurantJapanStation;
import ltd.newbee.mall.entity.RestaurantKeyword;
import ltd.newbee.mall.entity.RestaurantMenuCourse;
import ltd.newbee.mall.entity.RestaurantPhoto;
import ltd.newbee.mall.entity.RestaurantPhotoCommitment;
import ltd.newbee.mall.entity.RestaurantReview;
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
	
	/* -------------------------------- Detail Page -------------------------------- */
	// Keyword(Header)
	@Override
	public ArrayList<RestaurantKeyword> getKeywordByRestaurantId(long restaurantId) {
		return tabelogMapper.getKeywordByRestaurantId(restaurantId);
	}
	// RestaurantBasicInfo(Header)
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
    
}

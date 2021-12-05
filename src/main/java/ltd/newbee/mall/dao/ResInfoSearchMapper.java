package ltd.newbee.mall.dao;

import java.util.List;

import ltd.newbee.mall.entity.ResInfoSearch;

public interface ResInfoSearchMapper {

	List<String> getCityName(String cityName);
	List<String> getTownName(String townName);
	List<String> getStationName(String stationName);
	List<String> getKeywords(String keyword);
	List<ResInfoSearch> getReserveInfo();
	
}

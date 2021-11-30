package ltd.newbee.mall.entity;

import java.sql.Time;
import java.util.Date;

public class ResInfoSearch {

	private String cityName;
	private String townName;
	private String stationName;
	private String location;

	private long restaurantId;
	private long seatsNum;
	private Time lunchStart;
	private Time lunchEnd;
	private Time dinnerStart;
	private Time dinnerEnd;

	private int holiday1;
	private int holiday2;
	private int holiday3;
	private int holiday4;
	private int holiday5;
	private int holiday6;
	private int holiday7;

	private Date holidayFrom1;
	private Date holidayTo1;

	private String keywords;

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getSeatsNum() {
		return seatsNum;
	}

	public void setSeatsNum(long seatsNum) {
		this.seatsNum = seatsNum;
	}

	public Time getLunchStart() {
		return lunchStart;
	}

	public void setLunchStart(Time lunchStart) {
		this.lunchStart = lunchStart;
	}

	public Time getLunchEnd() {
		return lunchEnd;
	}

	public void setLunchEnd(Time lunchEnd) {
		this.lunchEnd = lunchEnd;
	}

	public Time getDinnerStart() {
		return dinnerStart;
	}

	public void setDinnerStart(Time dinnerStart) {
		this.dinnerStart = dinnerStart;
	}

	public Time getDinnerEnd() {
		return dinnerEnd;
	}

	public void setDinnerEnd(Time dinnerEnd) {
		this.dinnerEnd = dinnerEnd;
	}

	public int getHoliday1() {
		return holiday1;
	}

	public void setHoliday1(int holiday1) {
		this.holiday1 = holiday1;
	}

	public int getHoliday2() {
		return holiday2;
	}

	public void setHoliday2(int holiday2) {
		this.holiday2 = holiday2;
	}

	public int getHoliday3() {
		return holiday3;
	}

	public void setHoliday3(int holiday3) {
		this.holiday3 = holiday3;
	}

	public int getHoliday4() {
		return holiday4;
	}

	public void setHoliday4(int holiday4) {
		this.holiday4 = holiday4;
	}

	public int getHoliday5() {
		return holiday5;
	}

	public void setHoliday5(int holiday5) {
		this.holiday5 = holiday5;
	}

	public int getHoliday6() {
		return holiday6;
	}

	public void setHoliday6(int holiday6) {
		this.holiday6 = holiday6;
	}

	public int getHoliday7() {
		return holiday7;
	}

	public void setHoliday7(int holiday7) {
		this.holiday7 = holiday7;
	}

	public Date getHolidayFrom1() {
		return holidayFrom1;
	}

	public void setHolidayFrom1(Date holidayFrom1) {
		this.holidayFrom1 = holidayFrom1;
	}

	public Date getHolidayTo1() {
		return holidayTo1;
	}

	public void setHolidayTo1(Date holidayTo1) {
		this.holidayTo1 = holidayTo1;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}

package ltd.newbee.mall.entity;

import java.sql.Time;

public class RestaurantSeatsMenu {
	
	private long restaurantId;
	private String restaurantName;
	private long seatsNum;
	private String seatsRemark;
	private String privateRoom;
	private String privateRemark;
	private String reservable;
	private String reservableRemark;
	private String smokingCessation;
	private String smokingRemark;
	private String parking;
	private String parkingRemark;
	private String spaceEquipment;
	private String cellPhon;
	private String course;
	private String drink;
	private String gourmet;
	private Time lunch_start;
	private Time lunch_end;
	private Time dinner_start;
	private Time dinner_end;
	private String keyword;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public long getSeatsNum() {
		return seatsNum;
	}
	public void setSeatsNum(long seatsNum) {
		this.seatsNum = seatsNum;
	}
	public String getSeatsRemark() {
		return seatsRemark;
	}
	public void setSeatsRemark(String seatsRemark) {
		this.seatsRemark = seatsRemark;
	}
	public String getPrivateRoom() {
		return privateRoom;
	}
	public void setPrivateRoom(String privateRoom) {
		this.privateRoom = privateRoom;
	}
	public String getPrivateRemark() {
		return privateRemark;
	}
	public void setPrivateRemark(String privateRemark) {
		this.privateRemark = privateRemark;
	}
	public String getReservable() {
		return reservable;
	}
	public void setReservable(String reservable) {
		this.reservable = reservable;
	}
	public String getReservableRemark() {
		return reservableRemark;
	}
	public void setReservableRemark(String reservableRemark) {
		this.reservableRemark = reservableRemark;
	}
	public String getSmokingCessation() {
		return smokingCessation;
	}
	public void setSmokingCessation(String smokingCessation) {
		this.smokingCessation = smokingCessation;
	}
	public String getSmokingRemark() {
		return smokingRemark;
	}
	public void setSmokingRemark(String smokingRemark) {
		this.smokingRemark = smokingRemark;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getParkingRemark() {
		return parkingRemark;
	}
	public void setParkingRemark(String parkingRemark) {
		this.parkingRemark = parkingRemark;
	}
	public String getSpaceEquipment() {
		return spaceEquipment;
	}
	public void setSpaceEquipment(String spaceEquipment) {
		this.spaceEquipment = spaceEquipment;
	}
	public String getCellPhon() {
		return cellPhon;
	}
	public void setCellPhon(String cellPhon) {
		this.cellPhon = cellPhon;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getGourmet() {
		return gourmet;
	}
	public void setGourmet(String gourmet) {
		this.gourmet = gourmet;
	}
	public Time getLunch_start() {
		return lunch_start;
	}
	public void setLunch_start(Time lunch_start) {
		this.lunch_start = lunch_start;
	}
	public Time getLunch_end() {
		return lunch_end;
	}
	public void setLunch_end(Time lunch_end) {
		this.lunch_end = lunch_end;
	}
	public Time getDinner_start() {
		return dinner_start;
	}
	public void setDinner_start(Time dinner_start) {
		this.dinner_start = dinner_start;
	}
	public Time getDinner_end() {
		return dinner_end;
	}
	public void setDinner_end(Time dinner_end) {
		this.dinner_end = dinner_end;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}

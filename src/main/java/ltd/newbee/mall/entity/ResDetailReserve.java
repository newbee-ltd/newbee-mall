package ltd.newbee.mall.entity;

import java.sql.Time;
import java.util.Date;

public class ResDetailReserve {

	private long restaurantId;
	private long seatsNum;
	private String seatsRemark;
	private String privateRoom;
	private String privateRemark;
	private Date reserveDate;
	private Time reserveTime;
	private long reserveNum;
	private long roomNo;
	private long courseId;
	private long privateRoomNum;
	private long commonTableNum;
	private Time lunchStart;
	private Time lunchEnd;
	private Time dinnerStart;
	private Time dinnerEnd;
	
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
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public Time getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Time reserveTime) {
		this.reserveTime = reserveTime;
	}
	public long getReserveNum() {
		return reserveNum;
	}
	public void setReserveNum(long reserveNum) {
		this.reserveNum = reserveNum;
	}
	public long getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(long roomNo) {
		this.roomNo = roomNo;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public long getPrivateRoomNum() {
		return privateRoomNum;
	}
	public void setPrivateRoomNum(long privateRoomNum) {
		this.privateRoomNum = privateRoomNum;
	}
	public long getCommonTableNum() {
		return commonTableNum;
	}
	public void setCommonTableNum(long commonTableNum) {
		this.commonTableNum = commonTableNum;
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
	
	
}

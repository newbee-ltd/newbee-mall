package ltd.newbee.mall.entity;

public class ResDetailCourse {

	private long restaurantId;
	private long courseId;
	private String courseName;
	private String courseDetail;
	private String courseImg;
	private String coursePrice;
	private String coursePriceDiscount;
	private long courseItemNum;
	private String availableTime;
	private String availablePeople;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDetail() {
		return courseDetail;
	}
	public void setCourseDetail(String courseDetail) {
		this.courseDetail = courseDetail;
	}
	public String getCourseImg() {
		return courseImg;
	}
	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}
	public String getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getCoursePriceDiscount() {
		return coursePriceDiscount;
	}
	public void setCoursePriceDiscount(String coursePriceDiscount) {
		this.coursePriceDiscount = coursePriceDiscount;
	}
	public long getCourseItemNum() {
		return courseItemNum;
	}
	public void setCourseItemNum(long courseItemNum) {
		this.courseItemNum = courseItemNum;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public String getAvailablePeople() {
		return availablePeople;
	}
	public void setAvailablePeople(String availablePeople) {
		this.availablePeople = availablePeople;
	}
	
}

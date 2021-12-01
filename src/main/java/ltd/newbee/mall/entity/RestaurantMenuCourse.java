package ltd.newbee.mall.entity;

public class RestaurantMenuCourse {
	
	private long restaurantId;
	private String restaurantName;
	private long courseId;
	private String courseName;
	private String courseDetail;
	private String courseImg;
	private long coursePrice;
	private String coursePriceDiscount;
	private long courseItemNum;
	private long availableHour;
	private String availableTime;
	private String availablePeople;
	private String drinkAll;
	private String courseContent;
	private String courseNote;
	
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
	public long getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(long coursePrice) {
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
	public long getAvailableHour() {
		return availableHour;
	}
	public void setAvailableHour(long availableHour) {
		this.availableHour = availableHour;
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
	public String getDrinkAll() {
		return drinkAll;
	}
	public void setDrinkAll(String drinkAll) {
		this.drinkAll = drinkAll;
	}
	public String getCourseContent() {
		return courseContent;
	}
	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}
	public String getCourseNote() {
		return courseNote;
	}
	public void setCourseNote(String courseNote) {
		this.courseNote = courseNote;
	}

}

package ltd.newbee.mall.entity;

public class RestaurantTakeout {
	
	private long restaurantId;
	private String restaurantName;
	private String takeoutImg1;
	private String takeoutImg2;
	private String takeoutImg3;
	private String availableTime;
	private String menu;
	
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
	public String getTakeoutImg1() {
		return takeoutImg1;
	}
	public void setTakeoutImg1(String takeoutImg1) {
		this.takeoutImg1 = takeoutImg1;
	}
	public String getTakeoutImg2() {
		return takeoutImg2;
	}
	public void setTakeoutImg2(String takeoutImg2) {
		this.takeoutImg2 = takeoutImg2;
	}
	public String getTakeoutImg3() {
		return takeoutImg3;
	}
	public void setTakeoutImg3(String takeoutImg3) {
		this.takeoutImg3 = takeoutImg3;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
}

package ltd.newbee.mall.entity;

public class RestaurantMenuLunch {
	
	private long restaurantId;
	private String restaurantName;
	private long lunchGenreId;
	private String lunchGenreName;
	private long lunchId;
	private String lunchName;
	private String lunchImg;
	private String lunchRemark;
	private String lunchPrice;
	
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
	public long getLunchGenreId() {
		return lunchGenreId;
	}
	public void setLunchGenreId(long lunchGenreId) {
		this.lunchGenreId = lunchGenreId;
	}
	public String getLunchGenreName() {
		return lunchGenreName;
	}
	public void setLunchGenreName(String lunchGenreName) {
		this.lunchGenreName = lunchGenreName;
	}
	public long getLunchId() {
		return lunchId;
	}
	public void setLunchId(long lunchId) {
		this.lunchId = lunchId;
	}
	public String getLunchName() {
		return lunchName;
	}
	public void setLunchName(String lunchName) {
		this.lunchName = lunchName;
	}
	public String getLunchImg() {
		return lunchImg;
	}
	public void setLunchImg(String lunchImg) {
		this.lunchImg = lunchImg;
	}
	public String getLunchRemark() {
		return lunchRemark;
	}
	public void setLunchRemark(String lunchRemark) {
		this.lunchRemark = lunchRemark;
	}
	public String getLunchPrice() {
		return lunchPrice;
	}
	public void setLunchPrice(String lunchPrice) {
		this.lunchPrice = lunchPrice;
	}
	
}

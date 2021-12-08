package ltd.newbee.mall.entity;

public class RestaurantMenuMeal {
	
	private long restaurantId;
	private String restaurantName;
	private long genreId;
	private String genreName;
	private String genreImg;
	private long dishId;
	private String dishName;
	private String dishImg;
	private long dishPrice;
	private String dishRemark;
	
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
	public long getGenreId() {
		return genreId;
	}
	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getGenreImg() {
		return genreImg;
	}
	public void setGenreImg(String genreImg) {
		this.genreImg = genreImg;
	}
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishImg() {
		return dishImg;
	}
	public void setDishImg(String dishImg) {
		this.dishImg = dishImg;
	}
	public long getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(long dishPrice) {
		this.dishPrice = dishPrice;
	}
	public String getDishRemark() {
		return dishRemark;
	}
	public void setDishRemark(String dishRemark) {
		this.dishRemark = dishRemark;
	}
	
}

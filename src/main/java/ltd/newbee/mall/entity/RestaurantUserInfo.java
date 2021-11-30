package ltd.newbee.mall.entity;

public class RestaurantUserInfo {
	
	private long restaurantId;
	private long userId;
	private String userName;
	private long followResId;
	private long reviewId;
	private long wentResId;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getFollowResId() {
		return followResId;
	}
	public void setFollowResId(long followResId) {
		this.followResId = followResId;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getWentResId() {
		return wentResId;
	}
	public void setWentResId(long wentResId) {
		this.wentResId = wentResId;
	}
	
}

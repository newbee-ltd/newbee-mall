package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestaurantMenuPhoto {
	
	private long restaurantId;
	private String restaurantName;
	private long photoId;
	private String photoName;
	private String photoUrl;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date photoPostDate;
	private long postUserId;
	private String postUserName;
	
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
	public long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Date getPhotoPostDate() {
		return photoPostDate;
	}
	public void setPhotoPostDate(Date photoPostDate) {
		this.photoPostDate = photoPostDate;
	}
	public long getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(long postUserId) {
		this.postUserId = postUserId;
	}
	public String getPostUserName() {
		return postUserName;
	}
	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}
	
}

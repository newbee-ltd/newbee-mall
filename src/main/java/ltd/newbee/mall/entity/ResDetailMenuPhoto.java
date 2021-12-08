package ltd.newbee.mall.entity;

import java.util.Date;

public class ResDetailMenuPhoto {

	private long restaurantId;
	private long photoId;
	private String photoUrl;
	private Date photoPostDate;
	private String postUserName;
	private long helpNum;
	private int menuPhotoCount;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(long photoId) {
		this.photoId = photoId;
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
	public String getPostUserName() {
		return postUserName;
	}
	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}
	public long getHelpNum() {
		return helpNum;
	}
	public void setHelpNum(long helpNum) {
		this.helpNum = helpNum;
	}
	public int getMenuPhotoCount() {
		return menuPhotoCount;
	}
	public void setMenuPhotoCount(int menuPhotoCount) {
		this.menuPhotoCount = menuPhotoCount;
	}
	
	
}

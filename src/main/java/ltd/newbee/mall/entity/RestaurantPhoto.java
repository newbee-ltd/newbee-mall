package ltd.newbee.mall.entity;

public class RestaurantPhoto {
	
	private long restaurantId;
	private long photoId;
	private String photoUrl;
	private String photoDetail;
	private long photoCode;
	private String postByName;
	private long postUserId;
	
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
	public String getPhotoDetail() {
		return photoDetail;
	}
	public void setPhotoDetail(String photoDetail) {
		this.photoDetail = photoDetail;
	}
	public long getPhotoCode() {
		return photoCode;
	}
	public void setPhotoCode(long photoCode) {
		this.photoCode = photoCode;
	}
	public String getPostByName() {
		return postByName;
	}
	public void setPostByName(String postByName) {
		this.postByName = postByName;
	}
	public long getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(long postUserId) {
		this.postUserId = postUserId;
	}
	
}

package ltd.newbee.mall.entity;

public class RestaurantPhotoCommitment {
	
	private long restaurantId;
	private long photoId;
	private String photoUrl;
	private String photoTitle;
	private String photoDetail;
	private String photoType;
	private String typeColor;
	
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
	public String getPhotoTitle() {
		return photoTitle;
	}
	public void setPhotoTitle(String photoTitle) {
		this.photoTitle = photoTitle;
	}
	public String getPhotoDetail() {
		return photoDetail;
	}
	public void setPhotoDetail(String photoDetail) {
		this.photoDetail = photoDetail;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getTypeColor() {
		return typeColor;
	}
	public void setTypeColor(String typeColor) {
		this.typeColor = typeColor;
	}
	
}

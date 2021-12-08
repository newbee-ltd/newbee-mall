package ltd.newbee.mall.entity;

public class RestaurantSeatsPhoto {
	
	private long restaurantId;
	private String privateRoomImg;
	private String tableSeatImg;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getPrivateRoomImg() {
		return privateRoomImg;
	}
	public void setPrivateRoomImg(String privateRoomImg) {
		this.privateRoomImg = privateRoomImg;
	}
	public String getTableSeatImg() {
		return tableSeatImg;
	}
	public void setTableSeatImg(String tableSeatImg) {
		this.tableSeatImg = tableSeatImg;
	}
}

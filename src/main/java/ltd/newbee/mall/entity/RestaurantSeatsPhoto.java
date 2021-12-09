package ltd.newbee.mall.entity;

public class RestaurantSeatsPhoto {
	
	private long restaurantId;
	private String privateRoomImg;
	private String tableSeatImg;
	private String outterviewImg;
	
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
	public String getOutterviewImg() {
		return outterviewImg;
	}
	public void setOutterviewImg(String outterviewImg) {
		this.outterviewImg = outterviewImg;
	}
}

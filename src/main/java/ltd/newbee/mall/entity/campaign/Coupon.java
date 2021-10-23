package ltd.newbee.mall.entity.campaign;

import java.util.Date;

public class Coupon {

	private long couponId;
	private String couponNo;
	private Date insertDate;
	private String insertUser;
	private Date updateDate;
	private String updateUser;
	
	
	public long getCouponId() {
		return couponId;
	}
	public void setCoupon_id(long couponId) {
		this.couponId = couponId;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public String getInsertUser() {
		return insertUser;
	}
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}
	
	
	
}

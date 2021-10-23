package ltd.newbee.mall.entity.campaign;

import java.util.Date;

public class ApplyCategoryCampaign {

	private long categoryId;
	private long campaignId;
	private long freeGoodsId;
	private Date insertDate;
	private String insertUser;
	private Date updateDate;
	private String updateUser;
	private Date valid_date_from;
	private Date valid_date_to;
	
	public long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
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
	public Date getValid_date_from() {
		return valid_date_from;
	}
	public void setValid_date_from(Date valid_date_from) {
		this.valid_date_from = valid_date_from;
	}
	public Date getValid_date_to() {
		return valid_date_to;
	}
	public void setValid_date_to(Date valid_date_to) {
		this.valid_date_to = valid_date_to;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getFreeGoodsId() {
		return freeGoodsId;
	}
	public void setFreeGoodsId(long freeGoodsId) {
		this.freeGoodsId = freeGoodsId;
	}

	
	
}

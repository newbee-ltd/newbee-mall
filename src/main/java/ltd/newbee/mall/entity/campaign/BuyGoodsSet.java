package ltd.newbee.mall.entity.campaign;

import java.util.Date;

public class BuyGoodsSet {

	private long campaignId;
	private String campaignName;
	private long buyGoodsId;
	private long freeGoodsId;
	private Date insertDate;
	private String insertUser;
	private Date updateDate;
	private String updateUser;
	
	
	public long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public long getBuyGoodsId() {
		return buyGoodsId;
	}
	public void setBuyGoodsId(long buyGoodsId) {
		this.buyGoodsId = buyGoodsId;
	}
	public long getFreeGoodsId() {
		return freeGoodsId;
	}
	public void setFreeGoodsId(long freeGoodsId) {
		this.freeGoodsId = freeGoodsId;
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
	
	
	
}

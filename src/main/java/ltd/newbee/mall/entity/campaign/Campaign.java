package ltd.newbee.mall.entity.campaign;

import java.util.Date;

public class Campaign {

	private long campaignId;
	private String campaignName;
	//private Date insertDate;
	//private String insertUser;
	
	public long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}
//	public Date getInsertDate() {
//		return insertDate;
//	}
//	public void setInsertDate(Date insertDate) {
//		this.insertDate = insertDate;
//	}
//	public String getInsertUser() {
//		return insertUser;
//	}
//	public void setInsertUser(String insertUser) {
//		this.insertUser = insertUser;
//	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
}

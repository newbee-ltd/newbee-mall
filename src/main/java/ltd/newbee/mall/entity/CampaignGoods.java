package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CampaignGoods {
	
	private long campaignId;
//	private String campaignName;
	private long goodsId;
//	private String goodsName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date validDateFrom;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date validDateTo;
	private long parentId;
	private int deleteFlg;
	
//	private String filePath;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date insertDate;
	private long insertUser;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;
	private long updateUser;
	
	
	public long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}
//	public String getCampaignName() {
//		return campaignName;
//	}
//	public void setCampaignName(String campaignName) {
//		this.campaignName = campaignName;
//	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
//	public String getGoodsName() {
//		return goodsName;
//	}
//	public void setGoodsName(String goodsName) {
//		this.goodsName = goodsName;
//	}
	public Date getValidDateFrom() {
		return validDateFrom;
	}
	public void setValidDateFrom(Date validDateFrom) {
		this.validDateFrom = validDateFrom;
	}
	public Date getValidDateTo() {
		return validDateTo;
	}
	public void setValidDateTo(Date validDateTo) {
		this.validDateTo = validDateTo;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public int getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	
//	public String getFilePath() {
//		return filePath;
//	}
//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public long getInsertUser() {
		return insertUser;
	}
	public void setInsertUser(long insertUser) {
		this.insertUser = insertUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public long getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(long updateUser) {
		this.updateUser = updateUser;
	}
	
}

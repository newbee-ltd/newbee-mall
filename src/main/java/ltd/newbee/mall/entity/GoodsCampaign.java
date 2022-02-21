/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GoodsCampaign {
	private int flag;
	
    private long goodsId;
    
    private long camId;
    
    private Date startDate;
    
    private Date endDate;
    
    private int priority;
    
    private String camKind;
    
    private String camName;
    
    private String goodsName;
    
    private String cal1;
    
    private int isDeleted;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getCamId() {
		return camId;
	}

	public void setCamId(long camId) {
		this.camId = camId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCamKind() {
		return camKind;
	}

	public void setCamKind(String camKind) {
		this.camKind = camKind;
	}

	public String getCamName() {
		return camName;
	}

	public void setCamName(String camName) {
		this.camName = camName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCal1() {
		return cal1;
	}

	public void setCal1(String cal1) {
		this.cal1 = cal1;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "GoodsCampaign [flag=" + flag + ", goodsId=" + goodsId + ", camId=" + camId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", priority=" + priority + ", camKind=" + camKind + ", camName=" + camName
				+ ", goodsName=" + goodsName + ", cal1=" + cal1 + ", isDeleted=" + isDeleted + "]";
	}

	
    

	

    
}
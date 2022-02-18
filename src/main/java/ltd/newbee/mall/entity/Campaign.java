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

public class Campaign {
    private long camId;
    
    private String camKind;
    
    private String createUser;
    
    private Date timeStamp;
    
    private int priority;
    
    private String camName;
    
    private String cal1;
    
    private String cal2;
    
    private String cal3;
    
    private int isDeleted;
    

	public String getCamKind() {
		return camKind;
	}

	public void setCamKind(String camKind) {
		this.camKind = camKind;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public long getCamId() {
		return camId;
	}

	public void setCamId(long camId) {
		this.camId = camId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCamName() {
		return camName;
	}

	public void setCamName(String camName) {
		this.camName = camName;
	}

	public String getCal1() {
		return cal1;
	}

	public void setCal1(String cal1) {
		this.cal1 = cal1;
	}

	public String getCal2() {
		return cal2;
	}

	public void setCal2(String cal2) {
		this.cal2 = cal2;
	}

	public String getCal3() {
		return cal3;
	}

	public void setCal3(String cal3) {
		this.cal3 = cal3;
	}

	@Override
	public String toString() {
		return "Campaign [camId=" + camId + ", camKind=" + camKind + ", createUser=" + createUser + ", timeStamp="
				+ timeStamp + ", priority=" + priority + ", camName=" + camName + ", cal1=" + cal1 + ", cal2=" + cal2
				+ ", cal3=" + cal3 + ", isDeleted=" + isDeleted + "]";
	}


    
}
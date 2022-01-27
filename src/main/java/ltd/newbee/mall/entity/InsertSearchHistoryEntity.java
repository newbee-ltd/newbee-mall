package ltd.newbee.mall.entity;

import java.util.Date;

public class InsertSearchHistoryEntity {
	
	private long userId;
	
	private Date dateTime;
	
	private String keyword;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "InsertSearchHistoryEntity [userId=" + userId + ", dateTime=" + dateTime + ", keyword=" + keyword + "]";
	}
	
	




	
	


}

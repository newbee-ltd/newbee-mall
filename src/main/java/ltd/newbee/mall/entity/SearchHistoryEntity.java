package ltd.newbee.mall.entity;

public class SearchHistoryEntity {
	
	private long userId;
	
	private String dateTime;
	
	private String keyword;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
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
		return "SearchHistoryEntity [userId=" + userId + ", dateTime=" + dateTime + ", keyword=" + keyword + "]";
	}
	
	


}

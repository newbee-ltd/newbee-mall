package ltd.newbee.mall.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchReviewParams extends LinkedHashMap<String, Object> {
	private long reviewMore;
	
	private long reviewType;
	
	private int reviewRate;
	public SearchReviewParams(Map<String,Object>paraMap) {
        this.put("reviewMore", reviewMore);
        this.put("reviewType", reviewType);
        this.put("reviewRate", reviewRate);
	}
	public long getReviewMore() {
		return reviewMore;
	}
	public void setReviewMore(long reviewMore) {
		this.reviewMore = reviewMore;
	}
	public long getReviewType() {
		return reviewType;
	}
	public void setReviewType(long reviewType) {
		this.reviewType = reviewType;
	}
	public int getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}


	
}

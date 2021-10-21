package ltd.newbee.mall.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ltd.newbee.mall.entity.GoodsReview;

public class GoodsReviewUtil extends LinkedHashMap<String, Object> {
  
	private int start;
	private int limit;
	
	public GoodsReviewUtil(Map<String, Object> params) {
        this.putAll(params);
        this.start = Integer.parseInt(String.valueOf(params.get("start")));
        this.limit = Integer.parseInt(String.valueOf(params.get("limit")));
       
    /*    this.reviewUserId = Long.parseLong(params.get("reviewUserId").toString());
        this.star = Short.parseShort(params.get("star").toString());
	    this.submitDate = Date.parse(String.valueOf(params.get("submitDate")));
        this.put("reviewUserId", reviewUserId);
        this.put("star", star);
        this.put("submitDate", submitDate);*/
        this.put("start", start);
        this.put("limit", limit);
    }

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
    @Override
    public String toString() {
        return "GoodsReviewResule{" +
                "start=" + start +
                ", limit=" + limit +
 
                '}';
    }
    
}

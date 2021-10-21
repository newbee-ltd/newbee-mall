package ltd.newbee.mall.util;

import java.util.HashMap;
import java.util.Map;

public class PageInquiryUtil2 extends HashMap<String, Object>{
    
	/**
	 * show more review2
	 */
	
	private int start;
	private int limit;

	public PageInquiryUtil2(Map<String, Object> params) {
		this.putAll(params);
		this.limit = Integer.parseInt(params.get("limit").toString());
		this.start=Integer.parseInt(String.valueOf(params.get("limit")));
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

}

package ltd.newbee.mall.util;

import java.util.HashMap;
import java.util.Map;

public class PageInquiryUtil extends HashMap<String, Object>{
    
	//实例对象
	/**
	 * 学生情報をページに分けて照会する
	 */

	private int start;
	// current page
	private int currentPage;
	// limit 为每页条数（限制每页条多少条数据）
	private int limit;
    // 不要写死
	private String orderByColumn;

	/*
	 * //构造函数
	public PageInquiryUtil(int currentPage, int limit) {
		super();
		this.currentPage = currentPage;
		this.limit = limit;
	}
   */

	public PageInquiryUtil(Map<String, Object> params) {
		this.putAll(params);

		// 分页参数
		this.currentPage = Integer.parseInt(params.get("currentPage").toString());
		this.limit = Integer.parseInt(params.get("limit").toString());
		this.put("start", (currentPage - 1) * limit);
		this.put("page", currentPage);
		this.put("limit", limit);
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public String getOrderByColumn() {
		return orderByColumn;
	}

	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

}

package ltd.newbee.mall.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchPageParams extends LinkedHashMap<String, Object> {
	private int categoryId;
	private int pageNo;
	private String keyword;
	private String orderBy;
	public SearchPageParams(Map<String,Object>paraMap) {
		this.pageNo=(int)paraMap.get("pageNo");
		this.putAll(paraMap);
		int start =(pageNo-1)*3;
        this.put("start", start);
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}

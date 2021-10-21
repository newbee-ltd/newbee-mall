package ltd.newbee.mall.util;

import java.io.Serializable;
import java.util.List;

import ltd.newbee.mall.entity.Review;

/**
 * 分页工具类
 *
 */
public class PageInquiryResult2 implements Serializable {

    //总记录数
    private int totalCount;
    private int limit;
    //列表数据
    private List<?> list;

    /**
     * show more reviews 2
     * @param list       列表数据
     * @param totalCount 总记录数
     */
    public PageInquiryResult2(List<?> list, int totalCount,int limit) {
        this.list = list;
        this.totalCount = totalCount;
    }


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}

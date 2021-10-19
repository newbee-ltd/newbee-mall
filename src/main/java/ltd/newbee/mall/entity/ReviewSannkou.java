package ltd.newbee.mall.entity;

import java.util.Date;

public class ReviewSannkou {

	private long goodsId;
	private long reviewId;
	private long sannkouUserId;
	private Date submitDate;
	
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getSannkouUserId() {
		return sannkouUserId;
	}
	public void setSannkouUserId(long sannkouUserId) {
		this.sannkouUserId = sannkouUserId;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	
}

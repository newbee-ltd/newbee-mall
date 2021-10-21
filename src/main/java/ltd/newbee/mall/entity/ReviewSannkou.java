package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewSannkou {

	private long goodsId;
	private long reviewId;
	private long sannkouUserId;

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
	
	
}

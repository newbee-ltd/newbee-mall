package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GoodsReview {
	
	private long goodsId;
	private long reviewId;
	private long reviewUserId;
	private long sankouUserId;
	private short star;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date submitDate;
	private String reviewTitle;
	private String reviewDetail;
	private String imageUrl;
	private long helpNum;
	private long limit;
	private double averageStar;

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
	public long getReviewUserId() {
		return reviewUserId;
	}
	public void setReviewUserId(long reviewUserId) {
		this.reviewUserId = reviewUserId;
	}
	public long getSankouUserId() {
		return sankouUserId;
	}
	public void setSankouUserId(long sankouUserId) {
		this.sankouUserId = sankouUserId;
	}
	public short getStar() {
		return star;
	}
	public void setStar(short star) {
		this.star = star;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewDetail() {
		return reviewDetail;
	}
	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getHelpNum() {
		return helpNum;
	}
	public void setHelpNum(long helpNum) {
		this.helpNum = helpNum;
	}
	public long getLimit() {
		return limit;
	}
	public void setLimit(long limit) {
		this.limit = limit;
	}
	public double getAverageStar() {
		return averageStar;
	}
	public void setAverageStar(double averageStar) {
		this.averageStar = averageStar;
	}

}

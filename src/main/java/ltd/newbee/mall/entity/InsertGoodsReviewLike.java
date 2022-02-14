package ltd.newbee.mall.entity;

public class InsertGoodsReviewLike {


	private String userId;

	private long goodsId;

	private String reviewTitle;

	private String review;

	private long reviewId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "InsertGoodsReviewLike [userId=" + userId + ", goodsId=" + goodsId + ", reviewTitle=" + reviewTitle
				+ ", review=" + review + ", reviewId=" + reviewId + "]";
	}

	

	

}

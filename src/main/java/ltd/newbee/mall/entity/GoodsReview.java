package ltd.newbee.mall.entity;

public class GoodsReview {



	private int star;

	private String userId;

	private String reviewDate;
	
	private long reviewId;

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	private long goodsId;

	private String reviewTitle;

	private String review;

	private String image;


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
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

	@Override
	public String toString() {
		return "GoodsReview [star=" + star + ", userId=" + userId + ", reviewDate=" + reviewDate + ", reviewId="
				+ reviewId + ", goodsId=" + goodsId + ", reviewTitle=" + reviewTitle + ", review=" + review + ", image="
				+ image + "]";
	}




}

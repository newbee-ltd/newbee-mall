package ltd.newbee.mall.entity;

public class InsertGoodsReview {

	private int star;

	private String user_id;

	private String review_date;

	private long goods_id;

	private String review_title;

	private String review;

	private String image;

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReview_date() {
		return review_date;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(long goods_id) {
		this.goods_id = goods_id;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "InsertGoodsReview [star=" + star + ", user_id=" + user_id + ", review_date=" + review_date
				+ ", goods_id=" + goods_id + ", review_title=" + review_title + ", review=" + review + ", image="
				+ image + "]";
	}

	

	

}

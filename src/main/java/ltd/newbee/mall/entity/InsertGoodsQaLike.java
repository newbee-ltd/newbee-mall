package ltd.newbee.mall.entity;

public class InsertGoodsQaLike {


	private long goodsId;
	
	private long qaId;
	
	private String userId;

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getQaId() {
		return qaId;
	}

	public void setQaId(long qaId) {
		this.qaId = qaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "InsertGoodsQaLike [goodsId=" + goodsId + ", qaId=" + qaId + ", userId=" + userId + "]";
	}
	
	

	

}

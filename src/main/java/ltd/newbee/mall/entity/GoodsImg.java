package ltd.newbee.mall.entity;

public class GoodsImg {

	private long goodsId;
	private String goodsImgUrl;

	
	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImgUrl() {
		return goodsImgUrl;
	}

	public void setGoodsImgUrl(String goodsImgUrl) {
		this.goodsImgUrl = goodsImgUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsImg [goodsId=");
		builder.append(goodsId);
		builder.append(", goodsImgUrl=");
		builder.append(goodsImgUrl);
		builder.append("]");
		return builder.toString();
	}

	
	
}

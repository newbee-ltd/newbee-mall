package ltd.newbee.mall.entity;

public class RecentChkHistory {
	
	private String goodsName;
	
	private String goodsCoverImg;
	
	private Integer originalPrice;
	
	private Integer sellingPrice;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCoverImg() {
		return goodsCoverImg;
	}

	public void setGoodsCoverImg(String goodsCoverImg) {
		this.goodsCoverImg = goodsCoverImg;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}


	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Override
	public String toString() {
		return "RecentChkHistory [goodsName=" + goodsName + ", goodsCoverImg=" + goodsCoverImg + ", originalPrice="
				+ originalPrice + ", sellingPrice=" + sellingPrice + "]";
	}
	
	

}

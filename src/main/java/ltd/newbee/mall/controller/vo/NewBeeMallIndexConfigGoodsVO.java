package ltd.newbee.mall.controller.vo;

import java.io.Serializable;

/**
 * 首页配置商品VO
 */
public class NewBeeMallIndexConfigGoodsVO implements Serializable {

    /** 商品id */
    private Long goodsId;

    /** 商品名字 */
    private String goodsName;

    /** 商品介绍 */
    private String goodsIntro;

    /** 商品封面图片 */
    private String goodsCoverImg;

    /** 商品价格 */
    private Integer sellingPrice;

    /** 商品tag */
    private String tag;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntro() {
        return goodsIntro;
    }

    public void setGoodsIntro(String goodsIntro) {
        this.goodsIntro = goodsIntro;
    }

    public String getGoodsCoverImg() {
        return goodsCoverImg;
    }

    public void setGoodsCoverImg(String goodsCoverImg) {
        this.goodsCoverImg = goodsCoverImg;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

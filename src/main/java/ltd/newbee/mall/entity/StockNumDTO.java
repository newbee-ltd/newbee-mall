package ltd.newbee.mall.entity;

/**
 * 库存修改所需实体
 */
public class StockNumDTO {
    private Long goodsId;

    private Integer goodsCount;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}

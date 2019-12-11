package ltd.newbee.mall.controller.vo;

import java.io.Serializable;

/**
 * 首页分类数据VO(第三级)
 */
public class ThirdLevelCategoryVO implements Serializable {

    /** 商品分类id */
    private Long categoryId;

    /** 商品分类等级 现在最多三级 */
    private Byte categoryLevel;

    /** 商品分类名称 */
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

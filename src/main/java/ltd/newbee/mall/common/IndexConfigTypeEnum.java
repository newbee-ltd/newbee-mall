package ltd.newbee.mall.common;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 * @apiNote 首页配置项 1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐
 */
public enum IndexConfigTypeEnum {

    DEFAULT(0, "DEFAULT"),
    INDEX_SEARCH_HOTS(1, "INDEX_SEARCH_HOTS"),
    INDEX_SEARCH_DOWN_HOTS(2, "INDEX_SEARCH_DOWN_HOTS"),
    INDEX_GOODS_HOT(3, "INDEX_GOODS_HOTS"),
    INDEX_GOODS_NEW(4, "INDEX_GOODS_NEW"),
    INDEX_GOODS_RECOMMOND(5, "INDEX_GOODS_RECOMMOND");

    private int type;

    private String name;

    IndexConfigTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static IndexConfigTypeEnum getIndexConfigTypeEnumByType(int type) {
        for (IndexConfigTypeEnum indexConfigTypeEnum : IndexConfigTypeEnum.values()) {
            if (indexConfigTypeEnum.getType() == type) {
                return indexConfigTypeEnum;
            }
        }
        return DEFAULT;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

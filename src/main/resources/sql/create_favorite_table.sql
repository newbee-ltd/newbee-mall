-- 创建用户收藏表
CREATE TABLE tb_newbee_mall_user_favorite (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    goods_id BIGINT NOT NULL COMMENT '商品ID',
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
    UNIQUE KEY uk_user_goods (user_id, goods_id) COMMENT '用户和商品的唯一约束，确保用户对同一商品只能收藏一次'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户商品收藏表';

-- 添加索引
CREATE INDEX idx_user_id ON tb_newbee_mall_user_favorite(user_id);
CREATE INDEX idx_goods_id ON tb_newbee_mall_user_favorite(goods_id);
-- ----------------------------
-- 商品收藏表 tb_newbee_mall_user_favorite
-- ----------------------------
DROP TABLE IF EXISTS `tb_newbee_mall_user_favorite`;
CREATE TABLE `tb_newbee_mall_user_favorite` (
  `favorite_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏记录主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品主键id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`favorite_id`),
  UNIQUE KEY `uk_user_goods` (`user_id`,`goods_id`) COMMENT '用户商品唯一索引，防止重复收藏'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户商品收藏表';
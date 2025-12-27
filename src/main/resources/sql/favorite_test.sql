-- =============================================
-- 商品收藏功能测试脚本
-- =============================================

-- 1. 测试数据准备
-- 假设已有用户和商品数据，这里插入一些测试数据

-- 插入测试用户（如果还没有的话）
INSERT INTO `tb_newbee_mall_user` (`user_id`, `nick_name`, `login_name`, `password_md5`, `introduce_sign`, `address`, `is_deleted`, `locked_flag`, `create_time`) VALUES 
(1, '测试用户1', 'testuser1', 'e10adc3949ba59abbe56e057f20f883e', '这是一个测试用户', '北京市朝阳区', 0, 0, NOW()),
(2, '测试用户2', 'testuser2', 'e10adc3949ba59abbe56e057f20f883e', '这是另一个测试用户', '上海市浦东新区', 0, 0, NOW());

-- 插入测试商品（如果还没有的话）
INSERT INTO `tb_newbee_mall_goods` (`goods_id`, `goods_name`, `goods_intro`, `goods_category_id`, `goods_cover_img`, `goods_carousel`, `goods_detail_content`, `original_price`, `selling_price`, `stock_num`, `tag`, `goods_sell_status`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES 
(1001, '测试商品1', '这是一个测试商品', 1, '/images/test1.jpg', '/images/test1.jpg', '商品详情内容', 100, 80, 100, '新品', 0, 1, NOW(), 1, NOW()),
(1002, '测试商品2', '这是另一个测试商品', 1, '/images/test2.jpg', '/images/test2.jpg', '商品详情内容', 200, 150, 50, '热销', 0, 1, NOW(), 1, NOW()),
(1003, '测试商品3', '这是第三个测试商品', 2, '/images/test3.jpg', '/images/test3.jpg', '商品详情内容', 300, 250, 30, '推荐', 0, 1, NOW(), 1, NOW());

-- 2. 测试收藏功能

-- 测试添加收藏
INSERT INTO `tb_newbee_mall_user_favorite` (`user_id`, `goods_id`) VALUES 
(1, 1001),
(1, 1002),
(1, 1003),
(2, 1001),
(2, 1002);

-- 3. 查询测试

-- 查询用户1的所有收藏商品
SELECT 
    f.favorite_id,
    f.user_id,
    f.goods_id,
    f.create_time,
    g.goods_name,
    g.selling_price,
    g.goods_cover_img
FROM tb_newbee_mall_user_favorite f
JOIN tb_newbee_mall_goods g ON f.goods_id = g.goods_id
WHERE f.user_id = 1
ORDER BY f.create_time DESC;

-- 查询用户2的所有收藏商品
SELECT 
    f.favorite_id,
    f.user_id,
    f.goods_id,
    f.create_time,
    g.goods_name,
    g.selling_price,
    g.goods_cover_img
FROM tb_newbee_mall_user_favorite f
JOIN tb_newbee_mall_goods g ON f.goods_id = g.goods_id
WHERE f.user_id = 2
ORDER BY f.create_time DESC;

-- 查询某个商品被多少用户收藏
SELECT 
    g.goods_id,
    g.goods_name,
    COUNT(f.favorite_id) as favorite_count
FROM tb_newbee_mall_goods g
LEFT JOIN tb_newbee_mall_user_favorite f ON g.goods_id = f.goods_id
WHERE g.goods_id = 1001
GROUP BY g.goods_id, g.goods_name;

-- 查询用户是否收藏了某个商品
SELECT COUNT(*) > 0 as is_favorite
FROM tb_newbee_mall_user_favorite
WHERE user_id = 1 AND goods_id = 1001;

-- 4. 测试删除收藏
-- 删除用户1对商品1001的收藏
DELETE FROM tb_newbee_mall_user_favorite 
WHERE user_id = 1 AND goods_id = 1001;

-- 验证删除结果
SELECT * FROM tb_newbee_mall_user_favorite WHERE user_id = 1;

-- 5. 测试重复收藏（应该失败，因为有唯一索引）
-- 下面的语句应该报错，因为用户1已经收藏了商品1002
-- INSERT INTO tb_newbee_mall_user_favorite (user_id, goods_id) VALUES (1, 1002);

-- 6. 分页查询测试
-- 查询用户1的收藏，每页2条记录，第1页
SELECT 
    f.favorite_id,
    f.user_id,
    f.goods_id,
    f.create_time,
    g.goods_name,
    g.selling_price,
    g.goods_cover_img
FROM tb_newbee_mall_user_favorite f
JOIN tb_newbee_mall_goods g ON f.goods_id = g.goods_id
WHERE f.user_id = 1
ORDER BY f.create_time DESC
LIMIT 0, 2;

-- 查询用户1的收藏，每页2条记录，第2页
SELECT 
    f.favorite_id,
    f.user_id,
    f.goods_id,
    f.create_time,
    g.goods_name,
    g.selling_price,
    g.goods_cover_img
FROM tb_newbee_mall_user_favorite f
JOIN tb_newbee_mall_goods g ON f.goods_id = g.goods_id
WHERE f.user_id = 1
ORDER BY f.create_time DESC
LIMIT 2, 2;

-- 7. 统计查询
-- 查询每个用户的收藏数量
SELECT 
    u.user_id,
    u.nick_name,
    COUNT(f.favorite_id) as favorite_count
FROM tb_newbee_mall_user u
LEFT JOIN tb_newbee_mall_user_favorite f ON u.user_id = f.user_id
GROUP BY u.user_id, u.nick_name
ORDER BY favorite_count DESC;

-- 查询每个商品被收藏的次数
SELECT 
    g.goods_id,
    g.goods_name,
    COUNT(f.favorite_id) as favorite_count
FROM tb_newbee_mall_goods g
LEFT JOIN tb_newbee_mall_user_favorite f ON g.goods_id = f.goods_id
GROUP BY g.goods_id, g.goods_name
ORDER BY favorite_count DESC;

-- 8. 清理测试数据（可选）
-- 如果需要清理测试数据，取消下面的注释
-- DELETE FROM tb_newbee_mall_user_favorite WHERE user_id IN (1, 2);
-- DELETE FROM tb_newbee_mall_user WHERE user_id IN (1, 2);
-- DELETE FROM tb_newbee_mall_goods WHERE goods_id IN (1001, 1002, 1003);
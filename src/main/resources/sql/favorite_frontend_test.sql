-- =============================================
-- 商品收藏功能前端测试说明
-- =============================================

-- 由于数据库连接问题，我们创建前端测试说明文档
-- 以下是收藏功能的测试步骤：

-- 1. 数据库表结构（已创建）
-- 表名：tb_newbee_mall_user_favorite
-- 字段：
--   favorite_id: 主键，自增
--   user_id: 用户ID
--   goods_id: 商品ID  
--   create_time: 创建时间

-- 2. 测试步骤说明：

-- 步骤1：登录系统
-- 访问：http://localhost:28089/login
-- 使用测试账号登录

-- 步骤2：浏览商品
-- 访问商品详情页，例如：http://localhost:28089/goods/detail/10001
-- 页面上应该显示"收藏"按钮

-- 步骤3：添加收藏
-- 点击商品详情页的"收藏"按钮
-- 按钮应该变为"已收藏"状态
-- 可以通过浏览器开发者工具查看AJAX请求

-- 步骤4：查看收藏列表
-- 访问个人中心：http://localhost:28089/personal
-- 点击侧边栏的"我的收藏"
-- 应该显示收藏的商品列表

-- 步骤5：取消收藏
-- 在收藏列表页面点击"取消收藏"按钮
-- 商品应该从列表中移除

-- 步骤6：验证重复收藏
-- 再次访问已收藏的商品详情页
-- 应该显示"已收藏"状态，不能重复收藏

-- 3. API接口测试（使用curl或Postman）：

-- 添加收藏
-- POST http://localhost:28089/favorites
-- Header: Content-Type: application/json
-- Body: 10001 (商品ID)

-- 获取收藏列表  
-- GET http://localhost:28089/favorites?pageNumber=1&pageSize=10

-- 检查是否收藏
-- GET http://localhost:28089/favorites/check?goodsId=10001

-- 删除收藏
-- DELETE http://localhost:28089/favorites?goodsId=10001

-- 4. 预期结果：
-- - 用户可以正常添加/删除收藏
-- - 收藏列表正确显示
-- - 重复收藏会被阻止
-- - 未登录用户会被重定向到登录页
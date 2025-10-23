# newbee-mall API 接口文档

## 文档说明

本文档描述了 newbee-mall 商城系统的主要 API 接口，包括前台商城接口和后台管理接口。

**基础信息**
- 基础URL: http://localhost:28089
- 编码格式: UTF-8
- 响应格式: JSON / HTML (Thymeleaf 模板)
- Session 管理: 基于 Cookie 的 Session 机制

---

## 目录

- [前台商城接口](#前台商城接口)
  - [首页相关](#首页相关)
  - [商品相关](#商品相关)
  - [购物车相关](#购物车相关)
  - [订单相关](#订单相关)
  - [用户相关](#用户相关)
- [后台管理接口](#后台管理接口)
  - [管理员登录](#管理员登录)
  - [轮播图管理](#轮播图管理)
  - [商品管理](#商品管理)
  - [分类管理](#分类管理)
  - [订单管理](#订单管理)
  - [会员管理](#会员管理)
- [公共接口](#公共接口)

---

## 前台商城接口

### 首页相关

#### 1. 获取商城首页

**接口地址**: `GET /` 或 `GET /index` 或 `GET /index.html`

**接口描述**: 获取商城首页数据，包括轮播图、分类、热销商品、新品、推荐商品

**请求参数**: 无

**响应数据**:
```html
返回 Thymeleaf 模板渲染的 HTML 页面
```

**页面数据**:
- `categories`: 商品分类列表
- `carousels`: 轮播图列表（最多5个）
- `hotGoodses`: 热销商品列表（最多5个）
- `newGoodses`: 新品列表（最多5个）
- `recommendGoodses`: 推荐商品列表（最多10个）

---

### 商品相关

#### 2. 商品搜索

**接口地址**: `GET /search`

**接口描述**: 搜索商品列表

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| keyword | String | 否 | 搜索关键词 |
| goodsCategoryId | Long | 否 | 商品分类ID |
| orderBy | String | 否 | 排序方式（new:新品, price:价格） |
| page | Integer | 否 | 页码，默认1 |

**响应数据**:
```html
返回商品列表页面
```

#### 3. 商品详情

**接口地址**: `GET /goods/detail/{goodsId}`

**接口描述**: 获取商品详细信息

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| goodsId | Long | 是 | 商品ID（路径参数） |

**响应数据**:
```html
返回商品详情页面
```

---

### 购物车相关

#### 4. 查看购物车

**接口地址**: `GET /shop-cart`

**接口描述**: 查看当前用户的购物车

**请求参数**: 无（需要登录）

**响应数据**:
```html
返回购物车页面
```

#### 5. 添加商品到购物车

**接口地址**: `POST /shop-cart`

**接口描述**: 将商品添加到购物车

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| goodsId | Long | 是 | 商品ID |
| goodsCount | Integer | 是 | 商品数量 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": null
}
```

#### 6. 更新购物车商品数量

**接口地址**: `PUT /shop-cart`

**接口描述**: 更新购物车中商品的数量

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| cartItemId | Long | 是 | 购物车项ID |
| goodsCount | Integer | 是 | 新的商品数量 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success"
}
```

#### 7. 删除购物车商品

**接口地址**: `DELETE /shop-cart/{cartItemId}`

**接口描述**: 从购物车中删除商品

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| cartItemId | Long | 是 | 购物车项ID（路径参数） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success"
}
```

---

### 订单相关

#### 8. 订单结算页面

**接口地址**: `GET /shop-cart/settle`

**接口描述**: 获取订单结算页面

**请求参数**: 无（需要登录）

**响应数据**:
```html
返回订单结算页面
```

#### 9. 生成订单

**接口地址**: `POST /saveOrder`

**接口描述**: 提交订单

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| addressId | Long | 是 | 收货地址ID |
| cartItemIds | String | 是 | 购物车项ID列表（逗号分隔） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": "订单号"
}
```

#### 10. 我的订单列表

**接口地址**: `GET /orders`

**接口描述**: 查看当前用户的订单列表

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| page | Integer | 否 | 页码，默认1 |
| status | String | 否 | 订单状态 |

**响应数据**:
```html
返回订单列表页面
```

#### 11. 订单详情

**接口地址**: `GET /orders/{orderNo}`

**接口描述**: 查看订单详细信息

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| orderNo | String | 是 | 订单号（路径参数） |

**响应数据**:
```html
返回订单详情页面
```

#### 12. 取消订单

**接口地址**: `PUT /orders/{orderNo}/cancel`

**接口描述**: 取消订单

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| orderNo | String | 是 | 订单号（路径参数） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success"
}
```

#### 13. 确认收货

**接口地址**: `PUT /orders/{orderNo}/finish`

**接口描述**: 确认收货

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| orderNo | String | 是 | 订单号（路径参数） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success"
}
```

---

### 用户相关

#### 14. 用户注册

**接口地址**: `POST /register`

**接口描述**: 用户注册

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| loginName | String | 是 | 登录名 |
| password | String | 是 | 密码 |
| verifyCode | String | 是 | 验证码 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "注册成功"
}
```

#### 15. 用户登录

**接口地址**: `POST /login`

**接口描述**: 用户登录

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| loginName | String | 是 | 登录名 |
| password | String | 是 | 密码 |
| verifyCode | String | 是 | 验证码 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "登录成功"
}
```

#### 16. 用户登出

**接口地址**: `POST /logout`

**接口描述**: 用户退出登录

**请求参数**: 无

**响应数据**:
```html
跳转到登录页面
```

#### 17. 个人信息

**接口地址**: `GET /personal`

**接口描述**: 查看个人信息

**请求参数**: 无（需要登录）

**响应数据**:
```html
返回个人中心页面
```

#### 18. 修改个人信息

**接口地址**: `POST /personal/updateInfo`

**接口描述**: 修改个人信息

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| nickName | String | 是 | 昵称 |
| introduceSign | String | 否 | 个性签名 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "修改成功"
}
```

---

## 后台管理接口

### 管理员登录

#### 19. 管理员登录页面

**接口地址**: `GET /admin/login`

**接口描述**: 获取管理员登录页面

**请求参数**: 无

**响应数据**:
```html
返回管理员登录页面
```

#### 20. 管理员登录

**接口地址**: `POST /admin/login`

**接口描述**: 管理员登录验证

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| userName | String | 是 | 用户名 |
| password | String | 是 | 密码 |
| verifyCode | String | 是 | 验证码 |

**响应数据**:
```html
登录成功：跳转到管理后台首页
登录失败：返回登录页面并显示错误信息
```

#### 21. 管理员登出

**接口地址**: `GET /admin/logout`

**接口描述**: 管理员退出登录

**请求参数**: 无

**响应数据**:
```html
跳转到登录页面
```

#### 22. 管理员个人资料

**接口地址**: `GET /admin/profile`

**接口描述**: 查看管理员个人资料

**请求参数**: 无（需要登录）

**响应数据**:
```html
返回个人资料页面
```

#### 23. 修改管理员密码

**接口地址**: `POST /admin/profile/password`

**接口描述**: 修改管理员密码

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| originalPassword | String | 是 | 原密码 |
| newPassword | String | 是 | 新密码 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "修改成功"
}
```

---

### 轮播图管理

#### 24. 轮播图列表

**接口地址**: `GET /admin/carousels`

**接口描述**: 获取轮播图列表（分页）

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| page | Integer | 否 | 页码，默认1 |
| limit | Integer | 否 | 每页数量，默认10 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {
    "totalCount": 100,
    "currPage": 1,
    "list": [...]
  }
}
```

#### 25. 添加轮播图

**接口地址**: `POST /admin/carousels/save`

**接口描述**: 添加新的轮播图

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| carouselUrl | String | 是 | 图片URL |
| redirectUrl | String | 是 | 跳转URL |
| carouselRank | Integer | 是 | 排序值 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "保存成功"
}
```

#### 26. 修改轮播图

**接口地址**: `POST /admin/carousels/update`

**接口描述**: 修改轮播图信息

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| carouselId | Integer | 是 | 轮播图ID |
| carouselUrl | String | 是 | 图片URL |
| redirectUrl | String | 是 | 跳转URL |
| carouselRank | Integer | 是 | 排序值 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "修改成功"
}
```

#### 27. 删除轮播图

**接口地址**: `POST /admin/carousels/delete`

**接口描述**: 删除轮播图

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| ids | Integer[] | 是 | 轮播图ID数组 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "删除成功"
}
```

---

### 商品管理

#### 28. 商品列表

**接口地址**: `GET /admin/goods/list`

**接口描述**: 获取商品列表（分页）

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| page | Integer | 否 | 页码，默认1 |
| limit | Integer | 否 | 每页数量，默认10 |
| goodsName | String | 否 | 商品名称（模糊查询） |
| goodsSellStatus | Integer | 否 | 上架状态 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {
    "totalCount": 100,
    "currPage": 1,
    "list": [...]
  }
}
```

#### 29. 添加商品

**接口地址**: `POST /admin/goods/save`

**接口描述**: 添加新商品

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| goodsName | String | 是 | 商品名称 |
| goodsIntro | String | 是 | 商品简介 |
| goodsCategoryId | Long | 是 | 分类ID |
| goodsCoverImg | String | 是 | 封面图 |
| originalPrice | Integer | 是 | 原价 |
| sellingPrice | Integer | 是 | 售价 |
| stockNum | Integer | 是 | 库存 |
| tag | String | 否 | 标签 |
| goodsSellStatus | Byte | 是 | 上架状态 |
| goodsDetailContent | String | 是 | 商品详情（富文本） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "保存成功"
}
```

#### 30. 修改商品

**接口地址**: `POST /admin/goods/update`

**接口描述**: 修改商品信息

**请求参数**: 同添加商品，需额外传递 `goodsId`

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "修改成功"
}
```

#### 31. 上架/下架商品

**接口地址**: `POST /admin/goods/status/{sellStatus}`

**接口描述**: 批量修改商品上架状态

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| sellStatus | Integer | 是 | 状态值（路径参数，0下架，1上架） |
| ids | Long[] | 是 | 商品ID数组 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "修改成功"
}
```

---

### 分类管理

#### 32. 分类列表

**接口地址**: `GET /admin/categories/list`

**接口描述**: 获取分类列表（分页）

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| page | Integer | 否 | 页码，默认1 |
| limit | Integer | 否 | 每页数量，默认10 |
| categoryLevel | Integer | 否 | 分类级别（1/2/3） |
| parentId | Long | 否 | 父分类ID |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {
    "totalCount": 100,
    "currPage": 1,
    "list": [...]
  }
}
```

#### 33. 添加分类

**接口地址**: `POST /admin/categories/save`

**接口描述**: 添加商品分类

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| categoryLevel | Byte | 是 | 分类级别 |
| categoryName | String | 是 | 分类名称 |
| parentId | Long | 是 | 父分类ID |
| categoryRank | Integer | 是 | 排序值 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "保存成功"
}
```

#### 34. 获取分类详情

**接口地址**: `GET /admin/categories/info/{id}`

**接口描述**: 获取分类详细信息

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| id | Long | 是 | 分类ID（路径参数） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {...}
}
```

---

### 订单管理

#### 35. 订单列表

**接口地址**: `GET /admin/orders/list`

**接口描述**: 获取订单列表（分页）

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| page | Integer | 否 | 页码，默认1 |
| limit | Integer | 否 | 每页数量，默认10 |
| orderNo | String | 否 | 订单号 |
| orderStatus | Integer | 否 | 订单状态 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {
    "totalCount": 100,
    "currPage": 1,
    "list": [...]
  }
}
```

#### 36. 订单详情

**接口地址**: `GET /admin/orders/detail/{orderId}`

**接口描述**: 查看订单详细信息

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| orderId | Long | 是 | 订单ID（路径参数） |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {...}
}
```

#### 37. 配货

**接口地址**: `POST /admin/orders/checkDone`

**接口描述**: 订单配货

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| ids | Long[] | 是 | 订单ID数组 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "配货成功"
}
```

#### 38. 出库

**接口地址**: `POST /admin/orders/checkOut`

**接口描述**: 订单出库

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| ids | Long[] | 是 | 订单ID数组 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "出库成功"
}
```

#### 39. 关闭订单

**接口地址**: `POST /admin/orders/close`

**接口描述**: 关闭订单

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| ids | Long[] | 是 | 订单ID数组 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "关闭成功"
}
```

---

### 会员管理

#### 40. 会员列表

**接口地址**: `GET /admin/users/list`

**接口描述**: 获取会员列表（分页）

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| page | Integer | 否 | 页码，默认1 |
| limit | Integer | 否 | 每页数量，默认10 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "success",
  "data": {
    "totalCount": 100,
    "currPage": 1,
    "list": [...]
  }
}
```

#### 41. 禁用会员

**接口地址**: `POST /admin/users/lock/{lockStatus}`

**接口描述**: 批量禁用/解禁会员

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| lockStatus | Integer | 是 | 状态值（路径参数，0正常，1锁定） |
| ids | Long[] | 是 | 用户ID数组 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "修改成功"
}
```

---

## 公共接口

#### 42. 获取验证码

**接口地址**: `GET /common/kaptcha`

**接口描述**: 生成验证码图片

**请求参数**: 无

**响应数据**:
```
图片流（image/jpeg）
```

#### 43. 文件上传

**接口地址**: `POST /admin/upload/file`

**接口描述**: 上传文件（图片）

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| file | MultipartFile | 是 | 文件对象 |

**响应数据**:
```json
{
  "resultCode": 200,
  "message": "上传成功",
  "data": "文件访问路径"
}
```

---

## 状态码说明

### 通用状态码

| 状态码 | 说明 |
|--------|------|
| 200 | 成功 |
| 500 | 服务器内部错误 |

### 业务状态码

| 状态码 | 说明 |
|--------|------|
| SUCCESS | 成功 |
| ERROR | 失败 |
| DB_ERROR | 数据库异常 |
| PARAMS_ERROR | 参数异常 |
| NOT_LOGIN_ERROR | 未登录 |
| DATA_NOT_EXIST | 数据不存在 |
| GOODS_SAVE_ERROR | 商品保存失败 |
| GOODS_UPDATE_ERROR | 商品更新失败 |
| ORDER_NOT_EXIST_ERROR | 订单不存在 |
| NULL_ADDRESS_ERROR | 地址为空 |
| LOGIN_ERROR | 登录失败 |
| NOT_SALE_GOODS | 商品已下架 |

---

## 数据模型

### 商品对象 (Goods)

```json
{
  "goodsId": 1,
  "goodsName": "商品名称",
  "goodsIntro": "商品简介",
  "goodsCategoryId": 100,
  "goodsCoverImg": "/upload/xxx.jpg",
  "goodsDetailContent": "商品详情HTML",
  "originalPrice": 100,
  "sellingPrice": 80,
  "stockNum": 999,
  "tag": "热销",
  "goodsSellStatus": 0,
  "createTime": "2023-01-01 12:00:00",
  "updateTime": "2023-01-01 12:00:00"
}
```

### 订单对象 (Order)

```json
{
  "orderId": 1,
  "orderNo": "202301010001",
  "userId": 1,
  "totalPrice": 100,
  "payStatus": 1,
  "payType": 1,
  "payTime": "2023-01-01 12:00:00",
  "orderStatus": 1,
  "extraInfo": "",
  "isDeleted": 0,
  "createTime": "2023-01-01 12:00:00",
  "updateTime": "2023-01-01 12:00:00"
}
```

### 用户对象 (User)

```json
{
  "userId": 1,
  "nickName": "用户昵称",
  "loginName": "登录名",
  "passwordMd5": "MD5加密密码",
  "introduceSign": "个性签名",
  "isDeleted": 0,
  "lockedFlag": 0,
  "createTime": "2023-01-01 12:00:00"
}
```

---

## 注意事项

1. **认证机制**: 所有需要登录的接口都需要携带有效的 Session Cookie
2. **参数校验**: 所有接口都会进行参数校验，参数不合法会返回相应错误信息
3. **跨域访问**: 如果前后端分离部署，需要配置 CORS
4. **文件上传**: 支持的文件格式为 jpg、png、jpeg、gif，大小限制请查看配置
5. **分页参数**: 默认每页10条，最大不超过100条

---

**文档版本**: v1.0.0
**最后更新**: 2025-10-23
**维护者**: newbee-mall 开发团队

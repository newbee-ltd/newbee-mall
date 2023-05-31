![newbee-logo](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/newbee-logo.png?x-oss-process=image/resize,h_240,w_480)

![Build Status](https://img.shields.io/badge/build-passing-green.svg)
![Version 1.0.0](https://img.shields.io/badge/version-1.0.0-yellow.svg)
[![License](https://img.shields.io/badge/license-GPL3.0-blue.svg)](https://github.com/newbee-ltd/newbee-mall/blob/master/LICENSE)

newbee-mall 项目是一套电商系统，包括 newbee-mall 商城系统及 newbee-mall-admin 商城后台管理系统，基于 Spring Boot 及相关技术栈开发。 前台商城系统包含首页门户、商品分类、新品上线、首页轮播、商品推荐、商品搜索、商品展示、购物车、订单结算、订单流程、个人订单管理、会员中心、帮助中心等模块。 后台管理系统包含数据面板、轮播图管理、商品管理、订单管理、会员管理、分类管理、设置等模块。

当前分支的 Spring Boot 版本为 2.7.5，想要学习和使用其它版本可以直接点击下方的分支名称跳转至对应的仓库分支中。

| 分支名称                                                    | Spring Boot Version |
| ------------------------------------------------------------ | ------------------- |
| [spring-boot-2.3.7](https://github.com/newbee-ltd/newbee-mall/tree/spring-boot-2.3.7) | 2.3.7-RELEASE       |
| [spring-boot-2.6.x](https://github.com/newbee-ltd/newbee-mall/tree/spring-boot-2.6.x) | 2.6.3               |
| [main](https://github.com/newbee-ltd/newbee-mall)            | 2.7.5               |
| [spring-boot-3.x](https://github.com/newbee-ltd/newbee-mall/tree/spring-boot-3.x) | 3.1.0               |

新蜂商城线上预览地址：[http://mall.newbee.ltd](http://mall.newbee.ltd?from=github)，账号可自行注册。

**坚持不易，如果觉得项目还不错的话可以给项目一个 Star 吧，也是对我自 2019 年开始一直更新这个项目的一种鼓励啦，谢谢各位的支持。**

![newbee-mall-info](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/store/newbee-mall-star.png)

- newbee-mall 对新手开发者十分友好，无需复杂的操作步骤，**仅需 2 秒就可以启动这个完整的商城项目；**
- newbee-mall **也是一个企业级别的 Spring Boot 大型项目，对于各个阶段的 Java 开发者都是极佳的选择；**
- 你可以把它作为 Spring Boot 技术栈的综合实践项目，**newbee-mall 足够符合要求，且代码开源、功能完备、流程完整、页面交互美观；**
- 技术栈新颖且知识点丰富，学习后可以提升大家对于知识的理解和掌握，**可以进一步提升你的市场竞争力；**
- 对于部分求职中的 Java 开发者，**你也可以将该项目放入求职简历中以丰富你的工作履历；** 
- **newbee-mall 还有一些不完善的地方，鄙人才疏学浅，望见谅；** 
- **有任何问题都可以反馈给我，我会尽量完善该项目。** 

![](https://raw.githubusercontent.com/newbee-ltd/newbee-mall-vue-app/master/static-files/newbee-mall.png)

## newbee-mall （新蜂商城）系列项目概览

![newbee-mall-course-2022](https://github.com/newbee-ltd/newbee-mall-cloud/raw/main/static-files/newbee-mall-course-2022.png)

| 项目名称             | 仓库地址                                                     | 备注                                                         |
| :------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| newbee-mall          | [newbee-mall in GitHub](https://github.com/newbee-ltd/newbee-mall)<br>[newbee-mall in Gitee](https://gitee.com/newbee-ltd/newbee-mall) | 初始版本、Spring Boot、Thymeleaf、MyBatis、MySQL             |
| newbee-mall-plus     | [newbee-mall-plus in GitHub](https://github.com/newbee-ltd/newbee-mall-plus)<br/>[newbee-mall-plus in Gitee](https://gitee.com/newbee-ltd/newbee-mall-plus) | 升级版本、优惠券、秒杀、支付、Spring Boot、Thymeleaf、MyBatis、MySQL、Redis |
| newbee-mall-cloud    | [newbee-mall-cloud in GitHub](https://github.com/newbee-ltd/newbee-mall-cloud)<br/>[newbee-mall-cloud in Gitee](https://gitee.com/newbee-ltd/newbee-mall-cloud) | 微服务版本、分布式事务、Spring Cloud Alibaba、Nacos、Sentinel、OpenFeign、Seata |
| newbee-mall-api      | [newbee-mall-api in GitHub](https://github.com/newbee-ltd/newbee-mall-api)<br/>[newbee-mall-api in Gitee](https://gitee.com/newbee-ltd/newbee-mall-api) | 前后端分离、Spring Boot、MyBatis、Swagger、MySQL             |
| newbee-mall-api-go   | [newbee-mall-api-go in GitHub](https://github.com/newbee-ltd/newbee-mall-api-go)<br/>[newbee-mall-api-go in Gitee](https://gitee.com/newbee-ltd/newbee-mall-api-go) | 前后端分离、Go、Gin、MySQL                                   |
| newbee-mall-vue-app  | [newbee-mall-vue-app in GitHub](https://github.com/newbee-ltd/newbee-mall-vue-app)<br/>[newbee-mall-vue-app in Gitee](https://gitee.com/newbee-ltd/newbee-mall-vue-app) | 前后端分离、Vue2、Vant                                    |
| newbee-mall-vue3-app | [newbee-mall-vue3-app in GitHub](https://github.com/newbee-ltd/newbee-mall-vue3-app)<br/>[newbee-mall-vue3-app in Gitee](https://gitee.com/newbee-ltd/newbee-mall-vue3-app) | 前后端分离、Vue3、Vue-Router4、Vuex4、Vant3      |
| vue3-admin           | [vue3-admin in GitHub](https://github.com/newbee-ltd/vue3-admin)<br/>[vue3-admin in Gitee](https://gitee.com/newbee-ltd/vue3-admin) | 前后端分离、Vue3、Element-Plus、Vue-Router4、Vite      |

> 更多 Spring Boot 实战项目可以关注十三的另一个代码仓库 [spring-boot-projects](https://github.com/ZHENFENG13/spring-boot-projects)，该仓库中主要是 Spring Boot 的入门学习教程以及一些常用的 Spring Boot 实战项目教程，包括 Spring Boot 使用的各种示例代码，同时也包括一些实战项目的项目源码和效果展示，实战项目包括基本的 web 开发以及目前大家普遍使用的前后端分离实践项目等，后续会根据大家的反馈继续增加一些实战项目源码，摆脱各种 hello world 入门案例的束缚，真正的掌握 Spring Boot 开发。

关注公众号：**程序员十三**，回复"勾搭"进群交流。

![wx-gzh](https://newbee-mall.oss-cn-beijing.aliyuncs.com/wx-gzh/%E7%A8%8B%E5%BA%8F%E5%91%98%E5%8D%81%E4%B8%89-%E5%85%AC%E4%BC%97%E5%8F%B7.png)

## 项目演示

- [视频1：商城项目总览](https://edu.csdn.net/course/play/26258/326466)
- [视频2：商城系统介绍](https://edu.csdn.net/course/play/26258/326467)
- [视频3：商城后台管理系统介绍](https://edu.csdn.net/course/play/26258/328801)

## 开发及部署文档

- [**Spring Boot 大型线上商城项目实战教程**](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [项目须知和课程约定](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [2021年12月小册全新优化升级](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [技术选型之 Spring Boot](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [前期准备工作及基础环境搭建](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 项目初体验--项目搭建及启动](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 之 Web 开发讲解](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Thymeleaf 模板引擎技术介绍及整合](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Thymeleaf 语法详解及编码实践](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 实践之数据库操作](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 实践之整合 Mybatis 操作数据库](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [项目初体验：启动和使用新蜂商城](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城功能模块和流程设计详解](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [前端页面设计及技术选型](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [页面布局制作及跳转逻辑实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 实现验证码功能](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城后台管理系统登录功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [登陆拦截器设置并完善身份验证](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [通用分页功能设计与开发实践](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [jqGrid 插件整合制作分页效果](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 实践之文件上传处理-1](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot 实践之文件上传处理-2](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城轮播图管理模块开发](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城分类管理模块开发-1](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城分类管理模块开发-2](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城商品类目三级联动功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [富文本编辑器 wangEditor 介绍及整合详解](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城商品编辑页面制作](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城商品添加功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城商品管理模块功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城首页制作-1](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城首页制作-2](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城首页模块配置及功能完善](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城会员的注册/登录功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城搜索商品功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城购物车功能实现](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城订单确认页和订单生成功能实践](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城个人订单列表和订单详情页制作](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城订单流程功能完善](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [课程总结及展望](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [Spring Boot中的事务处理](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [新蜂商城错误页面制作](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)
- [常见问题汇总讲解](https://juejin.cn/book/6844733814074245133?suid=1996368849416216&source=android)

## 联系作者

> 大家有任何问题或者建议都可以在 [issues](https://github.com/newbee-ltd/newbee-mall/issues) 中反馈给我，我会慢慢完善这个项目。

- 我的邮箱：2449207463@qq.com
- QQ技术交流群：791509631 784785001

> newbee-mall 在 GitHub 和国内的码云都创建了代码仓库，如果有人访问 GitHub 比较慢的话，建议在 Gitee 上查看该项目，两个仓库会保持同步更新。

- [newbee-mall in GitHub](https://github.com/newbee-ltd/newbee-mall)
- [newbee-mall in Gitee](https://gitee.com/newbee-ltd/newbee-mall)
![newbee-mall-info](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/store/newbee-mall-info-3.png)

## 软件著作权

>本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！

![](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/store/newbee-mall-copyright.png)

## 页面展示

以下为商城项目的部分页面，由于篇幅所限，无法一一列举，重要节点及重要功能的页面都已整理在下方。

### 商城页面预览

- 商城首页 1

	![index](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/index-01-2023.gif)

- 商城首页 2

	![index](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/index-02-2023.png)

- 商品搜索

	![search](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/search-2023.png)

- 购物车

	![cart](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/cart-2023.png)
	
- 订单结算

	![settle](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/settle-2023.png)
			
- 订单列表

	![orders](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/orders-2023.png)	
	
- 支付页面

	![settle](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/wx-pay.png)


### 后台管理页面

- 登录页

	![login](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/manage-login.png)

- 轮播图管理

	![carousel](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/manage-carousel-2023.png)
	
- 新品上线

    ![config](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/manage-index-config-2023.png)

- 分类管理

	![category](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/manage-category.png)

- 商品管理

	![goods](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/manage-goods-2023.png)

- 商品编辑

	![edit](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/goods-edit-2023.png)

- 订单管理

	![order](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/product/manage-order-2023.png)

![newbee-mall-info](https://newbee-mall.oss-cn-beijing.aliyuncs.com/poster/store/newbee-mall-info-3.png)

## 感谢

- [spring-projects](https://github.com/spring-projects/spring-boot)
- [thymeleaf](https://github.com/thymeleaf/thymeleaf)
- [mybatis](https://github.com/mybatis/mybatis-3)
- [ColorlibHQ](https://github.com/ColorlibHQ/AdminLTE)
- [tonytomov](https://github.com/tonytomov/jqGrid)
- [sweetalert2](https://github.com/sweetalert2/sweetalert2)
- [skytotwo](https://github.com/skytotwo/Alipay-WeChat-HTML)
- [hutool](https://github.com/dromara/hutool)
- [wangeditor-team](https://github.com/wangeditor-team/wangEditor)
- [VincentGarreau](https://github.com/VincentGarreau/particles.js)
- [Vue](https://github.com/vuejs/vue)
- [Vant](https://github.com/youzan/vant)

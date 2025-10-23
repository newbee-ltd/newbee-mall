# newbee-mall 开发指南

## 目录

- [项目介绍](#项目介绍)
- [技术栈](#技术栈)
- [项目结构](#项目结构)
- [开发环境搭建](#开发环境搭建)
- [快速开始](#快速开始)
- [开发规范](#开发规范)
- [核心功能实现](#核心功能实现)
- [常用开发任务](#常用开发任务)
- [测试指南](#测试指南)
- [部署指南](#部署指南)

---

## 项目介绍

newbee-mall 是一个基于 Spring Boot 的电商系统，包含前台商城和后台管理两个部分。

**项目特点**:
- 代码结构清晰，易于理解和学习
- 功能完善，包含电商系统的核心功能
- 技术栈主流，适合学习和实践
- 开箱即用，2秒即可启动

**主要功能模块**:

**前台商城**:
- 首页展示（轮播图、分类、商品推荐）
- 商品搜索与展示
- 购物车管理
- 订单流程（下单、支付、查看）
- 用户中心（个人信息、订单管理）

**后台管理**:
- 管理员登录与权限控制
- 轮播图管理
- 商品分类管理
- 商品管理
- 订单管理
- 会员管理

---

## 技术栈

### 后端技术

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.6.3 | 核心框架 |
| Spring MVC | - | MVC 框架 |
| MyBatis | 2.2.2 | ORM 框架 |
| Thymeleaf | - | 模板引擎 |
| MySQL | 5.7+ | 数据库 |
| Hutool | 5.7.22 | Java 工具库 |
| Maven | 3.x | 项目构建工具 |

### 前端技术

| 技术 | 说明 |
|------|------|
| Thymeleaf | 服务端模板引擎 |
| jQuery | JavaScript 库 |
| Bootstrap | UI 框架 |
| AdminLTE | 后台管理模板 |
| jqGrid | 数据表格插件 |
| wangEditor | 富文本编辑器 |
| SweetAlert | 弹窗组件 |

---

## 项目结构

```
newbee-mall/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ltd/newbee/mall/
│   │   │       ├── common/              # 公共常量和枚举
│   │   │       │   ├── Constants.java
│   │   │       │   ├── ServiceResultEnum.java
│   │   │       │   └── ...
│   │   │       ├── config/              # 配置类
│   │   │       │   └── WebMvcConfig.java
│   │   │       ├── controller/          # 控制器层
│   │   │       │   ├── admin/           # 后台管理控制器
│   │   │       │   ├── mall/            # 前台商城控制器
│   │   │       │   ├── common/          # 公共控制器
│   │   │       │   └── vo/              # 视图对象
│   │   │       ├── dao/                 # 数据访问层
│   │   │       │   ├── AdminUserMapper.java
│   │   │       │   ├── NewBeeMallGoodsMapper.java
│   │   │       │   └── ...
│   │   │       ├── entity/              # 实体类
│   │   │       │   ├── AdminUser.java
│   │   │       │   ├── NewBeeMallGoods.java
│   │   │       │   └── ...
│   │   │       ├── interceptor/         # 拦截器
│   │   │       │   ├── AdminLoginInterceptor.java
│   │   │       │   └── NewBeeMallLoginInterceptor.java
│   │   │       ├── service/             # 服务层接口
│   │   │       │   ├── AdminUserService.java
│   │   │       │   └── ...
│   │   │       │   └── impl/            # 服务层实现
│   │   │       │       ├── AdminUserServiceImpl.java
│   │   │       │       └── ...
│   │   │       ├── util/                # 工具类
│   │   │       │   ├── MD5Util.java
│   │   │       │   ├── Result.java
│   │   │       │   └── ...
│   │   │       └── NewBeeMallApplication.java  # 启动类
│   │   └── resources/
│   │       ├── mapper/                  # MyBatis XML 映射文件
│   │       │   ├── AdminUserMapper.xml
│   │       │   └── ...
│   │       ├── static/                  # 静态资源
│   │       │   ├── admin/               # 后台静态资源
│   │       │   └── mall/                # 前台静态资源
│   │       ├── templates/               # Thymeleaf 模板
│   │       │   ├── admin/               # 后台页面
│   │       │   └── mall/                # 前台页面
│   │       └── application.properties   # 配置文件
│   └── test/                            # 测试代码
├── docs/                                # 项目文档
├── pom.xml                              # Maven 配置
└── README.md                            # 项目说明
```

---

## 开发环境搭建

### 1. 安装必要软件

#### 1.1 安装 JDK

下载并安装 JDK 1.8 或以上版本，配置环境变量。

验证安装:
```bash
java -version
```

#### 1.2 安装 Maven

下载并安装 Maven 3.x，配置环境变量。

验证安装:
```bash
mvn -version
```

推荐配置阿里云镜像（修改 `settings.xml`）:
```xml
<mirror>
  <id>aliyun</id>
  <mirrorOf>central</mirrorOf>
  <name>Aliyun Maven</name>
  <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

#### 1.3 安装 MySQL

下载并安装 MySQL 5.7 或以上版本。

创建数据库:
```sql
CREATE DATABASE newbee_mall_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

#### 1.4 安装 IDE

推荐使用 IntelliJ IDEA 或 Eclipse。

### 2. 克隆项目

```bash
git clone https://github.com/newbee-ltd/newbee-mall.git
cd newbee-mall
```

### 3. 导入数据库

执行项目中的 SQL 脚本（通常在 `sql` 或 `database` 目录）:
```bash
mysql -u root -p newbee_mall_db < newbee_mall_schema.sql
mysql -u root -p newbee_mall_db < newbee_mall_data.sql
```

### 4. 配置项目

修改 `src/main/resources/application.properties`:
```properties
# 数据库配置
spring.datasource.url=jdbc:mysql://localhost:3306/newbee_mall_db?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8&autoReconnect=true&useSSL=false&allowMultiQueries=true
spring.datasource.username=root
spring.datasource.password=你的密码

# 服务器端口
server.port=28089
```

---

## 快速开始

### 方式一: IDEA 启动

1. 用 IDEA 打开项目
2. 等待 Maven 依赖下载完成
3. 找到 `NewBeeMallApplication.java`
4. 右键选择 `Run 'NewBeeMallApplication'`

### 方式二: Maven 启动

```bash
mvn clean install
mvn spring-boot:run
```

### 方式三: 命令行启动

```bash
mvn clean package
cd target
java -jar newbee-mall-1.0.0-SNAPSHOT.jar
```

### 访问项目

- 前台商城: http://localhost:28089
- 后台管理: http://localhost:28089/admin/login

---

## 开发规范

### 1. 代码规范

#### 1.1 命名规范

- **类名**: 使用大驼峰命名法（PascalCase）
  ```java
  public class NewBeeMallGoods { }
  ```

- **方法名**: 使用小驼峰命名法（camelCase）
  ```java
  public void saveGoods() { }
  ```

- **常量**: 使用全大写，单词间用下划线分隔
  ```java
  public static final int MAX_GOODS_COUNT = 100;
  ```

- **包名**: 全小写，使用点分隔
  ```java
  package ltd.newbee.mall.service;
  ```

#### 1.2 注释规范

- 类和接口必须添加注释
- 公共方法必须添加注释
- 复杂逻辑必须添加行内注释

```java
/**
 * 商品服务接口
 *
 * @author 13
 */
public interface NewBeeMallGoodsService {
    /**
     * 保存商品
     *
     * @param goods 商品对象
     * @return 保存结果
     */
    Boolean saveGoods(NewBeeMallGoods goods);
}
```

#### 1.3 代码格式

- 使用4个空格缩进（不使用 Tab）
- 左大括号不换行
- if/for/while 等语句必须使用大括号
- 一行代码不超过120个字符

### 2. 分层规范

#### 2.1 Controller 层

- 只负责请求接收和响应
- 不包含业务逻辑
- 调用 Service 层完成业务处理
- 进行参数校验

```java
@Controller
public class GoodsController {

    @Resource
    private NewBeeMallGoodsService goodsService;

    @GetMapping("/goods/detail/{goodsId}")
    public String goodsDetail(@PathVariable Long goodsId, HttpServletRequest request) {
        // 参数校验
        if (goodsId < 1) {
            return "error/error_5xx";
        }

        // 调用 Service
        NewBeeMallGoodsDetailVO goodsDetail = goodsService.getGoodsDetail(goodsId);

        // 设置返回数据
        request.setAttribute("goodsDetail", goodsDetail);
        return "mall/detail";
    }
}
```

#### 2.2 Service 层

- 包含业务逻辑
- 事务控制在此层
- 调用 DAO 层操作数据库

```java
@Service
public class NewBeeMallGoodsServiceImpl implements NewBeeMallGoodsService {

    @Resource
    private NewBeeMallGoodsMapper goodsMapper;

    @Override
    @Transactional
    public Boolean saveGoods(NewBeeMallGoods goods) {
        // 业务逻辑处理
        if (goods == null) {
            return false;
        }

        // 调用 DAO
        return goodsMapper.insertSelective(goods) > 0;
    }
}
```

#### 2.3 DAO 层

- 只负责数据库操作
- 不包含业务逻辑
- 使用 MyBatis 接口和 XML 映射

```java
public interface NewBeeMallGoodsMapper {
    int insertSelective(NewBeeMallGoods record);

    NewBeeMallGoods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(NewBeeMallGoods record);
}
```

### 3. 异常处理

- 使用统一的异常处理机制
- 自定义业务异常

```java
public class NewBeeMallException extends RuntimeException {
    public NewBeeMallException(String message) {
        super(message);
    }

    public static void fail(String message) {
        throw new NewBeeMallException(message);
    }
}
```

### 4. 返回结果规范

- 使用统一的返回对象 `Result`
- 使用枚举定义返回码和消息

```java
Result result = Result.success();
Result result = Result.error("操作失败");
```

---

## 核心功能实现

### 1. 用户登录功能

#### 1.1 前台用户登录

**流程**:
1. 用户输入用户名、密码、验证码
2. Controller 接收参数并校验
3. Service 验证用户名和密码（MD5）
4. 登录成功后将用户信息存入 Session
5. 返回登录结果

**代码示例**:

```java
@PostMapping("/login")
@ResponseBody
public Result login(@RequestParam("loginName") String loginName,
                    @RequestParam("password") String password,
                    HttpSession session) {
    // 参数校验
    if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
        return Result.error("参数不能为空");
    }

    // 调用 Service 验证
    String loginResult = newBeeMallUserService.login(loginName, password, session);

    if (ServiceResultEnum.SUCCESS.getResult().equals(loginResult)) {
        return Result.success();
    }
    return Result.error(loginResult);
}
```

#### 1.2 登录拦截器

**作用**: 拦截需要登录才能访问的请求

```java
@Component
public class NewBeeMallLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("mallUser");

        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
```

**配置拦截器**:

```java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private NewBeeMallLoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/personal/**")
                .addPathPatterns("/shop-cart/**")
                .addPathPatterns("/orders/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register");
    }
}
```

### 2. 购物车功能

#### 2.1 添加商品到购物车

```java
@PostMapping("/shop-cart")
@ResponseBody
public Result saveShoppingCartItem(@RequestBody NewBeeMallShoppingCartItem shoppingCartItem,
                                   HttpSession session) {
    // 获取当前登录用户
    NewBeeMallUserVO user = (NewBeeMallUserVO) session.getAttribute("mallUser");
    shoppingCartItem.setUserId(user.getUserId());

    // 调用 Service 保存
    String saveResult = newBeeMallShoppingCartService.saveNewBeeMallCartItem(shoppingCartItem);

    if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
        return Result.success();
    }
    return Result.error(saveResult);
}
```

#### 2.2 购物车列表查询

```java
@GetMapping("/shop-cart")
public String cartListPage(HttpServletRequest request, HttpSession session) {
    NewBeeMallUserVO user = (NewBeeMallUserVO) session.getAttribute("mallUser");

    // 查询购物车列表
    List<NewBeeMallShoppingCartItemVO> myShoppingCartItems =
        newBeeMallShoppingCartService.getMyShoppingCartItems(user.getUserId());

    request.setAttribute("cartItems", myShoppingCartItems);
    return "mall/cart";
}
```

### 3. 订单功能

#### 3.1 生成订单

```java
@PostMapping("/saveOrder")
@ResponseBody
@Transactional
public Result saveOrder(@RequestParam Long addressId,
                        @RequestParam String cartItemIds,
                        HttpSession session) {
    // 获取当前用户
    NewBeeMallUserVO user = (NewBeeMallUserVO) session.getAttribute("mallUser");

    // 购物车项 ID 转换
    List<Long> itemIdList = Arrays.stream(cartItemIds.split(","))
                                  .map(Long::parseLong)
                                  .collect(Collectors.toList());

    // 生成订单
    String saveOrderResult = newBeeMallOrderService.saveOrder(user.getUserId(), addressId, itemIdList);

    if (ServiceResultEnum.SUCCESS.getResult().equals(saveOrderResult)) {
        return Result.success();
    }
    return Result.error(saveOrderResult);
}
```

#### 3.2 订单状态流转

订单状态定义:
- 0: 待支付
- 1: 已支付
- 2: 配货中
- 3: 出库成功
- 4: 交易成功
- -1: 手动关闭
- -2: 超时关闭
- -3: 商家关闭

### 4. 文件上传功能

```java
@PostMapping("/admin/upload/file")
@ResponseBody
public Result upload(@RequestParam("file") MultipartFile file) {
    // 文件名校验
    String fileName = file.getOriginalFilename();
    String suffixName = fileName.substring(fileName.lastIndexOf("."));

    // 生成新文件名
    String newFileName = UUID.randomUUID().toString() + suffixName;

    // 保存文件
    File destFile = new File(uploadPath + newFileName);
    file.transferTo(destFile);

    // 返回文件访问路径
    return Result.success(newFileName);
}
```

### 5. 分页功能

```java
@GetMapping("/admin/goods/list")
@ResponseBody
public Result list(@RequestParam Map<String, Object> params) {
    PageQueryUtil pageUtil = new PageQueryUtil(params);

    // 查询分页数据
    PageResult pageResult = newBeeMallGoodsService.getNewBeeMallGoodsPage(pageUtil);

    return Result.success(pageResult);
}
```

---

## 常用开发任务

### 1. 添加新的页面

#### 1.1 创建 Controller

```java
@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/index")
    public String index() {
        return "mall/demo/index";
    }
}
```

#### 1.2 创建模板文件

在 `src/main/resources/templates/mall/demo/` 目录下创建 `index.html`

#### 1.3 添加静态资源

在 `src/main/resources/static/mall/` 目录下添加 CSS、JS 文件

### 2. 添加新的 API 接口

#### 2.1 创建实体类

```java
public class Demo {
    private Long id;
    private String name;
    // getter/setter
}
```

#### 2.2 创建 Mapper 接口

```java
public interface DemoMapper {
    List<Demo> selectList();
    int insert(Demo demo);
}
```

#### 2.3 创建 Mapper XML

```xml
<mapper namespace="ltd.newbee.mall.dao.DemoMapper">
    <select id="selectList" resultType="ltd.newbee.mall.entity.Demo">
        SELECT * FROM tb_demo
    </select>
</mapper>
```

#### 2.4 创建 Service

```java
public interface DemoService {
    List<Demo> getList();
}

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapper demoMapper;

    @Override
    public List<Demo> getList() {
        return demoMapper.selectList();
    }
}
```

#### 2.5 创建 Controller

```java
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/list")
    public Result list() {
        return Result.success(demoService.getList());
    }
}
```

### 3. 添加定时任务

```java
@Component
@EnableScheduling
public class ScheduledTask {

    @Scheduled(cron = "0 0 2 * * ?")
    public void task() {
        // 定时任务逻辑
    }
}
```

### 4. 添加拦截器

```java
@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 前置处理
        return true;
    }
}
```

---

## 测试指南

### 1. 单元测试

```java
@SpringBootTest
public class GoodsServiceTest {

    @Resource
    private NewBeeMallGoodsService goodsService;

    @Test
    public void testGetGoodsDetail() {
        NewBeeMallGoodsDetailVO goodsDetail = goodsService.getGoodsDetail(1L);
        assertNotNull(goodsDetail);
    }
}
```

### 2. 接口测试

使用 Postman 或其他工具测试 API 接口。

### 3. 功能测试

手动测试各个功能模块是否正常运行。

---

## 部署指南

### 1. 打包项目

```bash
mvn clean package -DskipTests
```

### 2. 服务器环境准备

- 安装 JDK 1.8+
- 安装 MySQL 5.7+
- 导入数据库

### 3. 上传并运行

```bash
# 上传 jar 包
scp target/newbee-mall-1.0.0-SNAPSHOT.jar user@server:/app/

# SSH 登录服务器
ssh user@server

# 运行项目
nohup java -jar /app/newbee-mall-1.0.0-SNAPSHOT.jar --spring.profiles.active=prod > /app/logs/app.log 2>&1 &
```

### 4. 配置 Nginx 反向代理

```nginx
server {
    listen 80;
    server_name your-domain.com;

    location / {
        proxy_pass http://localhost:28089;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }
}
```

### 5. 配置 HTTPS

使用 Let's Encrypt 获取免费 SSL 证书。

---

## 常见问题

详见 [FAQ 文档](./FAQ.md)

---

## 参考资料

- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)
- [MyBatis 官方文档](https://mybatis.org/mybatis-3/)
- [Thymeleaf 官方文档](https://www.thymeleaf.org/)

---

**文档版本**: v1.0.0
**最后更新**: 2025-10-23
**维护者**: newbee-mall 开发团队

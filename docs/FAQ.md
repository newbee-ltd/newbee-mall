# newbee-mall 常见问题 FAQ

## 目录
- [环境配置相关](#环境配置相关)
- [项目启动相关](#项目启动相关)
- [功能使用相关](#功能使用相关)
- [开发调试相关](#开发调试相关)
- [部署运维相关](#部署运维相关)

---

## 环境配置相关

### Q1: 项目需要什么样的开发环境？
**A:** newbee-mall 项目的基本环境要求如下：
- JDK 1.8 或以上版本
- Maven 3.x
- MySQL 5.7 或以上版本
- IDE：推荐使用 IntelliJ IDEA 或 Eclipse

### Q2: 如何配置数据库连接？
**A:** 数据库配置位于 `src/main/resources/application.properties` 文件中：
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/newbee_mall_db
spring.datasource.username=root
spring.datasource.password=123456
```
请根据实际情况修改数据库地址、用户名和密码。

### Q3: 数据库脚本在哪里？
**A:** 数据库初始化脚本通常位于项目的 `sql` 或 `database` 目录中。首次运行前需要先执行 SQL 脚本创建数据库和表结构。

### Q4: Maven 依赖下载失败怎么办？
**A:** 可以尝试以下方法：
1. 检查网络连接
2. 更换 Maven 镜像源（推荐使用阿里云镜像）
3. 清理本地仓库缓存：`mvn clean`
4. 重新下载依赖：`mvn dependency:resolve`

---

## 项目启动相关

### Q5: 如何启动项目？
**A:** 有以下几种方式：
1. **IDEA 启动**：直接运行 `NewBeeMallApplication` 主类
2. **Maven 启动**：执行 `mvn spring-boot:run`
3. **命令行启动**：先打包 `mvn clean package`，然后运行 `java -jar target/newbee-mall-1.0.0-SNAPSHOT.jar`

### Q6: 项目默认端口是多少？
**A:** 默认端口是 **28089**，可在 `application.properties` 中修改：
```properties
server.port=28089
```

### Q7: 启动后如何访问？
**A:**
- **前台商城**：http://localhost:28089
- **后台管理**：http://localhost:28089/admin/login
- 默认管理员账号需要查看数据库或初始化脚本

### Q8: 启动时报错 "端口被占用" 怎么办？
**A:** 可以：
1. 修改 `application.properties` 中的端口号
2. 或者关闭占用该端口的程序
3. Windows: `netstat -ano | findstr 28089` 查找进程并关闭
4. Linux/Mac: `lsof -i:28089` 查找进程并关闭

### Q9: 启动时报错 "数据库连接失败"？
**A:** 请检查：
1. MySQL 服务是否已启动
2. 数据库名、用户名、密码是否正确
3. 数据库是否已创建并执行了初始化脚本
4. 防火墙是否阻止了数据库连接

---

## 功能使用相关

### Q10: 如何注册用户？
**A:** 在商城首页点击注册按钮，填写用户名、密码等信息即可注册。

### Q11: 管理员默认账号是什么？
**A:** 默认管理员账号信息需要查看数据库初始化脚本中的 `tb_newbee_mall_admin_user` 表。通常为：
- 用户名：admin
- 密码：123456（MD5加密后存储）

### Q12: 如何添加商品？
**A:**
1. 登录后台管理系统
2. 进入"商品管理"模块
3. 点击"添加商品"按钮
4. 填写商品信息（名称、价格、库存、分类等）
5. 上传商品图片
6. 保存商品

### Q13: 购物车数据存储在哪里？
**A:** 购物车数据存储在数据库的 `tb_newbee_mall_shopping_cart_item` 表中，与用户ID关联。

### Q14: 订单状态有哪些？
**A:** 订单状态包括：
- 待支付
- 已支付
- 配货中
- 出库成功
- 交易成功
- 订单关闭
具体状态值定义在 `OrderStatusEnum` 枚举类中。

### Q15: 如何处理订单？
**A:** 在后台管理系统的"订单管理"模块中：
1. 查看订单列表
2. 点击订单详情查看订单信息
3. 根据订单状态进行相应操作（配货、出库、关闭等）

---

## 开发调试相关

### Q16: 如何开启热部署？
**A:** 已配置 Thymeleaf 模板缓存为 false：
```properties
spring.thymeleaf.cache=false
```
对于 Java 代码修改，建议安装 spring-boot-devtools 依赖。

### Q17: 日志文件在哪里？
**A:** 项目使用 Spring Boot 默认的日志配置，日志输出到控制台。如需输出到文件，可在 `application.properties` 中配置：
```properties
logging.file.path=logs
logging.level.ltd.newbee.mall=DEBUG
```

### Q18: 如何调试 MyBatis SQL？
**A:** 在 `application.properties` 中添加：
```properties
logging.level.ltd.newbee.mall.dao=DEBUG
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

### Q19: 前端静态资源在哪里？
**A:** 静态资源位于：
- CSS/JS：`src/main/resources/static/`
- Thymeleaf 模板：`src/main/resources/templates/`

### Q20: 如何自定义错误页面？
**A:** 在 `src/main/resources/templates/error/` 目录下创建对应的错误页面，如 `404.html`、`500.html`。

---

## 部署运维相关

### Q21: 如何打包部署？
**A:**
1. 执行 `mvn clean package` 打包
2. 在 `target` 目录下生成 jar 包
3. 上传到服务器
4. 执行 `java -jar newbee-mall-1.0.0-SNAPSHOT.jar` 运行

### Q22: 如何配置生产环境数据库？
**A:** 建议使用 Spring Profile 配置：
1. 创建 `application-prod.properties`
2. 配置生产环境数据库信息
3. 启动时指定 profile：`java -jar app.jar --spring.profiles.active=prod`

### Q23: 如何后台运行服务？
**A:** Linux 环境下：
```bash
nohup java -jar newbee-mall-1.0.0-SNAPSHOT.jar > output.log 2>&1 &
```

### Q24: 上传文件大小限制如何配置？
**A:** 在 `application.properties` 中添加：
```properties
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=100MB
```

### Q25: Session 超时时间如何设置？
**A:** 在 `application.properties` 中配置：
```properties
server.servlet.session.timeout=30m
```

### Q26: 如何配置反向代理（Nginx）？
**A:** Nginx 配置示例：
```nginx
server {
    listen 80;
    server_name your-domain.com;

    location / {
        proxy_pass http://localhost:28089;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

---

## 性能优化相关

### Q27: 如何优化数据库查询性能？
**A:**
1. 为常用查询字段添加索引
2. 使用分页查询避免一次性加载大量数据
3. 合理使用缓存（如 Redis）
4. 优化 SQL 语句，避免 N+1 查询

### Q28: 如何添加缓存？
**A:** 可以集成 Redis：
1. 添加 spring-boot-starter-data-redis 依赖
2. 配置 Redis 连接信息
3. 使用 @Cacheable 注解标注需要缓存的方法

### Q29: 如何监控应用状态？
**A:** 可以集成 Spring Boot Actuator：
1. 添加 spring-boot-starter-actuator 依赖
2. 配置端点访问权限
3. 访问 `/actuator/health` 查看健康状态

---

## 安全相关

### Q30: 密码是如何加密的？
**A:** 项目使用 MD5 加密存储密码，相关代码在 `MD5Util` 工具类中。建议生产环境使用更安全的加密方式如 BCrypt。

### Q31: 如何防止 SQL 注入？
**A:** 项目使用 MyBatis 的参数绑定（PreparedStatement），可以有效防止 SQL 注入。

### Q32: Session 安全如何保障？
**A:**
1. 设置合理的 Session 超时时间
2. 使用 HTTPS 传输
3. 关键操作添加二次验证
4. 登录拦截器验证用户身份

---

## 常见错误排查

### Q33: 验证码显示不出来？
**A:**
1. 检查 hutool-captcha 依赖是否正确引入
2. 检查浏览器是否禁用了图片加载
3. 查看控制台是否有报错信息

### Q34: 文件上传失败？
**A:**
1. 检查上传文件大小是否超过限制
2. 检查上传目录是否存在且有写权限
3. 查看日志获取详细错误信息

### Q35: 分页查询数据不准确？
**A:**
1. 检查分页参数是否正确传递
2. 检查 SQL 中的 LIMIT 和 OFFSET 是否正确
3. 验证总数查询是否与分页查询条件一致

---

## 更多帮助

如果以上 FAQ 没有解决您的问题，可以通过以下方式获取帮助：

- **GitHub Issues**: https://github.com/newbee-ltd/newbee-mall/issues
- **QQ 交流群**: 796794009、719099151
- **邮箱**: 2449207463@qq.com
- **掘金小册**: https://juejin.cn/book/6844733814074245133

---

**最后更新时间**: 2025-10-23

/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.common;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import ltd.newbee.mall.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@Controller
public class CommonController {

    @GetMapping("/common/kaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/png");

        ShearCaptcha shearCaptcha= CaptchaUtil.createShearCaptcha(150, 30, 4, 2);

        // 验证码存入session
        httpServletRequest.getSession().setAttribute("verifyCode", shearCaptcha);

        // 输出图片流
        shearCaptcha.write(httpServletResponse.getOutputStream());
    }

    @GetMapping("/common/mall/kaptcha")
    public void mallKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/png");

        ShearCaptcha shearCaptcha= CaptchaUtil.createShearCaptcha(110, 40, 4, 2);

        // 验证码存入session
        httpServletRequest.getSession().setAttribute(Constants.MALL_VERIFY_CODE_KEY, shearCaptcha);

        // 输出图片流
        shearCaptcha.write(httpServletResponse.getOutputStream());
    }
}

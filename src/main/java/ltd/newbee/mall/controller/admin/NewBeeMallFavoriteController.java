/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.admin;

import ltd.newbee.mall.service.UserFavoriteService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户收藏统计管理控制器
 *
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
@Controller
@RequestMapping("/admin")
public class NewBeeMallFavoriteController {

    @Resource
    private UserFavoriteService userFavoriteService;

    @GetMapping("/favorites")
    public String favoritesPage(HttpServletRequest request) {
        request.setAttribute("path", "favorites");
        return "admin/newbee_mall_favorite";
    }

    /**
     * 获取收藏统计概览
     */
    @RequestMapping(value = "/favorites/statistics", method = RequestMethod.GET)
    @ResponseBody
    public Result getStatistics() {
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("totalFavorites", userFavoriteService.getAllFavoritesCount());
        statistics.put("totalUsers", userFavoriteService.getFavoriteUsersCount());
        statistics.put("totalGoods", userFavoriteService.getFavoriteGoodsCount());
        return ResultGenerator.genSuccessResult(statistics);
    }

    /**
     * 获取用户收藏列表
     */
    @RequestMapping(value = "/favorites/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userFavoriteService.getFavoriteStatistics(pageUtil));
    }

    /**
     * 获取商品收藏统计
     */
    @RequestMapping(value = "/favorites/goodsStats", method = RequestMethod.GET)
    @ResponseBody
    public Result goodsStats(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userFavoriteService.getGoodsFavoriteStats(pageUtil));
    }

    /**
     * 获取用户收藏统计
     */
    @RequestMapping(value = "/favorites/userStats", method = RequestMethod.GET)
    @ResponseBody
    public Result userStats(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(userFavoriteService.getUserFavoriteStats(pageUtil));
    }
}
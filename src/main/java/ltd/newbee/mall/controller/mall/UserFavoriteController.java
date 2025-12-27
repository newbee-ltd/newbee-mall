/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.UserFavoriteService;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserFavoriteController {

    @Autowired
    private UserFavoriteService userFavoriteService;

    @PostMapping("/favorites")
    @ResponseBody
    public Result saveFavorite(@RequestBody Long goodsId, HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if (user == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        if (ObjectUtils.isEmpty(goodsId) || goodsId < 1) {
            return ResultGenerator.genFailResult("参数异常");
        }
        String saveResult = userFavoriteService.saveUserFavorite(user.getUserId(), goodsId);
        //添加成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //添加失败
        return ResultGenerator.genFailResult(saveResult);
    }

    @DeleteMapping("/favorites")
    @ResponseBody
    public Result deleteFavorite(@RequestParam Long goodsId, HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if (user == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        if (ObjectUtils.isEmpty(goodsId) || goodsId < 1) {
            return ResultGenerator.genFailResult("参数异常");
        }
        if (userFavoriteService.deleteUserFavorite(user.getUserId(), goodsId)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("取消收藏失败");
        }
    }

    @GetMapping("/favorites")
    @ResponseBody
    public Result getFavorites(@RequestParam(defaultValue = "1") Integer pageNumber,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if (user == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        int start = (pageNumber - 1) * pageSize;
        List<NewBeeMallGoods> list = userFavoriteService.getUserFavorites(user.getUserId(), start, pageSize);
        int total = userFavoriteService.getUserFavoriteCount(user.getUserId());
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/favorites/check")
    @ResponseBody
    public Result checkFavorite(@RequestParam Long goodsId, HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if (user == null) {
            return ResultGenerator.genFailResult("请先登录");
        }
        if (ObjectUtils.isEmpty(goodsId) || goodsId < 1) {
            return ResultGenerator.genFailResult("参数异常");
        }
        boolean isFavorite = userFavoriteService.isFavorite(user.getUserId(), goodsId);
        return ResultGenerator.genSuccessResult(isFavorite);
    }
}
package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallFavoriteGoodsVO;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.NewBeeMallUser;
import ltd.newbee.mall.entity.NewBeeMallUserFavorite;
import ltd.newbee.mall.service.NewBeeMallGoodsService;
import ltd.newbee.mall.service.NewBeeMallUserFavoriteService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    @Resource
    private NewBeeMallUserFavoriteService favoriteService;

    @Resource
    private NewBeeMallGoodsService goodsService;

    // 添加收藏
    @PostMapping
    @ResponseBody
    public Result addFavorite(@RequestParam Long goodsId, HttpSession session) {
        NewBeeMallUser user = (NewBeeMallUser) session.getAttribute("newBeeMallUser");
        if (user == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NOT_LOGIN.getResult());
        }

        boolean result = favoriteService.addFavorite(user.getUserId(), goodsId);
        if (result) {
            return ResultGenerator.genSuccessResult("收藏成功");
        } else {
            return ResultGenerator.genFailResult("收藏失败");
        }
    }

    // 取消收藏
    @DeleteMapping
    @ResponseBody
    public Result removeFavorite(@RequestParam Long goodsId, HttpSession session) {
        NewBeeMallUser user = (NewBeeMallUser) session.getAttribute("newBeeMallUser");
        if (user == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.NOT_LOGIN.getResult());
        }

        boolean result = favoriteService.removeFavorite(user.getUserId(), goodsId);
        if (result) {
            return ResultGenerator.genSuccessResult("取消收藏成功");
        } else {
            return ResultGenerator.genFailResult("取消收藏失败");
        }
    }

    // 检查是否已收藏
    @GetMapping("/check")
    @ResponseBody
    public Result checkFavorite(@RequestParam Long goodsId, HttpSession session) {
        NewBeeMallUser user = (NewBeeMallUser) session.getAttribute("newBeeMallUser");
        if (user == null) {
            return ResultGenerator.genSuccessResult(false);
        }

        boolean isFavorite = favoriteService.isFavorite(user.getUserId(), goodsId);
        return ResultGenerator.genSuccessResult(isFavorite);
    }

    // 我的收藏页面
    @GetMapping("/list")
    public String favoriteList(HttpSession session, Model model) {
        NewBeeMallUser user = (NewBeeMallUser) session.getAttribute("newBeeMallUser");
        if (user == null) {
            return "mall/login";
        }

        List<NewBeeMallUserFavorite> favoriteList = favoriteService.getFavoriteList(user.getUserId());
        List<NewBeeMallFavoriteGoodsVO> favoriteGoodsList = new ArrayList<>();

        for (NewBeeMallUserFavorite favorite : favoriteList) {
            NewBeeMallGoods goods = goodsService.getNewBeeMallGoodsById(favorite.getGoodsId());
            if (goods != null) {
                NewBeeMallFavoriteGoodsVO favoriteGoodsVO = new NewBeeMallFavoriteGoodsVO();
                BeanUtil.copyProperties(goods, favoriteGoodsVO);
                favoriteGoodsVO.setCreateTime(favorite.getCreateTime());
                favoriteGoodsList.add(favoriteGoodsVO);
            }
        }

        model.addAttribute("favoriteGoodsList", favoriteGoodsList);
        return "mall/favorite";
    }
}
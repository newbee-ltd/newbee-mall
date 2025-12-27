/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.UserFavorite;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

public interface UserFavoriteService {

    /**
     * 收藏商品
     *
     * @param userId
     * @param goodsId
     * @return
     */
    String saveUserFavorite(Long userId, Long goodsId);

    /**
     * 取消收藏
     *
     * @param userId
     * @param goodsId
     * @return
     */
    Boolean deleteUserFavorite(Long userId, Long goodsId);

    /**
     * 获取收藏列表
     *
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    List<NewBeeMallGoods> getUserFavorites(Long userId, int start, int limit);

    /**
     * 获取收藏数量
     *
     * @param userId
     * @return
     */
    int getUserFavoriteCount(Long userId);

    /**
     * 是否已收藏
     *
     * @param userId
     * @param goodsId
     * @return
     */
    Boolean isFavorite(Long userId, Long goodsId);

    /**
     * 获取收藏统计列表
     *
     * @param pageUtil
     * @return
     */
    PageResult getFavoriteStatistics(PageQueryUtil pageUtil);

    /**
     * 获取商品收藏统计
     *
     * @param pageUtil
     * @return
     */
    PageResult getGoodsFavoriteStats(PageQueryUtil pageUtil);

    /**
     * 获取用户收藏统计
     *
     * @param pageUtil
     * @return
     */
    PageResult getUserFavoriteStats(PageQueryUtil pageUtil);
}
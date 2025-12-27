/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.UserFavoriteMapper;
import ltd.newbee.mall.dao.NewBeeMallGoodsMapper;
import ltd.newbee.mall.entity.UserFavorite;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.service.UserFavoriteService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserFavoriteServiceImpl implements UserFavoriteService {

    @Autowired
    private UserFavoriteMapper userFavoriteMapper;

    @Autowired
    private NewBeeMallGoodsMapper newBeeMallGoodsMapper;

    @Override
    public String saveUserFavorite(Long userId, Long goodsId) {
        UserFavorite temp = userFavoriteMapper.selectByUserIdAndGoodsId(userId, goodsId);
        if (temp != null) {
            return ServiceResultEnum.FAVORITE_REPEAT.getResult();
        }
        NewBeeMallGoods newBeeMallGoods = newBeeMallGoodsMapper.selectByPrimaryKey(goodsId);
        //商品为空
        if (newBeeMallGoods == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(userId);
        userFavorite.setGoodsId(goodsId);
        userFavorite.setCreateTime(new Date());
        if (userFavoriteMapper.insertSelective(userFavorite) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Boolean deleteUserFavorite(Long userId, Long goodsId) {
        return userFavoriteMapper.deleteByUserIdAndGoodsId(userId, goodsId) > 0;
    }

    @Override
    public List<NewBeeMallGoods> getUserFavorites(Long userId, int start, int limit) {
        List<NewBeeMallGoods> list = userFavoriteMapper.selectFavoriteGoodsByUserId(userId, start, limit);
        if (!CollectionUtils.isEmpty(list)) {
            return list;
        }
        return null;
    }

    @Override
    public int getUserFavoriteCount(Long userId) {
        return userFavoriteMapper.selectCountByUserId(userId);
    }

    @Override
    public Boolean isFavorite(Long userId, Long goodsId) {
        UserFavorite userFavorite = userFavoriteMapper.selectByUserIdAndGoodsId(userId, goodsId);
        return userFavorite != null;
    }

    @Override
    public PageResult getFavoriteStatistics(PageQueryUtil pageUtil) {
        List<UserFavorite> favoriteList = userFavoriteMapper.selectAllFavorites(pageUtil);
        int total = userFavoriteMapper.selectAllFavoritesCount();
        PageResult pageResult = new PageResult(favoriteList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public PageResult getGoodsFavoriteStats(PageQueryUtil pageUtil) {
        List<Map<String, Object>> statsList = userFavoriteMapper.selectGoodsFavoriteStats(pageUtil);
        int total = userFavoriteMapper.selectGoodsFavoriteStatsCount();
        PageResult pageResult = new PageResult(statsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public PageResult getUserFavoriteStats(PageQueryUtil pageUtil) {
        List<Map<String, Object>> statsList = userFavoriteMapper.selectUserFavoriteStats(pageUtil);
        int total = userFavoriteMapper.selectUserFavoriteStatsCount();
        PageResult pageResult = new PageResult(statsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public int getAllFavoritesCount() {
        return userFavoriteMapper.selectAllFavoritesCount();
    }

    @Override
    public int getFavoriteUsersCount() {
        return userFavoriteMapper.selectFavoriteUsersCount();
    }

    @Override
    public int getFavoriteGoodsCount() {
        return userFavoriteMapper.selectFavoriteGoodsCount();
    }
}
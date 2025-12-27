/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.UserFavorite;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserFavoriteMapper {
    int deleteByPrimaryKey(Long favoriteId);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    UserFavorite selectByPrimaryKey(Long favoriteId);

    UserFavorite selectByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    List<UserFavorite> selectByUserId(@Param("userId") Long userId, @Param("limit") int limit);

    int selectCountByUserId(Long userId);

    int updateByPrimaryKeySelective(UserFavorite record);

    int updateByPrimaryKey(UserFavorite record);

    int deleteByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    List<NewBeeMallGoods> selectFavoriteGoodsByUserId(@Param("userId") Long userId, @Param("start") int start, @Param("limit") int limit);

    List<UserFavorite> selectAllFavorites(PageQueryUtil pageUtil);

    int selectAllFavoritesCount();

    List<Map<String, Object>> selectGoodsFavoriteStats(PageQueryUtil pageUtil);

    int selectGoodsFavoriteStatsCount();

    List<Map<String, Object>> selectUserFavoriteStats(PageQueryUtil pageUtil);

    int selectUserFavoriteStatsCount();

    int selectFavoriteUsersCount();

    int selectFavoriteGoodsCount();
}
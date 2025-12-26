package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.NewBeeMallUserFavorite;

import java.util.List;

public interface NewBeeMallUserFavoriteService {
    // 添加收藏
    boolean addFavorite(Long userId, Long goodsId);

    // 取消收藏
    boolean removeFavorite(Long userId, Long goodsId);

    // 查询用户是否收藏了该商品
    boolean isFavorite(Long userId, Long goodsId);

    // 查询用户的收藏列表
    List<NewBeeMallUserFavorite> getFavoriteList(Long userId);
}
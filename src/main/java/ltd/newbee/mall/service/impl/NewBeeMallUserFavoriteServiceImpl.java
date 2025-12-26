package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.dao.NewBeeMallUserFavoriteMapper;
import ltd.newbee.mall.entity.NewBeeMallUserFavorite;
import ltd.newbee.mall.service.NewBeeMallUserFavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NewBeeMallUserFavoriteServiceImpl implements NewBeeMallUserFavoriteService {

    @Resource
    private NewBeeMallUserFavoriteMapper favoriteMapper;

    @Override
    public boolean addFavorite(Long userId, Long goodsId) {
        // 检查是否已经收藏
        NewBeeMallUserFavorite existingFavorite = favoriteMapper.selectByUserIdAndGoodsId(userId, goodsId);
        if (existingFavorite != null) {
            // 已经收藏，直接返回true
            return true;
        }

        // 新增收藏
        NewBeeMallUserFavorite favorite = new NewBeeMallUserFavorite();
        favorite.setUserId(userId);
        favorite.setGoodsId(goodsId);
        favorite.setCreateTime(new Date());
        return favoriteMapper.insertSelective(favorite) > 0;
    }

    @Override
    public boolean removeFavorite(Long userId, Long goodsId) {
        return favoriteMapper.deleteByUserIdAndGoodsId(userId, goodsId) > 0;
    }

    @Override
    public boolean isFavorite(Long userId, Long goodsId) {
        return favoriteMapper.selectByUserIdAndGoodsId(userId, goodsId) != null;
    }

    @Override
    public List<NewBeeMallUserFavorite> getFavoriteList(Long userId) {
        return favoriteMapper.selectByUserId(userId);
    }
}
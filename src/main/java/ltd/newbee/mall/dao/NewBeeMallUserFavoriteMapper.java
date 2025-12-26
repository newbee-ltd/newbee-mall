package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.NewBeeMallUserFavorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewBeeMallUserFavoriteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewBeeMallUserFavorite record);

    int insertSelective(NewBeeMallUserFavorite record);

    NewBeeMallUserFavorite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewBeeMallUserFavorite record);

    int updateByPrimaryKey(NewBeeMallUserFavorite record);

    // 根据用户ID和商品ID查询收藏记录
    NewBeeMallUserFavorite selectByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    // 根据用户ID查询收藏列表（按时间倒序）
    List<NewBeeMallUserFavorite> selectByUserId(@Param("userId") Long userId);

    // 根据用户ID和商品ID删除收藏记录
    int deleteByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);
}
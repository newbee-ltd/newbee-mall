/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.GoodsImageEntity;
import ltd.newbee.mall.entity.GoodsInfo;
import ltd.newbee.mall.entity.GoodsPageEntity;
import ltd.newbee.mall.entity.GoodsQa;
import ltd.newbee.mall.entity.GoodsReview;

import ltd.newbee.mall.entity.InsertGoodsReview;
import ltd.newbee.mall.entity.InsertSearchHistoryEntity;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.RecentChkHistory;
import ltd.newbee.mall.entity.SearchHistoryEntity;
import ltd.newbee.mall.entity.StockNumDTO;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface NewBeeMallGoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(NewBeeMallGoods record);

    int insertSelective(NewBeeMallGoods record);

    NewBeeMallGoods selectByPrimaryKey(Long goodsId);

    NewBeeMallGoods selectByCategoryIdAndName(@Param("goodsName") String goodsName, @Param("goodsCategoryId") Long goodsCategoryId);

    int updateByPrimaryKeySelective(NewBeeMallGoods record);

    int updateByPrimaryKeyWithBLOBs(NewBeeMallGoods record);

    int updateByPrimaryKey(NewBeeMallGoods record);

    List<NewBeeMallGoods> findNewBeeMallGoodsList(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoods(PageQueryUtil pageUtil);

    List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds);

    List<NewBeeMallGoods> findNewBeeMallGoodsListBySearch(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoodsBySearch(PageQueryUtil pageUtil);

    int batchInsert(@Param("newBeeMallGoodsList") List<NewBeeMallGoods> newBeeMallGoodsList);

    int updateStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    int batchUpdateSellStatus(@Param("orderIds")Long[] orderIds,@Param("sellStatus") int sellStatus);
    
    GoodsInfo getGoodsInfoByPK(Long id);
    
    ArrayList<GoodsImageEntity> getGoodsImageByPk(Long goodsId);
    
    ArrayList<NewBeeMallGoods>getGoodsPage(Map<String,Object>params2);
    

    ArrayList<GoodsQa> getGoodsQa(Map<String,Object>params);

//    ArrayList<GoodsQa> getGoodsQa(String orderBy);

    
    ArrayList<GoodsReview> getGoodsReview(Map<String,Object>params);
    
    Double getRateAvg(Long goodsId);
    
    Long getReviewCount(Long goodsId);
    
    Long [] getRateCount(Long goodsId);
    
    int insertGoodsReview(InsertGoodsReview review);
    
    ArrayList<String> getSearchHistory();
    
    int insertSearchHistory(InsertSearchHistoryEntity history);
    
    ArrayList<String> getGoodsName(String keyword);
    
    ArrayList<RecentChkHistory> getRecentChkHistory();
    
    Long getGoodsQaCount(Long goodsId);

}